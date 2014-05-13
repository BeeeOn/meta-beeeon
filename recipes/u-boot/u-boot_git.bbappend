SRC_URI += " \
        file://0001-sunxi-bee-Use-lower-debug-level.patch \
        file://0002-sunxi-Enable-watchdog-to-fix-second-reboot-hang-prob.patch \
        "

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
