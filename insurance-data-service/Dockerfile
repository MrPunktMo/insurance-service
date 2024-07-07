FROM openjdk:17-alpine

WORKDIR /app
COPY ./target/insurance-company /app

EXPOSE 8283

CMD ["java", "-jar", "insurance-data-service.jar"]
