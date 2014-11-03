# FIXME This recipe is a big hack...
DESCRIPTION = "This project contains a python module for interfacing with SPI devices from user space via the spidev linux kernel driver." 
SECTION = "devel/python" 
LICENSE = "Python-style" 
LIC_FILES_CHKSUM = "file://README.md;md5=d493aa971ede72a37ddcac1801ed5793"
HOMEPAGE = "https://github.com/doceme/py-spidev" 
PV = "master"

S = "${WORKDIR}/py-spidev-master"

SRC_URI = "https://github.com/doceme/py-spidev/archive/master.zip"
SRC_URI[md5sum] = "cfd7918c004ec052a0126151b66da589"
SRC_URI[sha256sum] = "d2930eb09570c7877b500070009b38209580d22d520fb39cd79e8dbc3930e6ea"

inherit setuptools  
