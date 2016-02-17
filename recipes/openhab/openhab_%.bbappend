# Add OpenHAB systemd service

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://openhab.service"

inherit systemd

SYSTEMD_SERVICE_${PN} = "openhab.service"

do_install_append() {
	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/openhab.service ${D}${systemd_system_unitdir}
}
