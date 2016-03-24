# Java binary has a wrong path to the linker library, copy library to fix this

FILES_${PN}_append_olinuxino-a10lime = " ${base_libdir}/*"

do_install_append_olinuxino-a10lime() {
	mkdir ${D}${base_libdir}
	cp ${STAGING_DIR_TARGET}/lib/ld-linux.so.3 ${D}${base_libdir}/ld-linux-armhf.so.3
}

PRIVATE_LIBS_olinuxino-a10lime = "ld-linux.so.3"
