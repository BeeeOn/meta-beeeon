# Copied from meta-openembedded/meta-oe (we want to enable only a subset of architectures)
DESCRIPTION = "Configuration files for online package repositories aka feeds"
PR = "r3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DISTRO_FEED_PREFIX = "remote-beestro"
DISTRO_FEED_URI = "http://www.fit.vutbr.cz/~inovottom/oe/feed/"
DISTRO_FEED_ARCHS = "all armv7a-vfp-neon ${MACHINE_ARCH}"

do_compile() {
    mkdir -p ${S}/${sysconfdir}/opkg
    for feed in all ${DISTRO_FEED_ARCHS} ; do
        echo "src/gz ${DISTRO_FEED_PREFIX}-${feed} ${DISTRO_FEED_URI}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
    done
}
do_install () {
    install -d ${D}${sysconfdir}/opkg
    install -m 0644 ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

CONFFILES_${PN} += '${@ " ".join( [ ( "${sysconfdir}/opkg/%s-feed.conf" % feed ) for feed in "${DISTRO_FEED_ARCHS}".split() ] ) }'
