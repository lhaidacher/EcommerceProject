FROM openjdk:21-slim
WORKDIR /app
COPY build/libs/product-service-1.0.0.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
