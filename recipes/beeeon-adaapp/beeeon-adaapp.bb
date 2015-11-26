SUMMARY = "BeeeOn Adapter Application - central application of an adapter"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
DEPENDS = "libpoco mosquitto"
PV = "1.3.1"

SRCREV = "v${PV}"
SRC_URI = "\
    ${IOT_GIT}/adaapp.git;branch=master;${IOT_GIT_OPTS} \
    file://0001-ini-configure-for-production-use.patch \
    "

S = "${WORKDIR}/git"

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
    ${sysconfdir}/beeeon/spi.ini \
    ${sysconfdir}/beeeon/tcp.ini \
    ${sysconfdir}/beeeon/virtual_sensor.ini \
    ${sysconfdir}/beeeon/vpt_sensor.ini \
    ${sysconfdir}/beeeon/xmltool.ini \
"

RDEPENDS_${PN} = "libpoco libmosquitto"
RREPLACES_${PN} = "short-commands"

inherit cmake systemd
