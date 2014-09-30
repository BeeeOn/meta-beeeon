require linux.inc
require recipes-kernel/linux/linux-dtb.inc

DESCRIPTION = "Linux kernel for Allwinner a10/a20 processors"

COMPATIBLE_MACHINE = "(olinuxino-a10)"

KERNEL_DEVICETREE_olinuxino-a10 = "sun4i-a10-olinuxino-lime.dtb"

PV = "3.15+gitr${SRCPV}"
PR = "r1"
SRCREV_pn-${PN} = "a076583266dea1fa061478eb2149bb92b4736060"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}_git:"

# git://github.com/jwrdegoede/linux-sunxi.git;branch=sunxi-devel;protocol=git

SRC_URI += "git://github.com/linux-sunxi/linux-sunxi.git;branch=sunxi-devel;protocol=git \
        file://defconfig \
        file://0001-Add-spidev-to-the-default-lime-configuration.patch \
        "

S = "${WORKDIR}/git"
