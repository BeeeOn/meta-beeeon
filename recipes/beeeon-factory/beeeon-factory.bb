SUMMARY = "BeeeOn script for preparations in a factory"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "0.1-fake"

SRCREV = "cbf233b0b0103f130ba29da20245fb05702ee6f1"
SRC_URI = "${IOT_GIT}/adapter-tools.git;branch=master;${IOT_GIT_OPTS}"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/factory_script.py ${D}${bindir}
}

RDEPENDS_${PN} = "python-requests"
