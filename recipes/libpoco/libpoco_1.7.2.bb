SUMMARY = "POCO C++ Libraries"
HOMEPAGE = "http://pocoproject.org"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4267f48fc738f50380cbeeb76f95cebc"

DEPENDS = "expat zlib libpcre openssl sqlite3"

SRC_URI = "https://github.com/pocoproject/poco/archive/poco-${PV}-release.tar.gz"
SRC_URI[md5sum] = "ce09e99c09e3a85370433ad86fc56e35"
SRC_URI[sha256sum] = "cfd311ecbc9e58accf1c4ea70170af88f92f88e73dd14944e528e7f6229e6cab"

S = "${WORKDIR}/poco-poco-${PV}-release"

inherit cmake

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DPOCO_UNBUNDLED=On"

FILES_${PN}-dev += "/usr/lib/cmake"
