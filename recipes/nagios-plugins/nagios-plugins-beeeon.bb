SUMMARY = "Custom Nagios plugins for BeeeOn"
LICENSE = "Lunch & GPLv1 & PD"
LIC_FILES_CHKSUM = "\
    file://check_linux_memory;beginline=23;endline=24;md5=20b93567911c9d6e6466437d60ed7524 \
    file://check_network_stats;beginline=4;endline=5;md5=8fdb2bee6752bcc5c9cf60da822c139e \
    file://check_systemd;beginline=2;endline=6;md5=110362454ff54e2fd8261567002554e7 \
"
NO_GENERIC_LICENSE[Lunch] = "check_linux_memory"
PV = "1.0.5"

SRC_URI = "git://github.com/BeeeOn/nagios-plugins-beeeon.git"
SRCREV = "v${PV}"

S = "${WORKDIR}/git"

inherit allarch

do_install() {
	install -d ${D}${libdir}/nagios
	install -m 0755 ${S}/check_linux_memory ${D}${libdir}/nagios/
	install -m 0755 ${S}/check_network_stats ${D}${libdir}/nagios/
	install -m 0755 ${S}/check_systemd ${D}${libdir}/nagios/
}

FILES_${PN} = "${libdir}/nagios"

RDEPENDS_${PN} = "bash bc sudo sudo-nagios-config"
# For check_network_stats
RDEPENDS_${PN} += "perl perl-module-lib perl-module-getopt-std"

do_compile[noexec] = "1"
