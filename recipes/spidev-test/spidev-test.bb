SUMMARY = "Simple program to test spidev"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://spidev_test.c;startline=6;endline=8;md5=e05ee59b782ce96a3fb384cb77aa01b5"
DEPENDS = "linux-libc-headers"

SRC_URI = "file://spidev_test.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} -o spidev_test spidev_test.c ${CFLAGS} ${LDFLAGS} -I${S}/src/include
# -I${STAGING_KERNEL_DIR}/include
}

do_install() {
    install -d ${D}${bindir}
    install spidev_test ${D}${bindir}
}
