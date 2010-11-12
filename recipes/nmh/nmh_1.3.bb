DESCRIPTION = "nmh - Message Handling System"
HOMEPAGE = "http://nmh.nongnu.org/"
DEPENDS = "gdbm"
RDEPENDS = "gdbm"

PR = "r0"

SRC_URI = "http://download.savannah.nongnu.org/releases/nmh/nmh-1.3.tar.gz \
	file://add-account.patch;patch=1"

FILES_${PN} += "${libdir}/*"

inherit autotools

PARALLEL_MAKE = ""

EXTRA_OECONF = "--host=arm-linux --with-mts=sendmail sendmailpath=/usr/bin/msmtp"

do_configure() {
	oe_runconf
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

do_stage() {
	install -d  ${STAGING_INCDIR}/nmh
	install -m 0644 ${S}/*.h ${STAGING_INCDIR}/nmh/
	install -d  ${STAGING_INCDIR}/nmh/h
	install -m 0644 ${S}/h/*.h ${STAGING_INCDIR}/nmh/h/
	install -d  ${STAGING_INCDIR}/nmh/sbr
	install -m 0644 ${S}/sbr/libmh.a ${STAGING_INCDIR}/nmh/sbr/
	install -d  ${STAGING_INCDIR}/nmh/config
	install -m 0644 ${S}/config/version.o ${STAGING_INCDIR}/nmh/config/
	install -m 0644 ${S}/config/config.o ${STAGING_INCDIR}/nmh/config/
}

SRC_URI[md5sum] = "a52d1f93e780d7a045207451ce6c9a4e"
SRC_URI[sha256sum] = "9f16848424489b5a9f7c1402c87665dc56dcadecf6e5c44fb608aef0d1b03b47"
