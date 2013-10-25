DESCRIPTION = "Beestro image"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi"

DEPENDS = "virtual/bootloader"

IMAGE_INSTALL += " \
	packagegroup-core-boot \
        kernel-modules \
	openssh-sshd openssh-sftp openssh-sftp-server \
        cpufrequtils \
        tzdata \
        htop \
        iw wpa-supplicant \
	${CONMANPKGS} \
	opkg update-alternatives-cworth \
        iptables lsof screen socat sysstat \
        evtest devmem2 procps strace ltrace ldd \
        systemd systemd-machine-units udev \
        distro-feed-configs \
"

IMAGE_LINGUAS       = " "

IMAGE_FEATURES += "package-management"

#IMAGE_ROOTFS_SIZE = "102400"
IMAGE_ROOTFS_EXTRA_SPACE = "51200"

export IMAGE_BASENAME = "beestro-image"

inherit image
