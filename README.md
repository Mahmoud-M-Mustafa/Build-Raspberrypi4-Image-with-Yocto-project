# Raspberrypi4-64 Image build with Yocto

## Yocto Project

The Yocto Project is an open source collaboration project that helps developers create custom Linux-based systems for embedded products, regardless of the hardware architecture. The project provides a flexible set of tools and a space where embedded developers worldwide can share technologies, software stacks, configurations and best practices which can be used to create tailored Linux images for embedded devices.

The project provides a standard to delivering hardware support and software stacks, allowing the interchange of software configurations and builds. The tools allow users to build and support customizations for multiple hardware platforms and software stacks in a maintainable and scalable way.

Historically the project grew from, and works with the OpenEmbedded Project which is where the build system and some of the meta-data are derived.

<br />
<br />

![](https://www.yoctoproject.org/wp-content/uploads/2018/02/yp-diagram-details.png)

 <br />
 <br />
 <br />
  

## THE GENERAL "WORKFLOW" - HOW IT ALL WORKS



![yoctoArch](https://www.yoctoproject.org/wp-content/uploads/2017/07/yp-how-it-works-new-diagram.png)

 <br /> 
 <br /> 
 <br />


## Local.conf

```python
# This sets the default machine to be qemux86-64 if no other machine is selected:
MACHINE = "raspberrypi4-64"
# helloyocto recipe for connecting a python script to a server and Printing hello yocto every 5
#seconds, nano is GNU nano , tmux for session saving
EXTRA_IMAGE_FEATURES ?= "debug-tweaks ssh-server-openssh package-management "
IMAGE_INSTALL_append = "helloyocto nano tmux glibc-utils localedef run-postinsts"

```

## bblayers.conf

```python
# POKY_BBLAYERS_CONF_VERSION is increased each time build/conf/bblayers.conf
# changes incompatibly
POKY_BBLAYERS_CONF_VERSION = "2"
BBPATH = "${TOPDIR}"
BBFILES ?= ""
BBLAYERS ?= " \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/poky/meta \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/poky/meta-poky \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/poky/meta-yocto-bsp \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/meta-openembedded/meta-oe \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/meta-openembedded/meta-python \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/meta-openembedded/meta-networking \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/meta-openembedded/meta-multimedia \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/meta-raspberrypi \
/home/mahmoud/Mahmoud/Embedded-OS/yocto-project/meta-mine \
"
# layer meta-mine shall contain hello-yocto,tmux recipes
```
## Recipes

### Hello Yocto

    helloyocto recipe for connecting a python script to a server and Printing hello yocto every 5 seconds

### Tmux

    tmux is an open-source terminal multiplexer for Unix-like operating systems. It allows multiple terminal sessions to be accessed simultaneously in a single window. It is useful for running more than one command-line program at the same time. It can also be used to detach processes from their controlling terminals, allowing remote sessions to remain active without being visible.
    Tmux is used to view the session on the raspberrypi 



