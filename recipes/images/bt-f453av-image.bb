# Arago base image
# gives you a small image with package manager

require bt-common-image.inc

# The size of the uncompressed ramdisk is 190MB
ROOTFS_SIZE = "184320"

IMAGE_INSTALL += " libstdc++ "
IMAGE_INSTALL += "apache2 modphp"
IMAGE_INSTALL += "gstreamer gst-plugins-base gst-plugins-good gst-plugin-video4linux2"

export IMAGE_BASENAME = "bt-f453av-image"
