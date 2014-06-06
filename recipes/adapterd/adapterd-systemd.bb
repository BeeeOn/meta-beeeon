DESCRIPTION = "Adapter application"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "1.0"

SRC_URI = "file://adapterd.service"

S = "${WORKDIR}"
SYSTEMD_SERVICE_${PN} = "adapterd.service"

inherit allarch systemd

do_install () {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_unitdir}/system
}
