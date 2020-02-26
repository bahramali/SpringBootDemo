# SpringBootDemo

## Installing the Prerequisites.
The following thing are needed to successfully install
* [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Docker](https://docs.docker.com/docker-for-windows/install/)

## build the application and docker:
* "mvn clean install -T1C"
* "docker build -f Dockerfile -t docker-spring-boot ."
* "docker run -p 5000:5000 docker-spring-boot"
* Browse to http://localhost:5000/ and click on the links
