DESCRIPTION = "A program that prints Hello Yocto! every 5 seconds once connected to the Server " 
PRIORITY = "optional" 
SECTION = "examples" 

LICENSE = "GPLv2" 
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6" 

inherit update-rc.d pkgconfig
SRC_URI = "file://helloyocto.py \
	   file://helloyocto.c \
	   file://helloyocto_service.sh"


INITSCRIPT_NAME = "helloyocto_service.sh"
INITSCRIPT_PARAMS = "start 09 S ."


S = "${WORKDIR}"
 
do_compile() { 
	${CC} ${CFLAGS} ${LDFLAGS} helloyocto.c -o helloyocto
} 

do_install() { 
	
	install -d ${D}${bindir} 
	install -m 0755 helloyocto.py ${D}${bindir}
	install -d ${D}${sysconfdir}/init.d
	install -c -m 755 ${WORKDIR}/${INITSCRIPT_NAME}  ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
	install -d ${D}${bindir} 
	install -m 0755 helloyocto ${D}${bindir}

}



