# Arago base image
# gives you a small image with package manager

require bt-common-image.inc

# The size of the uncompressed ramdisk is 8MB
ROOTFS_SIZE = "102400"

IMAGE_INSTALL += "task-base-extended"
IMAGE_INSTALL += "apache2 modphp"

export IMAGE_BASENAME = "bt-f453av-image"
