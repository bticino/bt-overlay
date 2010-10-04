# Arago base image
# gives you a small image with package manager

require bt-common-image.inc

# The size of the uncompressed ramdisk is 190MB
ROOTFS_SIZE = "184320"

IMAGE_INSTALL += " libstdc++ "
IMAGE_INSTALL += "apache2 modphp"
IMAGE_INSTALL += "gstreamer gst-plugins-base gst-plugins-good gst-plugin-video4linux2"
IMAGE_INSTALL += "busybox"
IMAGE_INSTALL += "alsa-utils"
IMAGE_INSTALL += "base-passwd"
IMAGE_INSTALL += "blueprobe"
IMAGE_INSTALL += "libpcap"
IMAGE_INSTALL += "lrzsz"
IMAGE_INSTALL += "modutils-initscripts"
IMAGE_INSTALL += "openssh"
IMAGE_INSTALL += "portmap ppp procps setserial strace wpa-supplicant base-files"
IMAGE_INSTALL += "libupnp"
IMAGE_INSTALL += "expat"

export IMAGE_BASENAME = "bt-f453av-csl-image"
