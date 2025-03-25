# Booklify Book Service

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![Java](https://img.shields.io/badge/Java-21-blue)
![Maven Package](https://github.com/AFulvio1/booklify-book-service/actions/workflows/release-maven.yml/badge.svg)
![Docker Image](https://github.com/AFulvio1/booklify-book-service/actions/workflows/release-docker.yml/badge.svg)



## 📖 Description

This microservice is designed for book management. It is currently used by the web application, but in the future, it will also support a mobile app and expose external APIs for third-party integrations.

- Manages book-related operations such as creation, retrieval, update, and deletion.

- Currently integrated with the web application.

- Future plans include providing services for a mobile app and offering public APIs.

## 🚀 Technologies Used

- **Java 21**
- **Spring Boot 3.2.0**
- **Spring Cloud**
- **Docker**
- **Database**: PostgreSQL
- **Messaging**: IN PROGRESS

## 📦 Installazione e Setup

### 1️⃣ Preconditions

- [Java 21](https://adoptium.net/)
- [Maven 3.9.8](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/)

### 2️⃣ Cloning the repository

```sh
git clone https://github.com/AFulvio1/booklify-book-service.git
cd booklify-book-service
```

### 3️⃣ Configure the `.env` File

Create a `.env` file in the project root and configure the environment variables:

```ini
DB_HOST=localhost
DB_PORT=5432
DB_NAME=booklify
DB_USER=postgres
DB_PASS=pgadmin
```

### 4️⃣ Start the Service

#### With Maven

```sh
mvn spring-boot:run
```

#### With Docker

```sh
docker-compose up -d
```

## 🔥 API Endpoints

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


📌 To test the APIs, you can use [Postman](https://www.postman.com/) or `cURL`.

## 🛠 Configuration

- **Application Properties** :
  - `src/main/resources/application.yml`
  - `src/main/resources/application-docker.yml`
  - `src/main/resources/application-local.yml`
  - `src/main/resources/application-test.yml`
- **Security**: Spring Security + JWT
- **Profilazione**: `local`, `test`, `docker`



## 🔬 Testing

To run unit and integration tests:

```sh
mvn test
```

## 📜 License

This project is distributed under the **MIT** license.\
See the [`LICENSE`](./LICENSE) file for more details.

## 📫 Contacts

- ✉️ **Email**: [antoniofulvio@outlook.it](mailto\:antoniofulvio@outlook.it)
- 🔗 **GitHub**: [@AFulvio1](https://github.com/AFulvio1)
- 🔗 **DockeHub**: [afulvio](https://hub.docker.com/u/afulvio)
- 🔗 **LinkedIn**: [Antonio Fulvio](https://www.linkedin.com/in/antonio-fulvio-80a110161/)


