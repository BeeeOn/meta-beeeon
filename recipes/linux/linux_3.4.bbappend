# For some reason PRINC is not working here
PR := "${@int(PR) + 2}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
