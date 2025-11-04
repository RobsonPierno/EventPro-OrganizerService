FROM eclipse-temurin:21-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY organizer-service/target/organizer-service-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
