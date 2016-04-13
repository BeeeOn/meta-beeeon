# TODO comple statically with POCO and other libraries
SUMMARY = "Adapter Manager - handling of adapter software upgrades"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=a53b0a63c56e7b4c3a8bb2a812b86e73"
DEPENDS = "libpoco protobuf beeeon-manager-core"
PV = "0.3"

SRCREV = "7d4b4916c1d452bbe044b98f96b3ed66e9753cf2"
SRC_URI = "\
    git://github.com/BeeeOn/gateway-man-client \
    file://0001-ini-configure-for-testing-use.patch \
"

S = "${WORKDIR}/git"

inherit cmake systemd

SYSTEMD_SERVICE_${PN} = "beeeon-adaman.service"

EXTRA_OECMAKE = "\
    -DCMAKE_INSTALL_PREFIX=/ \
"

do_install_append () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/etc/systemd/system/beeeon-adaman.service ${D}${systemd_system_unitdir}
}

CONFFILES_${PN} += "/etc/*"
