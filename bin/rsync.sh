#!/bin/sh

web_home="/var/www/cdgd"
jee_home="/usr/share/tomcat/webapps/ROOT"
local_statics="${PWD}/src/main/webapp/resources"
local_jsps="${PWD}/src/main/webapp/WEB-INF"
statics="$web_home/resources"
layouts="$jee_home/WEB-INF/layouts"
views="$jee_home/WEB-INF/views"

rsync -vv -e ssh -r --exclude '*.DS_Store' $local_statics default:~ && \
ssh default "sudo rm -rf $web_home/* && \
sudo mv resources/* $web_home"

rsync -vv -e ssh -r --exclude '*.DS_Store' $local_jsps default:~ && ssh default "\
sudo rm -rf $layouts && \
sudo rm -rf $views && \
sudo mv WEB-INF/layouts $jee_home/WEB-INF && \
sudo mv WEB-INF/views $jee_home/WEB-INF && \
sudo chown -R tomcat:tomcat $layouts && \
sudo chown -R tomcat:tomcat $views"