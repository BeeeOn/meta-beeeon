SUMMARY = "BeeeOn script for preparations in a factory"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=453eae8b01f673af93dcb53cb5d6005d"
PV = "0.4+git${SRCPV}"

SRCREV = "ef68bd898cefe57578c5da4d19d4026a27685991"
SRC_URI = "${BEEEON_GIT}/adapter-tools.git;branch=master"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${S}/factory-script/factory_script.py ${D}${bindir}
}

do_compile[noexec] = "1"

RDEPENDS_${PN} = "python-requests"
