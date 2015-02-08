#!/bin/bash

#POSTGRES REPO
PG_REPO_APT_SOURCE=/etc/apt/sources.list.d/pgdg.list
if [ ! -f "$PG_REPO_APT_SOURCE" ]
then
  # Add PG apt repo:
  echo "deb http://apt.postgresql.org/pub/repos/apt/ precise-pgdg main" > "$PG_REPO_APT_SOURCE"
  # Add PGDG repo key:
  wget --quiet -O - http://apt.postgresql.org/pub/repos/apt/ACCC4CF8.asc | apt-key add -
fi

apt-get -y update

# TOMCAT
dpkg -s tomcat7 &>/dev/null || {
	apt-get -y install tomcat7 tomcat7-admin
	echo "export CATALINA_HOME=/usr/share/tomcat7" >> /home/vagrant/.bashrc
}

# MAVEN
dpkg -s maven &>/dev/null || {
	apt-get -y install maven
}

# JDK
dpkg -s default-jdk &>/dev/null || {
	apt-get -y install default-jdk
	echo "export JAVA_HOME=/usr/lib/jvm/default-java" >> /home/vagrant/.bashrc
}

# POSTGRES
dpkg -s postgresql-9.3 &>/dev/null || {
	PG_VERSION=9.3
  apt-get -y install "postgresql-9.3" "postgresql-contrib-9.3"

  PG_CONF="/etc/postgresql/$PG_VERSION/main/postgresql.conf"
  PG_HBA="/etc/postgresql/$PG_VERSION/main/pg_hba.conf"
  PG_DIR="/var/lib/postgresql/$PG_VERSION/main"

  # Edit postgresql.conf to change listen address to '*':
	sed -i "s/#listen_addresses = 'localhost'/listen_addresses = '*'/" "$PG_CONF"
	# Append to pg_hba.conf to add password auth:
	echo "host    all             all             all                     md5" >> "$PG_HBA"

	# Explicitly set default client_encoding
	echo "client_encoding = utf8" >> "$PG_CONF"
}

cp /vagrant/configs/tomcat-users.xml /etc/tomcat7
cp /vagrant/configs/settings.xml /etc/maven

service postgresql restart
service tomcat7 restart

/vagrant/configs/dbProvision