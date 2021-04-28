FROM openjdk:11-jre-slim
ADD eatgo-api/build/libs/eatgo-api-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/app.jar"]