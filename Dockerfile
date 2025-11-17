## Stage 1: Build
#FROM maven:3.9.6-eclipse-temurin-17 AS build
#
#WORKDIR /app
#
#COPY pom.xml .
#COPY mvnw .
#COPY .mvn .mvn
#RUN chmod +x mvnw
#
## Download dependencies first
#RUN ./mvnw -q -DskipTests dependency:resolve
#
## Copy source
#COPY src ./src
#
## Build JAR (MapStruct runs here)
#RUN ./mvnw clean package -DskipTests
#
## Stage 2: Run
#FROM eclipse-temurin:17-jre
#
#WORKDIR /app
#
#COPY --from=build /app/target/*.jar app.jar
#
#ENTRYPOINT ["java", "-jar", "app.jar"]
