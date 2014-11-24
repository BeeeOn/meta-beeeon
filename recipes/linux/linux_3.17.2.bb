require linux.inc
require recipes-kernel/linux/linux-dtb.inc

DESCRIPTION = "Linux kernel for Allwinner a10/a20 processors"

COMPATIBLE_MACHINE = "(olinuxino-a10)"

KERNEL_DEVICETREE_olinuxino-a10 = "sun4i-a10-olinuxino-lime.dtb"

PV = "3.17.2"
PR = "r1"
SRCREV = "906d77a3c6c0578ccb1834875ab53360777b7ff3"

#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}_git:"

SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.17.y \
        file://defconfig \
        file://0001-Add-spidev-to-the-default-lime-configuration.patch \
        file://0002-DTS-changes-for-Adapter-board-v1.0.patch \
        file://0003-Make-BTN_OL-working-at-least-with-polling-driver.patch \
        file://0004-dts-Add-spi0-pins-for-A10.patch \
        file://0005-lime-add-node-for-a-rtc-on-PAN-coordinator.patch \
        file://0006-rtc-ds1307-add-support-for-mcp7940x-chips.patch \
        file://0007-of-add-vendor-prefix-for-Pericom-Technology.patch \
        file://0008-rtc-ds1307-add-device-tree-bindings-documentation.patch \
        file://0009-rtc-ds1307-add-device-tree-support.patch \
        "

S = "${WORKDIR}/git"
