FROM openjdk:8
MAINTAINER SRINIVAS KARRE
COPY target/simple-app.jar app.jar
CMD ["java","-jar","app.jar"]
