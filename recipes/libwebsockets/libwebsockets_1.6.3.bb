SUMMARY = "The C library for lightweight websocket clients and servers"
HOMEPAGE = "https://libwebsockets.org/trac/libwebsockets"
LICENSE = "LGPL-2.1-with-libwebsockets-exception"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6920f94d700b266745ade6c417aba2c4"
NO_GENERIC_LICENSE[LGPL-2.1-with-libwebsockets-exception] = "LICENSE"
DEPENDS = "zlib openssl"

SRC_URI = "https://github.com/warmcat/libwebsockets/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "a3e4efba162c9115da1588e3af960acd"
SRC_URI[sha256sum] = "b3bb6f9cb5dc1992f1ce23e3dc3ad4b3f0915effbe306bea5d95dc02a1d2fab4"

inherit cmake

EXTRA_OECMAKE = "\
    -DLWS_IPV6=${@base_contains('DISTRO_FEATURES', 'ipv6', 'ON', 'OFF', d)} \
    -DLIB_SUFFIX=${@d.getVar('baselib', True).replace('lib', '')} \
    "

PACKAGE_BEFORE_PN += "${PN}-tests"

FILES_${PN}-dev += "/usr/lib/cmake"
FILES_${PN}-tests += "\
    ${bindir} \
    ${datadir} \
    "
