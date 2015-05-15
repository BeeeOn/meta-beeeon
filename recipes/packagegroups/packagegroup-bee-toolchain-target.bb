SUMMARY = "Target packages for bee SDK"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

RDEPENDS_${PN} += " \
    libpoco-dev \
    openssl-dev \
    systemd-dev \
    dbus-dev \
    dbus-glib-dev \
    mosquitto-lib \
    mosquitto-dev \
    boost-dev \
    python-dev \
"

inherit packagegroup
