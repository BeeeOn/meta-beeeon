SUMMARY = "BeeeOn Adapter Application module - OpenZWave"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=384700fe47eef8c1ae6deae8204b1554"
DEPENDS = "openzwave libpoco mosquitto"
PV = "0.0.2-fake+git${SRCPV}"

SRCREV = "6b836a0e8014cc30672fb109ad183919347ad2a8"
SRC_URI = "\
    git://github.com/BeeeOn/adaapp-modules.git \
    file://0002-openzwave-fix-include-path-for-openzwave-lib.patch;striplevel=2 \
"

S = "${WORKDIR}/git/OpenZWave"

inherit cmake systemd

SYSTEMD_SERVICE_${PN} = "beeeon-openzwave.service"

EXTRA_OECMAKE = " \
    -DCMAKE_INSTALL_PREFIX=/ \
"

do_install () {
    install -Dm 0755 ${B}/beeeon-openzwave ${D}${bindir}/beeeon-openzwave

    install -Dm 0644 ${S}/service/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_system_unitdir}/${SYSTEMD_SERVICE_${PN}}

    install -d 0755 ${D}/${sysconfdir}/beeeon/openzwave/
    install -m 0644 ${S}/etc/beeeon/openzwave/* ${D}${sysconfdir}/beeeon/openzwave/
}

CONFFILES_${PN} += "\
    ${sysconfdir}/beeeon/* \
"

RREPLACES_${PN} = "beeeon-adaapp-modules"
RCONFLICTS_${PN} = "beeeon-adaapp-modules"
