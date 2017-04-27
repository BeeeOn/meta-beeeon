SUMMARY = "BeeeOn image"

DEPENDS = "virtual/bootloader"

IMAGE_INSTALL += " \
        bash \
        bluez5 \
        gdb \
	packagegroup-core-boot \
        kernel-modules \
	kernel-image \
	kernel-devicetree \
        openssh-sshd openssh-ssh openssh-scp openssh-sftp openssh-sftp-server \
        libpoco \
        sshfs-fuse \
        cpufrequtils \
        curl \
        crda \
        tzdata \
        htop rsync \
        iw wpa-supplicant \
        hostapd \
	opkg \
        iptables lsof screen socat sysstat \
        tmux \
        evtest devmem2 procps strace ldd \
        systemd systemd-machine-units udev \
        systemd-network-conf \
        distro-feed-configs \
        e2fsprogs-mke2fs dosfstools sunxi-tools \
        python python-modules python-pyspidev \
        vim nano \
        mc \
        which \
        i2c-tools \
        eeprom-get-mac beeeon-macchange \
        ethtool \
        openvpn \
        openvpn-beeeon \
        beeeon-adaapp \
        beeeon-factory \
        fitprotocold \
        mosquitto mosquitto-clients \
        python-paho-mqtt \
        golden-firmware \
        nrpe \
        nagios-plugins \
        nagios-plugins-beeeon \
        python-pyserial \
        openhab \
        openzwave \
        libmpsse \
"

# Python modules for WMBUS
IMAGE_INSTALL += "\
    python-bitstring \
    python-pyusb \
"

# Python modules for D-Link WiFi gadgets
IMAGE_INSTALL += "\
    python-lxml \
"

# XXX Doplnit lmsensors
# XXX Not all python-modules should be included

# Broken:
# ltrace

IMAGE_CLASSES += "sdcard_image-beeeon"
IMAGE_FSTYPES += "beeeon-sdimg"
IMAGE_FSTYPES_remove = "sunxi-sdimg"

IMAGE_LINGUAS       = " "

IMAGE_FEATURES += "package-management"

#IMAGE_ROOTFS_SIZE = "102400"
IMAGE_ROOTFS_EXTRA_SPACE = "1024000"

export IMAGE_BASENAME = "beeeon-image"

ROOTFS_POSTPROCESS_COMMAND += "set_root_passwd;disable_beeeon_adaapp;"
set_root_passwd() {
   sed 's%^root:[^:]*:%root:\$6\$xUeDXeRtnp/Vcez\$S4FUy5qNkhDstvUWhEoRByiEyeJtbRtkW5yq.HdNIgN699H0QtU3JqXl9cHKZeeXRdosnS.pErv7D4eS1bl.A/:%' \
       < ${IMAGE_ROOTFS}/etc/shadow \
       > ${IMAGE_ROOTFS}/etc/shadow.new;
   mv ${IMAGE_ROOTFS}/etc/shadow.new ${IMAGE_ROOTFS}/etc/shadow ;
}
disable_beeeon_adaapp() {
    rm ${IMAGE_ROOTFS}/etc/systemd/system/multi-user.target.wants/beeeon-adaapp.service
}

inherit image
