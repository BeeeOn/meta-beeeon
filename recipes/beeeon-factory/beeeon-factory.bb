SUMMARY = "BeeeOn script for preparations in a factory"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "0.3+git${SRCPV}-fake"

SRCREV = "3115846dc5f1a4c3c4edc1df10f6074d734fd01a"
SRC_URI = "${BEEEON_GIT}/adapter-tools.git;branch=master"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/factory-script/factory_script.py ${D}${bindir}
}

RDEPENDS_${PN} = "python-requests"
