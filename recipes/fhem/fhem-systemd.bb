SUMMARY = "FHEM systemd service"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
PV = "1.0"

SRC_URI = "file://fhem.service"

S = "${WORKDIR}"
SYSTEMD_SERVICE_${PN} = "fhem.service"

inherit allarch systemd

do_install () {
    install -Dm 0644 ${WORKDIR}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_system_unitdir}/${SYSTEMD_SERVICE_${PN}}
}

do_configure[noexec] = "1"
do_compile[noexec] = "1"

RDEPENDS_${PN} = "fhem"
