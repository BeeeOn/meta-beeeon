SUMMARY = "Network configuration for systemd"
# XXX
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "file://40-wired.network"

S = "${WORKDIR}"

do_install () {
        install -d ${D}/${systemd_unitdir}/network
        install -m 0644 ${S}/*.network ${D}/${systemd_unitdir}/network
}

FILES_${PN} += "${systemd_unitdir}/network"

RDEPENDS_${PN} = "systemd"
