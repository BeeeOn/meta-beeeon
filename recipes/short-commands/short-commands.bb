SUMMARY = "Shortcuts to some frequently used commands"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
PV = "1.0"

SRC_URI = " \
        file://adaapp_config_print_adaapp \
        file://adaapp_config_print_spi \
        file://adaapp_config_print_vs \
        file://adaapp_print_log \
        file://adaapp_restart \
        file://adaapp_start \
        file://adaapp_status \
        file://adaapp_stop \
"

S = "${WORKDIR}"

inherit allarch

do_install () {
        install -m 0755 -d ${D}/usr/local/bin
        install -m 0755 ${WORKDIR}/adaapp_* ${D}/usr/local/bin
}

FILES_${PN} =+ " \
        /usr/local/bin/* \
"
