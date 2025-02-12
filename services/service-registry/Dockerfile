FROM openjdk:21-slim
WORKDIR /app
COPY build/libs/service-registry-1.0.0.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
