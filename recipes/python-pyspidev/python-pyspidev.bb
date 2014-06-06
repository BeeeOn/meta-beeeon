# FIXME This recipe is a big hack...
DESCRIPTION = "This project contains a python module for interfacing with SPI devices from user space via the spidev linux kernel driver." 
SECTION = "devel/python" 
LICENSE = "Python-style" 
LIC_FILES_CHKSUM = "file://README.md;md5=d493aa971ede72a37ddcac1801ed5793"
HOMEPAGE = "https://github.com/doceme/py-spidev" 
PV = "master"

S = "${WORKDIR}/py-spidev-master"

SRC_URI = "https://github.com/doceme/py-spidev/archive/master.zip"
SRC_URI[md5sum] = "8e58ab0cf53a3af1682519cde0e002a6"
SRC_URI[sha256sum] = "6355c1a44bdd4898dc84a67b75468efb87628ae9a197057db922fb0511a2ee37"

inherit setuptools  
