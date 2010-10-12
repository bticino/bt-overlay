# Arago base image
# gives you a small image with package manager

require bt-common-image.inc

# The size of the uncompressed ramdisk is 190MB
ROOTFS_SIZE = "184320"

#web server
IMAGE_INSTALL += "apache2 modphp"

#gstreamer
IMAGE_INSTALL += "gstreamer \
                  gst-plugins-base \
                  gst-plugins-good"
# It is also possible to include only the following packages (to grab jpegs):
#                  gst-plugin-jpeg \
#                  gst-plugin-ffmpegcolorspace \
#                  gst-plugin-video4linux2"

export IMAGE_BASENAME = "bt-f453av-image"
