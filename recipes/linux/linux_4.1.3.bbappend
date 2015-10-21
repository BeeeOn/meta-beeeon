SRC_URI += "file://0001-Add-spidev-to-the-default-lime-configuration.patch \
	    file://0002-DTS-changes-for-Adapter-board-v1.0.patch \
	    file://0003-Make-BTN_OL-working-at-least-with-polling-driver.patch \
	    file://0004-lime-add-node-for-a-rtc-on-PAN-coordinator.patch \
	    file://0005-lime-add-nodes-for-i2c-1-and-eeproms.patch \
	    file://0006-lime-remove-eeprom-definition-from-dts.patch \
	    file://0007-lime-interrupt-variant-of-gpio-keys-is-working-in-4..patch \
	    file://0010-lime-WIP-on-Adapter-1.2.patch \
	    file://0011-lime-use-gpio-chipselect-for-pan-radio.patch \
	    file://0012-lime-add-pressure-sensor.patch \
	    file://0013-lime-add-adapter-v1.2-leds.patch \
	    file://0014-lime-rename-buttons-and-change-codes.patch \
	    file://0015-lime-fix-leds.patch \
	    "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"
