#!/bin/bash

apt-get -y update

dpkg -s tomcat7 &>/dev/null || {
	apt-get -y install tomcat7
	echo "export CATALINA_HOME=/usr/share/tomcat7" >> /home/vagrant/.bashrc

	mkdir /usr/share/tomcat7/logs
	chown vagrant /usr/share/tomcat7/logs
}

dpkg -s default-jdk &>/dev/null || {
	apt-get -y install default-jdk
	echo "export JAVA_HOME=/usr/lib/jvm/default-java" >> /home/vagrant/.bashrc
}

/usr/share/tomcat7/bin/startup.sh