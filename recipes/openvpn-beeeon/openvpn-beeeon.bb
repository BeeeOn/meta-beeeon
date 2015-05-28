SUMMARY = "OpenVPN configuration for BeeeOn"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit allarch systemd

SRC_URI = " \
        file://vpn_client_ant-2.conf \
        file://ca.crt \
        file://client.crt \
        file://client.key \
        file://openvpn_ant-2.service \
        "

S = "${WORKDIR}"
SYSTEMD_SERVICE_${PN} = "openvpn_ant-2.service"

do_install() {
        install -d ${D}/etc/openvpn
        install -m 0644 ${S}/vpn_client_ant-2.conf ${S}/ca.crt ${S}/client.crt ${D}/etc/openvpn/
        install -m 0600 ${S}/client.key ${D}/etc/openvpn/

        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_unitdir}/system
}

RDEPENDS_${PN} = "openvpn"
