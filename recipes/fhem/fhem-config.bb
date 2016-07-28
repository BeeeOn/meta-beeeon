SUMMARY = "FHEM default BeeeOn configuration"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
PV = "1.0"

SRC_URI = "file://fhem.cfg"

inherit allarch

do_install() {
    install -Dm 0644 ${WORKDIR}/fhem.cfg ${D}${sysconfdir}/fhem/fhem.cfg
}

RDEPENDS_${PN} = "fhem"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
