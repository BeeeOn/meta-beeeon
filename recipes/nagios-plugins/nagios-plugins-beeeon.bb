SUMMARY = "Custom Nagios plugins for BeeeOn"
# FIXME
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

PV = "1.0.2"
SRCREV = "v${PV}"

SRC_URI = "${IOT_GIT}/openembedded/nrpe-plugins.git;branch=master;${IOT_GIT_OPTS}"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
	install -d ${D}${libdir}/nagios
	install -m 0755 ${S}/check_linux_memory ${D}${libdir}/nagios/check_linux_memory
	install -m 0755 ${S}/check_systemd ${D}${libdir}/nagios/check_systemd
}

FILES_${PN} = "${libdir}/nagios"

RDEPENDS_${PN} = "bash bc sudo sudo-nagios-config"

do_compile[noexec] = "1"
