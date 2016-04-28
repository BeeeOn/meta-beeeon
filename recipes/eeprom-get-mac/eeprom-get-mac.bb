SUMMARY = "Simple application to get MAC address from I2C EEPROM"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${PN}.c;startline=5;endline=5;md5=fa92ea990d0ea8a4605a441be7df11da"
DEPENDS = "i2c-tools"
PV = "1.1"

SRC_URI = "file://${PN}.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} -o ${PN} ${PN}.c ${CFLAGS} ${LDFLAGS}
}


do_install() {
    install -d ${D}${bindir}
    install ${PN} ${D}${bindir}/`echo ${PN} | tr - _`
}
