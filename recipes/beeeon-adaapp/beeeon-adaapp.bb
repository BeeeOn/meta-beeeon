SUMMARY = "Adapter Application - central application of an adapter"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
# poco? ...
#DEPENDS = ""
PV = "2.02"

SRCREV = "e81259c1b90832eb0a2afa73ade7299facb4f73d"
SRC_URI = "${IOT_GIT}/adaapp.git;branch=cmake_install;${IOT_GIT_OPTS}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
        -DCMAKE_INSTALL_PREFIX=/home/beeeon \
        "

FILES_${PN} += "/home/beeeon"
FILES_${PN}-dbg += "/home/beeeon/**/.debug"

RDEPENDS_${PN} = "libpoco"

inherit cmake
