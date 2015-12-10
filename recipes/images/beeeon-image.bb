DESCRIPTION = "BeeeOn image"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

DEPENDS = "virtual/bootloader"

IMAGE_INSTALL += " \
        bash \
        bluez5 \
        gdb \
	packagegroup-core-boot \
        kernel-modules \
        openssh-sshd openssh-ssh openssh-scp openssh-sftp openssh-sftp-server \
        libpoco \
        sshfs-fuse \
        cpufrequtils \
        curl \
        tzdata \
        htop rsync \
        iw wpa-supplicant \
        hostapd \
	opkg \
        iptables lsof screen socat sysstat \
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
        eeprom-get-mac bee-macchange \
        ethtool \
        openvpn \
        openvpn-beeeon \
        beeeon-adaapp \
        beeeon-adaman \
        beeeon-factory \
        fitprotocold \
        mosquitto mosquitto-clients libmosquitto \
        python-paho-mqtt \
        golden-firmware \
        oracle-jse-jre \
        openhab \
        nrpe \
        nagios-plugins \
        nagios-plugins-beeeon \
"
# XXX Doplnit lmsensors
# XXX Not all python-modules should be included

# Broken:
# ltrace

IMAGE_LINGUAS       = " "

IMAGE_FEATURES += "package-management"

#IMAGE_ROOTFS_SIZE = "102400"
IMAGE_ROOTFS_EXTRA_SPACE = "256000"

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
