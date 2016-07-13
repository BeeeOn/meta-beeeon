SUMMARY = "Open source library for SPI/I2C control via FTDI chips"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://../docs/LICENSE;md5=868443b59d4fc856cbe697394d0795f0"
DEPENDS = "libftdi libusb-compat"
PV = "1.3+${SRCREV}"

S = "${WORKDIR}/${BPN}-${SRCREV}/src"

SRCREV = "a2eafa24a3446a711b13523ec06c17b5a1c6cdc1"
SRC_URI = "\
    https://github.com/devttys0/libmpsse/archive/${SRCREV}.zip \
    file://0001-Fix-compilation-error-caused-by-missing-libftdi-defi.patch \
"
SRC_URI[md5sum] = "c0e4384c57db4e73e3a9db1359787bfa"
SRC_URI[sha256sum] = "946e1f9c095dedf1c2c1a5401d0f157d5a4e4110f868e77f536640bd9f621e5f"

inherit autotools-brokensep

EXTRA_OECONF += "--disable-python"

FILES_${PN} = "${libdir}/${BPN}.so"
FILES_${PN}-dev = "${includedir}"
