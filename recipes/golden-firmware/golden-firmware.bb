SUMMARY = "Script to manage SRAM data"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=453eae8b01f673af93dcb53cb5d6005d"
PV = "1.0+git${SRCPV}"

SRCREV = "ef68bd898cefe57578c5da4d19d4026a27685991"
SRC_URI = "${BEEEON_GIT}/adapter-tools.git;branch=master"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${S}/golden-firmware/gftools ${D}${sbindir}
}

do_compile[noexec] = "1"

COMPATIBLE_MACHINE = "(olinuxino-a10lime)"
