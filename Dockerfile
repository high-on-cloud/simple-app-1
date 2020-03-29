FROM openjdk:8
MAINTAINER SRINIVAS KARRE
WORKDIR /app
COPY target/simple-app.jar app.jar
CMD ["java","-jar","app.jar"]
