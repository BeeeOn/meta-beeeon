SUMMARY = "Adapter Manager - handling of adapter software upgrades (core part)"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=e2c6cbed4654f882832b6d28c4454eca"
DEPENDS = "libpoco protobuf protobuf-native"
PV = "0.3"

SRCREV = "373630be85e3a64270648cd897d46a15ff8d4a15"
SRC_URI = "git://github.com/BeeeOn/gateway-man-core"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "\
    -DCMAKE_INSTALL_PREFIX=/ \
"
