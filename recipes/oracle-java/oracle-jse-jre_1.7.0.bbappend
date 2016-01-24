# Oracle website is not working, use a local mirror to get the package
SRC_URI = "${OE_LOCAL_SHARE}/ejre-7u${PV_UPDATE}-fcs-b${BUILD_NUMBER}-linux-arm-vfp-hflt-client_headless-07_may_2014.tar.gz"

# Java binary has a wrong path to the linker library, create symlink to fix this

FILES_${PN} += "${base_libdir}/*"

do_install_append() {
	mkdir ${D}${base_libdir}
	cp ${STAGING_DIR_TARGET}/lib/ld-linux.so.3 ${D}${base_libdir}/ld-linux-armhf.so.3
}
