SUMMARY = "Simple program to test gpio poll"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://main.c;startline=1;endline=2;md5=832b45dbddad0002080efc54a9323f92"
HOMEPAGE = "https://github.com/8/gpio-poll"

SRC_URI = "file://main.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} -o gpio_poll main.c ${CFLAGS} ${LDFLAGS}
}

do_install() {
    install -d ${D}${bindir}
    install gpio_poll ${D}${bindir}
}
