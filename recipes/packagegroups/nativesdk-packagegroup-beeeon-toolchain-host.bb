SUMMARY = "Host packages for BeeeOn SDK"

LICENSE = "MIT"

inherit packagegroup nativesdk

# PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS_${PN} += "\
    nativesdk-cmake \
    nativesdk-protobuf \
"
