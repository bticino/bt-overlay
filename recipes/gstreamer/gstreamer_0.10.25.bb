require gstreamer.inc

EXTRA_OECONF += "ac_cv_func_register_printf_function=no --disable-gtk-doc --disable-tests --with-checklibname=check --disable-valgrind --disable-loadsave" 

SRC_URI += " file://0001-Always-return-NULL-for-the-last-buffer-property.patch "

PR = "r3"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

SRC_URI[archive.md5sum] = "88544e034a051baf472983791d233076"
SRC_URI[archive.sha256sum] = "39b2ba7b3bfa8df6d998a9461e7091c27757e36a53e93969d7d9982a56526578"
