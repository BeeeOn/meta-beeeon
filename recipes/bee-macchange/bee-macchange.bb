SUMMARY = "Bee's MAC Address Change"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "1.0"

SRC_URI = "file://macchange@.service"

S = "${WORKDIR}"
SYSTEMD_SERVICE_${PN} = "macchange@.service"

inherit allarch systemd

do_install () {
        install -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_unitdir}/system
}

RDEPENDS_${PN} = "eeprom-get-mac"

systemd_postinst_${PN} () {
#!/bin/sh -e
if [ x"$D" = "x" ]; then
    # Executed on the device
    systemctl enable macchange@eth0.service
else
    # Executed when image is created
    systemctl --root=$D enable macchange@eth0.service
fi
}
