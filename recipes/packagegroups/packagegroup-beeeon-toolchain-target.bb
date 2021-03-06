SUMMARY = "Target packages for BeeeOn SDK"

LICENSE = "MIT"

RDEPENDS_${PN} += "\
    cppunit-dev \
    dbus-dev \
    dbus-glib-dev \
    libmosquitto \
    libmpsse-dev \
    libpoco-dev \
    mosquitto-dev \
    openssl-dev \
    openzwave-dev \
    protobuf-dev \
    python-dev \
    systemd-dev \
"

inherit packagegroup
