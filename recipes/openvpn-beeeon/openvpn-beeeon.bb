SUMMARY = "OpenVPN configuration for BeeeOn"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
PV = "1.1"
PR = "r1"

inherit allarch systemd

SRC_URI = "\
    file://vpn_client_ant-2.conf \
    file://ca.crt \
    file://openvpn_ant-2.service \
"

S = "${WORKDIR}"
SYSTEMD_SERVICE_${PN} = "openvpn_ant-2.service"

do_install() {
    install -d ${D}/etc/openvpn
    install -m 0644 ${S}/vpn_client_ant-2.conf ${S}/ca.crt ${D}/etc/openvpn/

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_system_unitdir}
}

RDEPENDS_${PN} = "openvpn"
