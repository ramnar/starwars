FROM openjdk:8-jdk-alpine
VOLUME /tmp 
ARG JAR_FILE=target/sampleservice-1.0.0.jar
ADD ${JAR_FILE} sampleservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sampleservice.jar"]