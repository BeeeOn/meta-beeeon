# For some reason PRINC is not working here
PR := "${@int(PR) + 3}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
