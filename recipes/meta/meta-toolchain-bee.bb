require recipes-core/meta/meta-toolchain.bb

PV = "0.2"

TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-bee-toolchain-host"
TOOLCHAIN_TARGET_TASK += "packagegroup-bee-toolchain-target"
TOOLCHAIN_OUTPUTNAME = "${SDK_NAME}-toolchain-${PV}"
