SUMMARY = "Official Nagios plugins"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "openssl-native libtool-native openssl"

SRC_URI = "http://www.nagios-plugins.org/download/nagios-plugins-${PV}.tar.gz"

SRC_URI[md5sum] = "e199ca874df5723bfaca8c43887b1a79"
SRC_URI[sha256sum] = "c7daf95ecbf6909724258e55a319057b78dcca23b2a6cc0a640b90c90d4feae3"

inherit autotools gettext useradd

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --shell ${base_sbindir}/nologin --user-group nagios"

EXTRA_OECONF += "\
        --with-openssl=${STAGING_INCDIR}/openssl \
        --with-nagios-user=nagios \
        --with-nagios-group=nagios \
        --without-pgsql \
        --without-dbi \
        --without-radius \
        --without-ldap \
        --without-mysql \
	"

do_install() {
	install -d ${D}${libdir}/nagios
	install -m 0755 ${B}/plugins/check_load ${D}${libdir}/nagios/check_load
	install -m 0755 ${B}/plugins/check_disk ${D}${libdir}/nagios/check_disk
	install -m 0755 ${B}/plugins/check_uptime ${D}${libdir}/nagios/check_uptime
}

FILES_${PN} += "${libdir}/nagios"
FILES_${PN}-dbg += "${libdir}/nagios/.debug"

RDEPENDS_${PN} = "openssl"
