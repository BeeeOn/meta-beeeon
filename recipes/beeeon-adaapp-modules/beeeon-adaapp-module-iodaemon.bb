SUMMARY = "BeeeOn Adapter Application module - IO daemon"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=7a36c31e50dea05245ab4e98e6c2c4ce"
DEPENDS = "libpoco"
PV = "0.0.2-fake+git${SRCPV}"

SRCREV = "6b836a0e8014cc30672fb109ad183919347ad2a8"
SRC_URI = "\
    git://github.com/BeeeOn/adaapp-modules.git \
"

S = "${WORKDIR}/git/iodaemon"

inherit cmake systemd

SYSTEMD_SERVICE_${PN} = "beeeon-iodaemon.service"

EXTRA_OECMAKE = " \
    -DCMAKE_INSTALL_PREFIX=/ \
"

CONFFILES_${PN} += "\
    ${sysconfdir}/beeeon/* \
"
