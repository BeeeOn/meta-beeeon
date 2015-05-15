SUMMARY = "An Open Source MQTT v3.1/v3.1.1 Broker"
HOMEPAGE = "http://mosquitto.org/"
SECTION = "libs"
LICENSE = "EPL-1.0 | EDL-1.0"
LIC_FILES_CHKSUM = " \
       file://epl-v10;md5=8d383c379e91d20ba18a52c3e7d3a979 \
       file://edl-v10;md5=c09f121939f063aeb5235972be8c722c \
       "
DEPENDS = "openssl util-linux libwebsockets"
PR = "r2"

SRC_URI = " \
        http://mosquitto.org/files/source/mosquitto-${PV}.tar.gz \
        file://mosquitto.service \
        "
SRC_URI[md5sum] = "2c3b19686c04849ed4b183c63149bfe1"
SRC_URI[sha256sum] = "5ebc3800a0018bfbec62dcc3748fb29f628df068acd39c62c4ef651d9276647e"

SYSTEMD_SERVICE_${PN} = "mosquitto.service"

# TODO
# lib_package.bbclass
# debian.bbclass
# ~/oe/meta/recipes-support/attr/ea-acl.inc

inherit cmake systemd useradd

PARALLEL_MAKE = ""

EXTRA_OECMAKE = "-DWITH_WEBSOCKETS=ON"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "-r -g ${PN} -s /sbin/nologin -d / ${PN}"
GROUPADD_PARAM_${PN} = "-r ${PN}"

RDEPENDS_${PN} = "openssl util-linux-libuuid"

do_install_append () {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_unitdir}/system
}

PACKAGE_BEFORE_PN =+ " \
        ${PN}-lib \
        ${PN}-tools \
        "

FILES_${PN}-lib += "${libdir}"
FILES_${PN}-tools += "${bindir}"

CONFFILES_${PN} += "${sysconfdir}/mosquitto/mosquitto.conf"
