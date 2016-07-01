SUMMARY = "Perl SerialPort library"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://SerialPort.pm;startline=11;endline=24;md5=3e7217e9d07fcda4f70118e54e753806"
DEPENDS = "perl"

SRC_URI = "http://www.cpan.org/modules/by-module/Device/Device-SerialPort-${PV}.tar.gz"
SRC_URI[md5sum] = "82c698151f934eb28c65d1838cee7d9e"
SRC_URI[sha256sum] = "d392567cb39b4ea606c0e0acafd8ed72320311b995336ece5fcefcf9b150e9d7"

S = "${WORKDIR}/Device-SerialPort-${PV}"

inherit cpan

do_configure_prepend () {
    mkdir -p m4
    autoreconf -Wcross --verbose --install --force
    sed -i 's:\./configure\(.[^-]\):./configure --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS} --prefix=${prefix} --exec_prefix=${exec_prefix} --bindir=${bindir} --sbindir=${sbindir} --libexecdir=${libexecdir} --datadir=${datadir} --sysconfdir=${sysconfdir} --sharedstatedir=${sharedstatedir} --localstatedir=${localstatedir} --libdir=${libdir} --includedir=${includedir} --oldincludedir=${oldincludedir} --infodir=${infodir} --mandir=${mandir}\1:' Makefile.PL
}

RDEPENDS_${PN} += "\
    perl-module-carp \
    perl-module-posix \
    perl-module-io-handle \
    perl-module-strict \
    perl-module-warnings \
    perl-module-vars \
    perl-module-xsloader \
"
