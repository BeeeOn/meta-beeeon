SUMMARY = "Give sudo rights to 'nagios' group"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
PV = "1.0.1"
PR = "r1"

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
