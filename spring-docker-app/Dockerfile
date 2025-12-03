# --- Stage 1: Build the JAR using Maven and JDK 17 ---
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn -q clean package -DskipTests

# --- Stage 2: Run the JAR using a lightweight JRE image ---
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
