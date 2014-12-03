/*
 * Read MAC address from I2C EEPROM
 * Heavily based on i2cdump from i2c-tools project
 * Author: tomas-at-novotny-dot-cz, 12/2014
 * License: GPLv2+ (because of i2c-tools)
 */

#include <sys/ioctl.h>
#include <errno.h>
#include <fcntl.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <linux/i2c-dev-user.h>

#define I2C_BUS_NUM		2
#define I2C_EEPROM_ADDR		0x57
#define I2C_EEPROM_RANGE_FIRST	0xf2
#define	I2C_EEPROM_RANGE_LAST	0xf7

#define MISSING_FUNC_FMT	"Error: Adapter does not have %s capability\n"

static int check_funcs(int file, int size, int pec)
{
	unsigned long funcs;

	/* check adapter functionality */
	if (ioctl(file, I2C_FUNCS, &funcs) < 0) {
		fprintf(stderr, "Error: Could not get the adapter "
			"functionality matrix: %s\n", strerror(errno));
		return -1;
	}

	switch(size) {
	case I2C_SMBUS_BYTE:
		if (!(funcs & I2C_FUNC_SMBUS_READ_BYTE)) {
			fprintf(stderr, MISSING_FUNC_FMT, "SMBus receive byte");
			return -1;
		}
		if (!(funcs & I2C_FUNC_SMBUS_WRITE_BYTE)) {
			fprintf(stderr, MISSING_FUNC_FMT, "SMBus send byte");
			return -1;
		}
		break;

	case I2C_SMBUS_BYTE_DATA:
		if (!(funcs & I2C_FUNC_SMBUS_READ_BYTE_DATA)) {
			fprintf(stderr, MISSING_FUNC_FMT, "SMBus read byte");
			return -1;
		}
		break;

	case I2C_SMBUS_WORD_DATA:
		if (!(funcs & I2C_FUNC_SMBUS_READ_WORD_DATA)) {
			fprintf(stderr, MISSING_FUNC_FMT, "SMBus read word");
			return -1;
		}
		break;

	case I2C_SMBUS_BLOCK_DATA:
		if (!(funcs & I2C_FUNC_SMBUS_READ_BLOCK_DATA)) {
			fprintf(stderr, MISSING_FUNC_FMT, "SMBus block read");
			return -1;
		}
		break;

	case I2C_SMBUS_I2C_BLOCK_DATA:
		if (!(funcs & I2C_FUNC_SMBUS_READ_I2C_BLOCK)) {
			fprintf(stderr, MISSING_FUNC_FMT, "I2C block read");
			return -1;
		}
		break;
	}

	if (pec
	 && !(funcs & (I2C_FUNC_SMBUS_PEC | I2C_FUNC_I2C))) {
		fprintf(stderr, "Warning: Adapter does "
			"not seem to support PEC\n");
	}

	return 0;
}

int open_i2c_dev(int i2cbus, char *filename, size_t size, int quiet)
{
        int file;

        snprintf(filename, size, "/dev/i2c/%d", i2cbus);
        filename[size - 1] = '\0';
        file = open(filename, O_RDWR);

        if (file < 0 && (errno == ENOENT || errno == ENOTDIR)) {
                sprintf(filename, "/dev/i2c-%d", i2cbus);
                file = open(filename, O_RDWR);
        }

	return file;
}

int set_slave_addr(int file, int address, int force)
{
        /* With force, let the user read from/write to the registers
           even when a driver is also running */
        if (ioctl(file, force ? I2C_SLAVE_FORCE : I2C_SLAVE, address) < 0) {
                fprintf(stderr,
                        "Error: Could not set address to 0x%02x: %s\n",
                        address, strerror(errno));
                return -errno;
        }

        return 0;
}


int main(int argc, char *argv[])
{
	int i, j, res, i2cbus, address, size, file;
	int bank = 0;
	char filename[20];
	int block[256], s_length = 0;
	int pec = 0, even = 0;
	int force = 0;
	int first = 0x00, last = 0xff;

	i2cbus = I2C_BUS_NUM;
	if (i2cbus < 0) {
		exit(1);
	}

	address = I2C_EEPROM_ADDR;
	if (address < 0) {
		exit(1);
	}
	size = I2C_SMBUS_BYTE_DATA;

	first = I2C_EEPROM_RANGE_FIRST;
	last = I2C_EEPROM_RANGE_LAST;

	file = open_i2c_dev(i2cbus, filename, sizeof(filename), 0);
	if (file < 0
	 || check_funcs(file, size, pec)
	 || set_slave_addr(file, address, force))
		exit(1);

	if (pec) {
		if (ioctl(file, I2C_PEC, 1) < 0) {
			fprintf(stderr, "Error: Could not set PEC: %s\n",
				strerror(errno));
			exit(1);
		}
	}

	/* handle all but word data */
	if (size != I2C_SMBUS_WORD_DATA || even) {
		/* do the block transaction */
		if (size == I2C_SMBUS_BLOCK_DATA
		 || size == I2C_SMBUS_I2C_BLOCK_DATA) {
			unsigned char cblock[288];

			if (size == I2C_SMBUS_BLOCK_DATA) {
				res = i2c_smbus_read_block_data(file, bank,
				      cblock);
			} else {
				for (res = 0; res < 256; res += i) {
					i = i2c_smbus_read_i2c_block_data(file,
						res, 32, cblock + res);
					if (i <= 0) {
						res = i;
						break;
					}
				}
			}
			if (res <= 0) {
				fprintf(stderr, "Error: Block read failed, "
					"return code %d\n", res);
				exit(1);
			}
			if (res >= 256)
				res = 256;
			for (i = 0; i < res; i++)
				block[i] = cblock[i];
			if (size != I2C_SMBUS_BLOCK_DATA)
				for (i = res; i < 256; i++)
					block[i] = -1;
		}

		if (size == I2C_SMBUS_BYTE) {
			res = i2c_smbus_write_byte(file, first);
			if(res != 0) {
				fprintf(stderr, "Error: Write start address "
					"failed, return code %d\n", res);
				exit(1);
			}
		}

		i = first;
		for (j = 0; j <= (last-first); j++) {
			fflush(stdout);
			/* Skip unwanted registers */
			if (i+j < first || i+j > last) {
				if (size == I2C_SMBUS_WORD_DATA) {
					j++;
				}
				continue;
			}

			if (size == I2C_SMBUS_BYTE_DATA) {
				block[i+j] = res =
					i2c_smbus_read_byte_data(file, i+j);
			} else if (size == I2C_SMBUS_WORD_DATA) {
				res = i2c_smbus_read_word_data(file,
						i+j);
				if (res < 0) {
					block[i+j] = res;
					block[i+j+1] = res;
				} else {
					block[i+j] = res & 0xff;
					block[i+j+1] = res >> 8;
				}
			} else if (size == I2C_SMBUS_BYTE) {
				block[i+j] = res =
					i2c_smbus_read_byte(file);
			} else
				res = block[i+j];

			if (size == I2C_SMBUS_BLOCK_DATA
					&& i+j >= s_length) {
				printf("   ");
			} else if (res < 0) {
				printf("XX ");
				if (size == I2C_SMBUS_WORD_DATA)
					printf("XX ");
			} else {
				printf("%02x", block[i+j]);
				if (j != last-first)
					printf("%c", ':');

				if (size == I2C_SMBUS_WORD_DATA)
					printf("%02x ", block[i+j+1]);
			}
			if (size == I2C_SMBUS_WORD_DATA)
				j++;
		}
		printf("\n");
	}
	else {
		exit(1);
	}
	exit(0);
}
