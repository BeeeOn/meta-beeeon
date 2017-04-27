SUMMARY = "BeeeOn Adapter Application module - IO daemon"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=384700fe47eef8c1ae6deae8204b1554"
DEPENDS = "libpoco"
PV = "0.0.1-fake+git${SRCPV}"

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
