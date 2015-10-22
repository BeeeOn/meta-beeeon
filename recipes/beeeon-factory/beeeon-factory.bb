SUMMARY = "BeeeOn script for preparations in a factory"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "0.2-fake"

SRCREV = "43b7cd896bdab7e369120ca66d6e30ab7b56933c"
SRC_URI = "${IOT_GIT}/adapter-tools.git;branch=master;${IOT_GIT_OPTS}"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/factory_script.py ${D}${bindir}
}

RDEPENDS_${PN} = "python-requests"