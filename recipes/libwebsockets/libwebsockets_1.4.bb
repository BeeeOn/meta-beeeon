SUMMARY = "The C library for lightweight websocket clients and servers"
HOMEPAGE = "https://libwebsockets.org/trac/libwebsockets"
# XXX Correct lincese is:
#LICENSE = "LGPL-2.1-with-libwebsockets-exception"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=041a1dec49ec8a22e7f101350fd19550"
DEPENDS = "zlib openssl"

# This rev corresponds to the v1.4-chrome43-firefox-36 tag
SRCREV = "16fb0132cec0fcced29bce6d86eaf94a9beb9785"
SRC_URI = "git://git.libwebsockets.org/libwebsockets"

S = "${WORKDIR}/git"

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
