do_configure_append() {
    sed -i "s/#PermitRootLogin yes/PermitRootLogin yes/" ${B}/sshd_config
}
