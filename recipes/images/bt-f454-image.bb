# Arago base image
# gives you a small image with package manager
PR ='r5'

require bt-common-image.inc

# The size of the uncompressed ramdisk is 190MB
ROOTFS_SIZE = "184320"

#web server
IMAGE_INSTALL += "apache2 modphp"

#gstreamer
IMAGE_INSTALL += "gstreamer \
                  gst-plugins-base \
                  gst-plugins-good \
                  gst-plugin-jpeg \
                  gst-plugin-ffmpegcolorspace \
                  gst-plugin-tcp \
                  gst-plugin-alsa \
                  gst-plugin-wavenc \
                  gst-plugin-wavparse \
                  gst-plugin-playbin \
                  gst-plugin-decodebin2 \
                  gst-plugin-typefindfunctions \
                  gst-plugin-video4linux2"

#email
DEPENDS = "boost"
IMAGE_INSTALL += "alsa-utils-amixer \
                  nmh \
		  msmtp"

export IMAGE_BASENAME = "bt-f454-image"
