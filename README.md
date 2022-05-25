# transaction-service
___
### Spring Boot Application

---
This project helps us to create account for existing customers.

#### Requirements
- The API exposes one endpoint.
- User transactions can be retrieved by accountId

The application has 2 apis
* TransactionAPI

Retrieving the transactions
```curl
curl --location --request GET 'http://localhost:30030/customer/info/{accountId}' \
--header 'Content-Type: application/json'
```

### Tech Stack

---
- Java 11
- Spring Boot
- Spring Data JPA
- Restful API
- H2 In memory database
- Docker
- K8s files
- JUnit 5

### Prerequisites

---
- Maven

### Run & Build

first go to the terminal and open up the project directory. "~/transaction-service/"

### Run the tests

mvn test

### Run project

mvn spring-boot:run

### Docker
to create the docker image execute the following commands
mvn clean package
mvn docker:build
