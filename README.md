![logo](/img.png)

###### *Simplify the world of books*

[booklify.org](https://www.booklify.org/)

# BOOK SERVICE

CRUD APIs for the management of the books.

## APIs

### Books `/api/books`
- **GET** `/get/{id}`
- **GET** `/get-all`
- **POST** `/add`
- **PUT** `/update`
- **DELETE** `/delete/{id}`

### Categories `/api/categories`
- **GET** `/get/{id}`
- **GET** `/get-all`
- **POST** `/add`
- **PUT** `/update`
- **DELETE** `/delete/{id}`

### Publishers `/api/publishers`
- **GET** `/get/{id}`
- **GET** `/get-all`
- **POST** `/add`
- **PUT** `/update`
- **DELETE** `/delete/{id}`

## Dependencies

> Spring Book 3.2.0

> JDK corretto-21

### Maven:
- starter-web
- starter-test
- starter-actuator
- starter-data-jpa
- starter-hateoas
- starter-validation
- postgresql
- h2
- springdoc-openapi-starter-webmvc-ui
- lombok
- commons-collections4
- mapstruct
- mapstruct-processor
- spring-cloud-starter-netflix-eureka-client
