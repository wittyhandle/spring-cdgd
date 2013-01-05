#!/bin/sh

web_home="/usr/share/tomcat/webapps/carl"
local_statics="${PWD}/src/main/webapp/resources"
statics="$web_home/resources"

rsync -vv -e ssh -r --exclude '*.DS_Store' $local_statics default:~ \
&& ssh default "sudo rm -rf $statics \
&& sudo mv resources/ $web_home \
&& sudo chown -R tomcat:tomcat $statics"