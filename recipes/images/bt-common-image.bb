# Arago base image
# gives you a small image with package manager
require bt-common-image.inc

# The size of the uncompressed ramdisk is 190MB
ROOTFS_SIZE = "184320"

IMAGE_INSTALL += "task-base-extended"

export IMAGE_BASENAME = "bt-common-image"
