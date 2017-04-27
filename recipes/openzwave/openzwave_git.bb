SUMMARY = "A C++ and DotNet library to control Z-Wave Networks via a Z-Wave Controller"
HOMEPAGE = "http://www.openzwave.com/"
SECTION = "libs"
LICENSE = "LGPL-3.0+ & GPL-3.0 & Apache-2.0"
LIC_FILES_CHKSUM = "\
    file://license/Apache-License-2.0.txt;md5=5dbc052533cb6e0e47352828d40f42f2 \
    file://license/gpl.txt;md5=1c775619c98e9b11e58da29617fc9c9f \
    file://license/lgpl.txt;md5=7be289db0a5cd2c8acf72a8cbd0c15df \
    file://license/license.txt;md5=584c7ddacb8739db77ddcc47bd9d3b52 \
"
DEPENDS = "udev"

SRCREV = "4831788be3a42bf168305d95ce97698b41f9a246"
SRC_URI = "\
    git://github.com/OpenZWave/open-zwave.git \
    file://0001-Value-.h-fix-include-paths.patch \
    file://0002-platform-.h-fix-include-paths.patch \
    file://0003-platform-unix-.h-fix-include-paths.patch \
"

S = "${WORKDIR}/git"

inherit pkgconfig

EXTRA_OEMAKE = "\
    BITBAKE_ENV=1 \
    DOXYGEN= \
    PREFIX=\"${prefix}\" \
    pkgconfigdir=\"${libdir}/pkgconfig\" \
    instlibdir=\"${libdir}\" \
    sysconfdir=\"${sysconfdir}/openzwave\"\
"

do_install () {
    oe_runmake 'DESTDIR=${D}' install
    rm ${D}/${bindir}/ozw_config
}

do_configure[noexec] = "1"
