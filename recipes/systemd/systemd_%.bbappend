PACKAGECONFIG[timedated] = "--enable-timedated,--disable-timedated"
PACKAGECONFIG += "xz networkd resolved timedated"

do_install_append() {
        # XXX Watchdog sec should be revised
        # Configure hw watchdog
        sed -i -e 's/^#\?RuntimeWatchdogSec=.*/RuntimeWatchdogSec=10s/' ${D}${sysconfdir}/systemd/system.conf
        sed -i -e 's/^#\?ShutdownWatchdogSec=.*/ShutdownWatchdogSec=30s/' ${D}${sysconfdir}/systemd/system.conf

        # Configure journal
        # FIXME Lower RuntimeMaxUse= for production
        sed -i -e 's/^#\?Storage=.*/Storage=volatile/' ${D}${sysconfdir}/systemd/journald.conf
        sed -i -e 's/^#\?RuntimeMaxUse=.*/RuntimeMaxUse=100M/' ${D}${sysconfdir}/systemd/journald.conf
        sed -i -e 's/^#\?ForwardToSyslog=.*/ForwardToSyslog=no/' ${D}${sysconfdir}/systemd/journald.conf
        sed -i -e 's/^#\?ForwardToKMsg=.*/ForwardToKMsg=no/' ${D}${sysconfdir}/systemd/journald.conf
        sed -i -e 's/^#\?ForwardToConsole=.*/ForwardToConsole=no/' ${D}${sysconfdir}/systemd/journald.conf
}
