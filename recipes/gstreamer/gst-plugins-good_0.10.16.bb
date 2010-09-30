require gst-plugins.inc

SRC_URI += "\
  file://0001-rtph264pay-fix-for-streaming-encode.patch \
  file://0002-v4l2src-add-input-src-property-to-specify-capture-in.patch \
  file://0003-v4l2src-keep-track-of-the-input-ID-that-will-be-used.patch \
  file://0004-v4l2src-make-sure-capture-buffer-size-is-aligned-on-.patch \
  file://0005-osssink-handle-all-supported-sample-rates.patch \
  file://0006-v4l2src-add-support-for-DaVinci-platforms-using-MVL-.patch \
  file://0007-v4l2src-support-NV12-capture-on-DM365-using-the-IPIP.patch \
  file://0008-v4l2src-accept-EPERM-as-a-non-fatal-error-for-VIDIOC.patch \
  file://0009-v4l2src-try-progressive-mode-first-for-component-inp.patch \
  file://0010-v4l2src-add-support-for-NV16-colorspace.patch \
  file://0011-v4l2src-set-bytesperline-and-sizeimage-before-callin.patch \
  file://0012-v4l2src-update-gst_v4l2_get_norm-to-handle-DM6467T-a.patch \
  file://0013-v4l2src-add-V4L2-ioctl-calls-to-initialize-capture-d.patch \
  file://0014-v4l2src-disable-video-device-polling-by-default-on-D.patch \
"
SRC_URI[md5sum] = "f0af97464bb6e060a99df39bb21b7a42"
SRC_URI[sha256sum] = "64bd5177913b8ccaa1502e88a255adb3e6024202ba8983e6a956061e57fe1640"

PR = "r4"

OE_ALLOW_INSECURE_DOWNLOADS = "1"

# this recipe depends on kernel
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS += "gst-plugins-base virtual/kernel"

PLATFORM_dm6446        = "dm6446"
PLATFORM_dm6467        = "dm6467"
PLATFORM_omap3         = "omap3530"
PLATFORM_dm355         = "dm355"
PLATFORM_dm365         = "dm365"
PLATFORM_omapl137      = "omapl137"
PLATFORM_omapl138      = "omapl138"
PLATFORM              ?= "<UNDEFINED_PLATFORM>"
CPPFLAGS_append = " -DPlatform_${PLATFORM} -I${STAGING_KERNEL_DIR}/include"

EXTRA_OECONF += "--disable-esd --disable-annodex --disable-x " 

