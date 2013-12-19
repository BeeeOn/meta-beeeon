# For some reason PRINC is not working here
PR := "${@int(PR) + 5}"

SRC_URI += "file://0001-gpio-sunxi-Add-interrupt-definitions-for-A10s-SoC.patch"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
