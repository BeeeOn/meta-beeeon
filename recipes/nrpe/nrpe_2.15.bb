SUMMARY = "NRPE remote plugin executor"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "\
    file://LEGAL;md5=66be3407b6fa96f2525babda9453d6a2 \
    file://include/nrpe.h;beginline=7;endline=12;md5=e04e42d1a10bc0e1413bf456f9fb9995 \
    "

DEPENDS = "openssl tcp-wrappers"

SRC_URI = "\
    http://heanet.dl.sourceforge.net/project/nagios/nrpe-2.x/nrpe-${PV}/nrpe-${PV}.tar.gz \
    file://nrpe.service \
    "

SRC_URI[md5sum] = "3921ddc598312983f604541784b35a50"
SRC_URI[sha256sum] = "66383b7d367de25ba031d37762d83e2b55de010c573009c6f58270b137131072"

inherit autotools systemd useradd

SYSTEMD_SERVICE_${PN} = "nrpe.service"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "--system --shell ${base_sbindir}/nologin --user-group nagios"

EXTRA_OECONF += "\
    --enable-command-args \
    --with-ssl-lib=${STAGING_LIBDIR} --with-ssl-inc=${STAGING_INCDIR}/openssl \
    "

do_configure() {
    oe_runconf
}

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${B}/src/nrpe ${D}${sbindir}/nrpe
    install -m 0755 ${B}/src/check_nrpe ${D}${sbindir}/check_nrpe

    install -m 0755 -d ${D}${sysconfdir}/nagios
    install -m 0644 ${B}/sample-config/nrpe.cfg ${D}${sysconfdir}/nagios/nrpe.cfg

    # Change pid directory according to the FHS 3.0
    sed -i -e 's,^\(pid_file=\).*,\1/run/nrpe.pid,' ${D}${sysconfdir}/nagios/nrpe.cfg

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/nrpe.service ${D}${systemd_system_unitdir}
    sed -i -e 's,@SYSCONFDIR@,${sysconfdir},g' \
           -e 's,@SBINDIR@,${sbindir},g' ${D}${systemd_system_unitdir}/nrpe.service
}

CONFFILES_${PN} += "${sysconfdir}/nagios/nrpe.cfg"

RDEPENDS_${PV} = "openssl tcp-wrappers"