FROM openjdk:15-jdk-alpine
COPY target/email.jar email.jar
ENTRYPOINT ["java","-jar","/email.jar"]
