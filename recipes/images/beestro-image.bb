DESCRIPTION = "Beestro image"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

DEPENDS = "virtual/bootloader"

IMAGE_INSTALL += " \
        bash \
	packagegroup-core-boot \
        kernel-modules \
        openssh-sshd openssh-ssh openssh-scp openssh-sftp openssh-sftp-server \
        libpoco \
        sshfs-fuse \
        cpufrequtils \
        tzdata \
        htop rsync \
        iw wpa-supplicant \
	opkg \
        iptables lsof screen socat sysstat \
        evtest devmem2 procps strace ldd \
        systemd systemd-machine-units udev \
        systemd-network-conf \
        distro-feed-configs \
        e2fsprogs-mke2fs dosfstools sunxi-tools \
        gcc \
        git \
        python python-modules python-pyspidev \
        vim nano \
        which \
        short-commands \
        i2c-tools \
        eeprom-get-mac bee-macchange \
        ethtool \
        openvpn \
        beeeon-adaapp \
"
# XXX Doplnit lmsensors
# XXX Not all python-modules should be included

# Broken:
# ltrace

IMAGE_LINGUAS       = " "

IMAGE_FEATURES += "package-management"

#IMAGE_ROOTFS_SIZE = "102400"
IMAGE_ROOTFS_EXTRA_SPACE = "192000"

export IMAGE_BASENAME = "beestro-image"

ROOTFS_POSTPROCESS_COMMAND += "set_root_passwd;"
set_root_passwd() {
   sed 's%^root:[^:]*:%root:\$6\$xUeDXeRtnp/Vcez\$S4FUy5qNkhDstvUWhEoRByiEyeJtbRtkW5yq.HdNIgN699H0QtU3JqXl9cHKZeeXRdosnS.pErv7D4eS1bl.A/:%' \
       < ${IMAGE_ROOTFS}/etc/shadow \
       > ${IMAGE_ROOTFS}/etc/shadow.new;
   mv ${IMAGE_ROOTFS}/etc/shadow.new ${IMAGE_ROOTFS}/etc/shadow ;
}

inherit image
