SUMMARY = "Script to manage SRAM data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "1.0"
PR = "r1"

SRCREV = "v${PV}"
SRC_URI = "${IOT_GIT}/golden-firmware.git;branch=master;${IOT_GIT_OPTS}"
S = "${WORKDIR}/git"

inherit allarch

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 gftools ${D}${sbindir}
}

COMPATIBLE_MACHINE = "(olinuxino-a10lime)"
