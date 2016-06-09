SUMMARY = "FHEM is a GPL'd server for home automation"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://docs/copyright;md5=9f8db68cb70b03c50336fd2983e98db7"
DEPENDS = "perl"

SRC_URI = "\
    http://fhem.de/fhem-${PV}.tar.gz \
    file://0001-Change_install_dir_and_remove_binaries.patch \
"
SRC_URI[md5sum] = "be034463913ea18a3cc67715b44dc714"
SRC_URI[sha256sum] = "179fd251edb0bc7dbd775d7d6597fcfe7df88c2f7b39c5bbecf17defaa6b9539"

do_install() {
	make ROOT=${D}/ install
}

do_configure[noexec] = "1"
do_compile[noexec] = "1"

FILES_${PN} += "${datadir}/fhem"

RDEPENDS_${PN} = "\
    perl-module-compress-zlib \
    perl-module-constant \
    perl-module-data-dumper \
    perl-module-digest-md5 \
    perl-module-if \
    perl-module-io-socket \
    perl-module-math-trig \
    perl-module-posix \
    perl-module-serialport \
    perl-module-time-hires \
    perl-module-time-local \
"
