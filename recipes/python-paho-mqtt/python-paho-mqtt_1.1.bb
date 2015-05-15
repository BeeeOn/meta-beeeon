DESCRIPTION = "Python Paho - MQTT client"
SECTION = "devel/python"
LICENSE = "EPL-1.0 | EDL-1.0"
LIC_FILES_CHKSUM = " \
       file://epl-v10;md5=8d383c379e91d20ba18a52c3e7d3a979 \
       file://edl-v10;md5=c09f121939f063aeb5235972be8c722c \
       "

SRCREV = "22ae9b9bbe98e30c19fbd59f618d78e5bb3267e9"
SRC_URI = "git://git.eclipse.org/gitroot/paho/org.eclipse.paho.mqtt.python.git;branch=${PV}"

SRC_URI[md5sum] = "c270eb5551a02e8ab7a4cbb83e22af"
SRC_URI[sha256sum] = "7b7735efd3b1e2323dc9fcef06080d05f5f18bd0f247f5e9e74a628279de66"

S = "${WORKDIR}/git"

inherit setuptools
