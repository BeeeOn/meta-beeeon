SUMMARY = "POCO C++ Libraries"
HOMEPAGE = "http://pocoproject.org"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4267f48fc738f50380cbeeb76f95cebc"

DEPENDS = "expat zlib libpcre openssl sqlite3"

SRC_URI = "https://github.com/pocoproject/poco/archive/poco-${PV}-release.tar.gz"
SRC_URI[md5sum] = "208872b13d282dfb0f0580fc11df96f3"
SRC_URI[sha256sum] = "08bc0a9bae4fb793eb694ad5ec7742c179bad48a286ae614682483021043658b"

S = "${WORKDIR}/poco-poco-${PV}-release"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DPOCO_UNBUNDLED=On"

FILES_${PN}-dev += "/usr/lib/cmake"
