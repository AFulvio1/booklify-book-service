FROM amazoncorretto:21

LABEL authors="afulvio"

WORKDIR /app

COPY target/booklify-book-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]