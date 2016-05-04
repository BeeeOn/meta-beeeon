SUMMARY = "Network configuration for systemd"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
PV = "1.0"
PR = "r1"

SRC_URI = "file://40-wired.network"

S = "${WORKDIR}"

inherit allarch

do_install () {
    install -d ${D}/${systemd_unitdir}/network
    install -m 0644 ${S}/*.network ${D}/${systemd_unitdir}/network
}

FILES_${PN} += "${systemd_unitdir}/network"

RDEPENDS_${PN} = "systemd"
