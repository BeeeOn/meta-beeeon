SUMMARY = "BeeeOn PAN Daemon"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "0.9-fake"

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

pkg_postinst_${PN}() {
    if [ "x$D" = "x" ]; then
        if [ `grep device_table_path -c /etc/beeeon/fitprotocold.ini` -eq 0 ]; then
            echo "device_table_path=/var/lib/beeeon/fitprotocold.devices" >> /etc/beeeon/fitprotocold.ini
        fi
    fi
}

RDEPENDS_${PN} = "libmosquitto libpoco glib-2.0"

inherit systemd
