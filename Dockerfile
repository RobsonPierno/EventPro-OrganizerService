FROM openjdk:25-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY organizer-service/target/OrganizerService-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
