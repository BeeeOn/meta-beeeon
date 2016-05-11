SUMMARY = "BeeeOn Adapter Application - central application of an adapter"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e2c6cbed4654f882832b6d28c4454eca"
DEPENDS = "libpoco mosquitto"
PV = "1.7"

SRCREV = "cb88dc386fd54a9fad6edbc3c4fb6e293a34a2ee"
SRC_URI = "\
    git://github.com/BeeeOn/gateway-app.git \
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
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/adapter_files/*.service ${D}${systemd_system_unitdir}

    install -d ${D}${localstatedir}/lib/beeeon

    rmdir ${D}/tmp
}

CONFFILES_${PN} += "\
    ${sysconfdir}/beeeon/* \
"
