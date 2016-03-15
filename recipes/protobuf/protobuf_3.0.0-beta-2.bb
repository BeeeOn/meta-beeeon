# NOTE: This recipe is based on meta-oe/recipes-devtools/protobuf/protobuf_2.6.1.bb, it just retrieves a newer version.

SUMMARY = "Protocol Buffers - structured data serialisation mechanism"
DESCRIPTION = "Protocol Buffers are a way of encoding structured data in an \
efficient yet extensible format. Google uses Protocol Buffers for almost \
all of its internal RPC protocols and file formats."
HOMEPAGE = "https://github.com/google/protobuf"
SECTION = "console/tools"
LICENSE = "BSD-3-Clause"

DEPENDS = "zlib"

LIC_FILES_CHKSUM = "file://LICENSE;md5=35953c752efc9299b184f91bef540095"

SRCREV = "v${PV}"

SRC_URI = "git://github.com/google/protobuf.git"

EXTRA_OECONF += " --with-protoc=echo"

inherit autotools

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"
