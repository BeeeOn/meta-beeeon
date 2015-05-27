SUMMARY = "Support files for AdaApp"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit allarch

do_install() {
        install -d ${D}/home/root
        ln -s /home/beeeon/ ${D}/home/root/actual_version
}

FILES_${PN} += "/home/root/"
