SUMMARY = "Script to manage SRAM data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "1.0+git${SRCPV}-fake"
PR = "r1"

SRCREV = "3115846dc5f1a4c3c4edc1df10f6074d734fd01a"
SRC_URI = "${BEEEON_GIT}/adapter-tools.git;branch=master"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${S}/golden-firmware/gftools ${D}${sbindir}
}

COMPATIBLE_MACHINE = "(olinuxino-a10lime)"
