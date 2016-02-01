SUMMARY = "Give sudo rights to 'nagios' group"
# FIXME
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

PV = "1.0.1"

SRC_URI = "file://10-nagios"

inherit allarch

do_install() {
	install -d ${D}${sysconfdir}/sudoers.d
	install -m 0440 ${WORKDIR}/10-nagios ${D}${sysconfdir}/sudoers.d
}

FILES_${PN} = "${sysconfdir}/sudoers.d"

RDEPENDS_${PN} = "sudo"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
