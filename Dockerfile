FROM amazoncorretto:21

LABEL authors="afulvio"

WORKDIR /app

COPY target/booklify-book-service-1.0.3.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]