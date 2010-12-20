# Common pieces for Bticino common images

# 4KB per 1 inode should be enough
EXTRA_IMAGECMD_ext3 += "-i 4096"

# Disable this due to distribution restrictions
# DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "\
    ${DISTRO_SSH_DAEMON} \
    angstrom-version \
    "

IMAGE_INSTALL += "libstdc++"
IMAGE_INSTALL += "vsftpd"
IMAGE_INSTALL += "zip unzip"
IMAGE_INSTALL += "devmem2"
IMAGE_INSTALL += "dropbear"
IMAGE_INSTALL += "iperf"
IMAGE_INSTALL += "mtd-utils"
IMAGE_INSTALL += "tzdata"
IMAGE_INSTALL += "libupnp"
IMAGE_INSTALL += "task-base-extended"
IMAGE_INSTALL += "u-boot-utils"
IMAGE_INSTALL += "e2fsprogs-e2fsck"
IMAGE_INSTALL += "dhcp-server"

IMAGE_LINGUAS = ""

inherit image
