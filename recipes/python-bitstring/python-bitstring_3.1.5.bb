SUMMARY = "Simple construction, analysis and modification of binary data"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4680edc365ce7b05888336af92064330"

SRC_URI = "https://github.com/scott-griffiths/bitstring/archive/bitstring-${PV}.tar.gz"

SRC_URI[md5sum] = "ba96be1d2ae5ad35e4263c6a1c8bc310"
SRC_URI[sha256sum] = "b769620c1b52d6c1548c6c4f055613f4eee3120ed8a5cff4ba4ffbbc8a582286"

S = "${WORKDIR}/bitstring-bitstring-${PV}"

inherit setuptools
