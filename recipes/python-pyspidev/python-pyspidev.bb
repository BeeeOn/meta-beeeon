DESCRIPTION = "This project contains a python module for interfacing with SPI devices from user space via the spidev linux kernel driver." 
SECTION = "devel/python" 
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"
HOMEPAGE = "https://github.com/doceme/py-spidev" 
PV = "1c713aaaad1f611d675d9188d2d5a6401fbb8843"

S = "${WORKDIR}/py-spidev-${PV}"

SRC_URI = "https://github.com/doceme/py-spidev/archive/${PV}.zip"
SRC_URI[md5sum] = "58659c8a7913af57dc37599343db05cb"
SRC_URI[sha256sum] = "0c86b6ba86d046fe7462612a858fe800f6a64bca432791b143e13fa25befc474"

inherit setuptools  
