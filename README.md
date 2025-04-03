# Booklify Book Service

![Maven Package](https://github.com/AFulvio1/booklify-book-service/actions/workflows/production.yml/badge.svg)
![Docker Image](https://github.com/AFulvio1/booklify-book-service/actions/workflows/development.yml/badge.svg)


![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![Java](https://img.shields.io/badge/Java-21-blue)


## Description

This microservice is designed for book management. It is currently used by the web application, but in the future, it will also support a mobile app and expose external APIs for third-party integrations.

- Manages book-related operations such as creation, retrieval, update, and deletion.

- Currently integrated with the web application.

- Future plans include providing services for a mobile app and offering public APIs.

## Technologies Used

- [Java 21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)
- [Spring Boot 3.2.0](https://spring.io/blog/2023/11/23/spring-boot-3-2-0-available-now)
- [Docker](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/)

## Installation & Setup


### 1️⃣  Cloning the repository

```sh
git clone https://github.com/AFulvio1/booklify-book-service.git
cd booklify-book-service
```

### 2️⃣ Configure the `.env` File

Create a `.env` file in the project root and configure the environment variables:

```ini
DATABASE_URL=jdbc:postgresql://postgres:5432/booklify
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=pgadmin
EUREKA_SERVER=http://localhost:8761/eureka/
```

### 3️⃣ Start the Service

#### With Maven

```sh
mvn spring-boot:run
```

#### With Docker

```sh
docker-compose up -d
```

## API Endpoints

> Books

| Metodo | Endpoint                  | Descrizione        | Autenticazione |
| ------ |---------------------------|--------------------| -------------- |
| GET    | `/api/books/get/{id}`     | Retrieve a book    | 🔒 JWT Token   |
| GET    | `/api/books/get-all`      | Retrieve all books | 🔒 JWT Token   |
| POST   | `/api/books/add`          | Save a new book    | 🔒 JWT Token   |
| PUT    | `/api/books/{id}/update`  | Update a book      | 🔒 JWT Token   |
| DELETE | `/api/books/{id}/delete` | Delete a book      | 🔒 JWT Token   |

> Categories

| Metodo | Endpoint                      | Descrizione             | Autenticazione |
| ------ |-------------------------------|-------------------------| -------------- |
| GET    | `/api/categories/get/{id}`    | Retrieve a category     | 🔒 JWT Token   |
| GET    | `/api/categories/get-all`     | Retrieve all categories | 🔒 JWT Token   |
| POST   | `/api/categories/add`         | Save a new category     | 🔒 JWT Token   |
| PUT    | `/api/categories/update`      | Update a category       | 🔒 JWT Token   |
| DELETE | `/api/categories/delete/{id}` | Delete a category       | 🔒 JWT Token   |

> Publishers

| Metodo | Endpoint                      | Descrizione             | Autenticazione |
| ------ |-------------------------------|-------------------------| -------------- |
| GET    | `/api/publishers/get/{id}`    | Retrieve a publisher    | 🔒 JWT Token   |
| GET    | `/api/publishers/get-all`     | Retrieve all publishers | 🔒 JWT Token   |
| POST   | `/api/publishers/add`         | Save a new publisher    | 🔒 JWT Token   |
| PUT    | `/api/publishers/update`      | Update a publisher      | 🔒 JWT Token   |
| DELETE | `/api/publishers/delete/{id}` | Delete a publisher      | 🔒 JWT Token   |



## License

This project is distributed under the **MIT** license.\
See the [`LICENSE`](./LICENSE) file for more details.

## Contacts

- ✉️ **Email**: [antoniofulvio@outlook.it](mailto\:antoniofulvio@outlook.it)
- 🔗 **GitHub**: [@AFulvio1](https://github.com/AFulvio1)
- 🔗 **DockeHub**: [afulvio](https://hub.docker.com/u/afulvio)
- 🔗 **LinkedIn**: [Antonio Fulvio](https://www.linkedin.com/in/antonio-fulvio-80a110161/)


