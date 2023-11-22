FROM openjdk:17-jdk-slim as build

EXPOSE 8080

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} lunchpicker.jar

ENTRYPOINT ["java","-jar","/lunchpicker.jar"]
