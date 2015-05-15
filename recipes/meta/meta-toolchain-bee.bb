require recipes-core/meta/meta-toolchain.bb

PV = "0.6"

# It seems that some OE bug is triggered when this prefix is redefined
#SDK_NAME_PREFIX = "sdk-iot"

TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-bee-toolchain-host"
TOOLCHAIN_TARGET_TASK += "packagegroup-bee-toolchain-target"
TOOLCHAIN_OUTPUTNAME = "${SDK_NAME}-${PV}"
