# TODO
# - compile statically
SUMMARY = "Adapter Manager - handling of adapter software upgrades"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
# poco? ...
#DEPENDS = ""
PV = "1.0"

SRCREV = "c3ba27064b33ebede52791f49c10685a89ae872f"
SRC_URI = "${IOT_GIT}/adaman-client.git;branch=master;${IOT_GIT_OPTS}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
        -DCMAKE_INSTALL_PREFIX=/home/beeeon \
        "

FILES_${PN} += "/home/beeeon"
FILES_${PN}-dbg += "/home/beeeon/bin/.debug"

CONFFILES_${PN} += "/home/beeeon/etc/*"

RDEPENDS_${PN} = "libpoco"

inherit cmake
