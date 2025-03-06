# Booklify Book Service

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![Java](https://img.shields.io/badge/Java-21-blue)
![Build](https://github.com/AFulvio1/booklify-book-service/actions/workflows/docker-image.yml/badge.svg)

## 📖 Description

This microservice is designed for book management. It is currently used by the web application, but in the future, it will also support a mobile app and expose external APIs for third-party integrations.

- Manages book-related operations such as creation, retrieval, update, and deletion.

- Currently integrated with the web application.

- Future plans include providing services for a mobile app and offering public APIs.

## 🚀 Technologies Used

- **Java 17**
- **Spring Boot 2.x / 3.x**
- **Spring Cloud** (se applicabile)
- **Docker** (se applicabile)
- **Database**: PostgreSQL / MySQL / MongoDB
- **Messaging**: Kafka / RabbitMQ (se presente)

## 📦 Installazione e Setup

### 1️⃣ Preconditions

- [Java 21](https://adoptium.net/)
- [Maven 3.9.8](https://maven.apache.org/)
- Docker
- Database: PostgreSQL

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

| Metodo | Endpoint                 | Descrizione            | Autenticazione |
| ------ |--------------------------| ---------------------- | -------------- |
| GET    | `/api/books/get/{id}`    | Ottiene una risorsa    | 🔒 JWT Token   |
| GET    | `/api/books/get-all`     | Ottiene una risorsa    | 🔒 JWT Token   |
| POST   | `/api/books/add`         | Crea una nuova risorsa | 🔒 JWT Token   |
| PUT    | `/api/books/update`      | Aggiorna una risorsa   | 🔒 JWT Token   |
| DELETE | `/api/books/delete/{id}` | Elimina una risorsa    | 🔒 JWT Token   |

> Categories

| Metodo | Endpoint                      | Descrizione            | Autenticazione |
| ------ |-------------------------------| ---------------------- | -------------- |
| GET    | `/api/categories/get/{id}`    | Ottiene una risorsa    | 🔒 JWT Token   |
| GET    | `/api/categories/get-all`     | Ottiene una risorsa    | 🔒 JWT Token   |
| POST   | `/api/categories/add`         | Crea una nuova risorsa | 🔒 JWT Token   |
| PUT    | `/api/categories/update`      | Aggiorna una risorsa   | 🔒 JWT Token   |
| DELETE | `/api/categories/delete/{id}` | Elimina una risorsa    | 🔒 JWT Token   |

> Publishers

| Metodo | Endpoint                      | Descrizione            | Autenticazione |
| ------ |-------------------------------| ---------------------- | -------------- |
| GET    | `/api/publishers/get/{id}`    | Ottiene una risorsa    | 🔒 JWT Token   |
| GET    | `/api/publishers/get-all`     | Ottiene una risorsa    | 🔒 JWT Token   |
| POST   | `/api/publishers/add`         | Crea una nuova risorsa | 🔒 JWT Token   |
| PUT    | `/api/publishers/update`      | Aggiorna una risorsa   | 🔒 JWT Token   |
| DELETE | `/api/publishers/delete/{id}` | Elimina una risorsa    | 🔒 JWT Token   |


📌 To test the APIs, you can use [Postman](https://www.postman.com/) or `cURL`.

## 🛠 Configuration

- **Application Properties** :
  - `src/main/resources/application.yml`
  - `src/main/resources/application-docker.yml`
  - `src/main/resources/application-local.yml`
  - `src/main/resources/application-test.yml`
- **Security**: Spring Security + JWT
- **Profilazione**: `dev`, `prod`, `test`

## 🏗 Project Structure

```plaintext
src/
 ├── main/
 │   ├── java/com/afulvio/booklify/book-service
 │   │   ├── controller/
 |   |   ├── dto/
 │   │   ├── entity/
 │   │   ├── service/
 │   │   ├── repository/
 │   │   ├── config/
 │   │   ├── model/
 │   │   ├── MicroservizioApplication.java
 │   ├── resources/
 │   │   ├── application.yml
 │   │   ├── logback.xml
 ├── test/
 │   ├── java/com/tuo-utente/microservizio/
 │   │   ├── unit/
 │   │   ├── integration/
```

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
- 🔗 **LinkedIn**: [Antonio Fulvio](https://www.linkedin.com/in/antonio-fulvio-80a110161/)


