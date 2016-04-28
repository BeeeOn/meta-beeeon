SUMMARY = "BeeeOn MAC address Change"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"
PV = "1.0"

SRC_URI = "file://macchange@.service"

S = "${WORKDIR}"
SYSTEMD_SERVICE_${PN} = "macchange@.service"

inherit allarch systemd

do_install () {
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${S}/${SYSTEMD_SERVICE_${PN}} ${D}${systemd_system_unitdir}
}

# Use custom script otherwise service without eth0 is started (and this produces error)
systemd_postinst_${PN} () {
#!/bin/sh -e
if [ x"$D" = "x" ]; then
    # Executed on the device
    systemctl enable macchange@.service
else
    # Executed when image is created
    systemctl --root=$D enable macchange@.service
fi
}

RDEPENDS_${PN} = "eeprom-get-mac"

RREPLACES_${PN} = "bee-macchange"
RCONFLICTS_${PN} = "bee-macchange"
