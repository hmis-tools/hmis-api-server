#!/bin/sh
#
# Copyright (c) 2016 Georgia Department of  Community Affairs
#
# This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at http://mozilla.org/MPL/2.0/.
#
#
#
# This script is a workaround for an issue (see
# https://github.com/PCNI/OpenHMIS/issues/44) that often requires manual
# restart of this server.  Presumably we'll find and fix the real cause
# of that problem, but in the meantime this script will be called from
# cron daily, running as root.

sudo service tomcat7 restart
