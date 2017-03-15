hoose ubuntu 14: 

sudo passwd
su root

apt-get update -y
apt-get install -y software-properties-common python-software-properties apt-transport-https
apt-key adv --keyserver keyserver.ubuntu.com --recv-keys FB3291D9
curl -sL https://deb.nodesource.com/setup_6.x |  bash - 
apt-get install -y git dynomitedb nodejs build-essential default-jre default-jdk
groupadd tomcat

useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
cd /tmp
curl -O http://archive.apache.org/dist/tomcat/tomcat-9/v9.0.0.M1/src/apache-tomcat-9.0.0.M1-src.tar.gz
 mkdir /opt/tomcat

 tar -xzvf apache-tomcat-9*tar.gz -C /opt/tomcat --strip-components=1
 rm -rf apache-tomcat-9*tar.gz
 cd /opt/tomcat
 chgrp -R tomcat /opt/tomcat
 chmod -R g+r conf
 chmod g+x conf
 mkdir work temp logs
 chown -R tomcat webapps/ work/ temp/ logs/ 
 mkdir /netflix
 cd /netflix
 git clone https://github.com/Netflix/conductor.git
 cd conductor
 cd ..
 git clone https://github.com/open-devops/docker-netflix-conductor.git
 cd docker-netflix-conductor
 cp ./startup.sh ../conductor/
 cd ../conductor
 ./startup.sh

 # if the above doesn't work, install newer java.

 vi build.gradle 
 java -version
 sudo apt-get install oracle-java8-installer
 sudo add-apt-repository ppa:webupd8team/java
 sudo apt-get update
 sudo apt-get install oracle-java8-installer
 java -version

 # Run server and ui separately

 cd /netflix/conductor
 ./gradlew server

 cd /netflix/conductor/ui
 npm install
 npm run watch

 ui : http://104.198.150.92:3000
 server : http://104.198.150.92:8080/api/metadata/taskdefs
