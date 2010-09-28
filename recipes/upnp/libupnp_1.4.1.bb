DESCRIPTION = "The portable SDK for UPnP* Devices (libupnp) provides developers with an API and open source code for building control points, devices, and bridges that are compliant with Version 1.0 of the Universal Plug and Play Device Architecture Specification."
HOMEPAGE = "http://pupnp.sourceforge.net/"
LICENSE = "BSD"

PR = "r1"

LEAD_SONAME = "libupnp"
SRC_URI = "${SOURCEFORGE_MIRROR}/pupnp/${P}.tar.gz \
	file://first.patch;patch=1 \
        file://0001.patch;patch=1 \
        file://0002.patch;patch=1 \
        file://0003.patch;patch=1 \
        file://0005.patch;patch=1 \
        file://0015.patch;patch=1 \
        file://0023.patch;patch=1 \
        file://0028.patch;patch=1"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_configure() {
	./configure --host=arm-linux --prefix=/usr/
}

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "f3b55c24ff77ee6789d758ec1634d5e7"
SRC_URI[sha256sum] = "0c549192c00f5a494032a370ff1cc84f66b752cd756a0d7ba707ee4332137a8a"
