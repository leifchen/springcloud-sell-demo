FROM openjdk:8-alpine

MAINTAINER LeifChen lefengchen@163.com

ADD target/*.jar app.jar

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "/app.jar"]