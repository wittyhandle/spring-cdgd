#!/bin/sh

web_home="/usr/share/tomcat/webapps/carl"
local_statics="${PWD}/src/main/webapp/resources"
local_jsps="${PWD}/src/main/webapp/WEB-INF"
statics="$web_home/resources"
layouts="$web_home/WEB-INF/layouts"
views="$web_home/WEB-INF/views"

rsync -vv -e ssh -r --exclude '*.DS_Store' $local_statics default:~ && \
ssh default "sudo rm -rf $statics && \
sudo mv resources/ $web_home && \
sudo chown -R tomcat:tomcat $statics"

rsync -vv -e ssh -r --exclude '*.DS_Store' $local_jsps default:~ && ssh default "\
sudo rm -rf $layouts && \
sudo rm -rf $views && \
sudo mv WEB-INF/layouts $web_home/WEB-INF && \
sudo mv WEB-INF/views $web_home/WEB-INF && \
sudo chown -R tomcat:tomcat $layouts && \
sudo chown -R tomcat:tomcat $views\
"