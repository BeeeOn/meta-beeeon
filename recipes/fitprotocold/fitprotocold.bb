SUMMARY = "BeeeOn PAN Daemon"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=384700fe47eef8c1ae6deae8204b1554"
DEPENDS = "glib-2.0 libpoco mosquitto"
PV = "0.13+git${SRCPV}-fake"

SRCREV = "30b239fcc906a3e52a604c47e758f0e382ef061c"
SRC_URI = "\
    ${IOT_GIT}/sensors.git;branch=devel-oe-build;${IOT_GIT_OPTS} \
    file://fitprotocold.service \
"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE_${PN} = "fitprotocold.service"

inherit systemd

do_configure[noexec] = "1"

do_compile () {
    ./build.sh -t pan -p hw
}

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_system_unitdir}

    install -d ${D}${bindir}
    install -m 0755 ${S}/build/fitprotocold ${D}${bindir}
}

pkg_postinst_${PN}() {
    if [ "x$D" = "x" ]; then
        if [ `grep device_table_path -c /etc/beeeon/fitprotocold.ini` -eq 0 ]; then
            echo "device_table_path=/var/lib/beeeon/fitprotocold.devices" >> /etc/beeeon/fitprotocold.ini
        fi
    fi
}

RDEPENDS_${PN} = "mosquitto"
