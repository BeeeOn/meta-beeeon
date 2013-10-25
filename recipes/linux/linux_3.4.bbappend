# For some reason PRINC is not working here
PR := "${@int(PR) + 1}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
