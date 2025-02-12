FROM openjdk:21-slim
WORKDIR /app
COPY build/libs/cart-service-1.0.0.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
