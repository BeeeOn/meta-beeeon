FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SUNXI_FEX_FILE_olinuxino-a10 = "a10-olinuxino-lime.fex"
SRC_URI =+ "file://${SUNXI_FEX_FILE}"
S = "${WORKDIR}"
