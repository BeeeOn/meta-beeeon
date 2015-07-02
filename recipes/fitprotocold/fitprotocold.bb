SUMMARY = "BeeeOn PAN Daemon"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "0.6-fake"

SRC_URI = "\
    file://fitprotocold \
    file://fitprotocold.service \
    "

S = "${WORKDIR}"

SYSTEMD_SERVICE_${PN} = "fitprotocold.service"

do_install () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_unitdir}/system

    install -d ${D}${bindir}
    install -m 0755 ${S}/fitprotocold ${D}${bindir}
}

RDEPENDS_${PN} = "libmosquitto glib-2.0"

inherit systemd
