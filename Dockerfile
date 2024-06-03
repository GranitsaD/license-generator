FROM eclipse-temurin:22-jdk-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
RUN mkdir -p /front
ENTRYPOINT ["java", "-jar", "/app.jar"]