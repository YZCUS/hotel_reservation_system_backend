# Use the official OpenJDK base image
FROM openjdk:21-jdk-slim as build

# Set the working directory inside the image
WORKDIR /app

# Copy Maven executable and POM file
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy the source code
COPY src src

# Build the application
RUN ./mvnw package -DskipTests

# Copy the JAR file
COPY target/*.jar app.jar

# Set the command to run the application
ENTRYPOINT ["java","-jar","app.jar"]
