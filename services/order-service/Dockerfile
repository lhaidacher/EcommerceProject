FROM openjdk:21-slim
WORKDIR /app
COPY build/libs/order-service-1.0.0.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
