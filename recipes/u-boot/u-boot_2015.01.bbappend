SRC_URI += " \
        file://0001-sunxi-bee-Adjust-boot-command-for-our-use-case.patch \
        file://0002-sunxi-bee-Lower-bootdelay.patch \
        "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
