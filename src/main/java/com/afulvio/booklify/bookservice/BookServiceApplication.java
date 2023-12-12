package com.afulvio.booklify.bookservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Book Service REST API Documentation",
                description = "Book Service REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Antonio",
                        email = "antoniofulvio@outlook.it",
                        url = "http://afulvio.dev"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.afulvio.dev/booklify/license"
                )
        )
)
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

}
