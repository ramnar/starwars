FROM openjdk:8-jdk-alpine
VOLUME /tmp 
ARG JAR_FILE=target/starwars-1.0.0.jar
ADD ${JAR_FILE} starwars.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/starwars.jar"]