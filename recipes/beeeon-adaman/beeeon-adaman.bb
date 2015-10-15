# TODO
# - compile statically
SUMMARY = "Adapter Manager - handling of adapter software upgrades"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
DEPENDS = "libpoco"
PV = "1.0.1"

SRCREV = "v${PV}"
SRC_URI = "${IOT_GIT}/adaman-client.git;branch=master;${IOT_GIT_OPTS}"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE_${PN} = "${PN}.service"

inherit cmake systemd

EXTRA_OECMAKE = " \
        -DCMAKE_INSTALL_PREFIX=/ \
        "

do_install_append () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/etc/systemd/system/*.service ${D}${systemd_unitdir}/system

    # FIXME This is fixed in next version
    rm -r ${D}/etc/beeeon/systemd
}

CONFFILES_${PN} += "/etc/*"
