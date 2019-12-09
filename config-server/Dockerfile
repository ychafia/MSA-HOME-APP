#FROM armv7/armhf-java8
FROM openjdk:8
MAINTAINER Youness CHAFIA
COPY ./target/config-server-api.jar config-server-api.jar
CMD ["java","-jar","config-server-api.jar"]