DESCRIPTION ?= "udev is a program which dynamically creates and removes device nodes from \
/dev/. It responds to /sbin/hotplug device events and requires a 2.6 kernel."
LICENSE = "GPLv2+"

SRC_URI += " \
	   file://udev.rules \
	   file://devfs-udev.rules \
	   file://links.conf \
           file://permissions.rules \
	   file://mount.sh \
	   file://network.sh \
	   file://local.rules \
           file://init"

inherit update-rc.d autotools pkgconfig

PARALLEL_MAKE = ""
UDEV_DEVFS_RULES ?= "0"
PKG_libvolume-id-dev = "libvolume-id-dev"

INITSCRIPT_NAME = "udev"
INITSCRIPT_PARAMS = "start 04 S ."

export CROSS = "${TARGET_PREFIX}"
export HOSTCC = "${BUILD_CC}"
export udevdir ?= "/dev"
export usrbindir := "${bindir}"
export usrsbindir := "${sbindir}"
export etcdir = "${sysconfdir}"
LD = "${CC}"
bindir = "/bin"
sbindir = "/sbin"

UDEV_EXTRAS = "<override me>"
EXTRA_OEMAKE = "-e \
		'EXTRAS=${UDEV_EXTRAS}' \
		'STRIP=echo'"

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev

	install -d ${D}${sysconfdir}/udev/rules.d/

	install -m 0644 ${WORKDIR}/local.rules         ${D}${sysconfdir}/udev/rules.d/local.rules
	install -m 0644 ${WORKDIR}/permissions.rules   ${D}${sysconfdir}/udev/rules.d/permissions.rules
	install -m 0644 ${WORKDIR}/udev.rules          ${D}${sysconfdir}/udev/rules.d/udev.rules
	if [ "${UDEV_DEVFS_RULES}" = "1" ]; then
		install -m 0644 ${WORKDIR}/devfs-udev.rules ${D}${sysconfdir}/udev/rules.d/devfs-udev.rules
	fi

	install -d ${D}${sysconfdir}/udev/scripts/

	install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
	install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts
}

do_stage () {
	autotools_stage_all
        install -m 0644 ${S}/extras/volume_id/lib/libvolume_id.h ${STAGING_INCDIR}
        oe_libinstall -C extras/volume_id/lib -so libvolume_id ${STAGING_LIBDIR}
}

PACKAGES =+ "udev-utils libvolume-id libvolume-id-dev"
FILES_libvolume-id-dev = "${includedir}/libvolume_id.h ${libdir}/libvolume_id.a ${libdir}/libvolume_id.so ${libdir}/pkgconfig/libvolume_id.pc"
FILES_udev-utils = "${usrbindir}/udevinfo ${sbindir}/udevadm ${usrbindir}/udevtest"
FILES_libvolume-id = "${base_libdir}/libvolume_id.so.*"
FILES_${PN} += "${usrbindir}/* ${usrsbindir}/udevd"
FILES_${PN}-dbg += "${usrbindir}/.debug ${usrsbindir}/.debug"
