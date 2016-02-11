SUMMARY = "BeeeOn Adapter Application - central application of an adapter"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e2c6cbed4654f882832b6d28c4454eca"
DEPENDS = "libpoco mosquitto"
PV = "1.5"

SRCREV = "v${PV}"
SRC_URI = "\
    ${IOT_GIT}/adaapp-new.git;branch=master;${IOT_GIT_OPTS} \
    file://0001-ini-configure-for-production-use.patch \
    "

S = "${WORKDIR}/git"

inherit cmake systemd

SYSTEMD_SERVICE_${PN} = "beeeon-adaapp.service"

EXTRA_OECMAKE = " \
    -DCMAKE_INSTALL_PREFIX=/ \
    "

do_configure_prepend () {
    export FW_VERSION=${SRCREV}
}

do_install_append () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/adapter_files/*.service ${D}${systemd_unitdir}/system

    install -d ${D}${localstatedir}/lib/beeeon
}

# TODO This should be handled automatically, not by listing
CONFFILES_${PN} += "\
    ${sysconfdir}/beeeon/AdaApp.ini \
    ${sysconfdir}/beeeon/mqtt.ini \
    ${sysconfdir}/beeeon/openhab.ini \
    ${sysconfdir}/beeeon/pressure_sensor.ini \
    ${sysconfdir}/beeeon/pan.ini \
    ${sysconfdir}/beeeon/tcp.ini \
    ${sysconfdir}/beeeon/virtual_sensor.ini \
    ${sysconfdir}/beeeon/vpt_sensor.ini \
    ${sysconfdir}/beeeon/xmltool.ini \
"

RDEPENDS_${PN} = "libpoco libmosquitto"
RREPLACES_${PN} = "short-commands"
