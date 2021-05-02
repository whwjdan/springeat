FROM openjdk:8-jdk
EXPOSE 8080
ARG JAR_FILE=eatgo-api/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]