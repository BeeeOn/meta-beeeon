SRC_URI += " \
	file://0001-Enabled-I2C-1-and-I2C-2-in-board-configuration-file.patch \
	file://0002-Added-memory-mappings-to-store-the-SRAM-layout-in-me.patch \
	file://0003-Added-new-commands-for-manipulating-SRAM-data.patch \
	file://0004-Modified-boot-commands-to-boot-from-MMC.patch \
	file://0005-Added-shell-commands-for-evaluating-SRAM-data.patch \
	file://0006-Modified-boot-sequence-execution-based-on-SRAM-evalu.patch \
	file://0007-Lowered-boot-delay-to-1-second.patch \
	file://0008-Disabled-I2C-bus-change-messages.patch \
	file://0009-Disabled-USB-boot-and-USB-keyboard-input.patch \
	file://0010-Modified-default-memory-layout-to-force-normal-boot-.patch \
        "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
