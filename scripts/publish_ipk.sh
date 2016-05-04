#!/bin/sh

# TN, 11/2013

bitbake package-index
rsync -rlv --delete \
	--include "beeeon-*-dbg*" \
	--include "fitprotocold-dbg*" \
	--include "*libgcc-s-dbg*" \
	--include "*libpoco-dbg*" \
	--exclude="i686-nativesdk/" \
	--exclude="x86_64-nativesdk/" \
	--exclude="*-dbg_*" \
	--exclude="*-doc_*" \
	--exclude="*-localedata-*" \
	--include "libc6-dbg*" \
	/home/tom/oe/build/jethro-glibc/deploy/ipk/ \
	tom@cloud.beeeon.com:/var/www/html/feed_jethro/
