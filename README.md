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

### Run on local k8s
deploy.yaml file is for kubernetes and it will automatically pick up the configuration
to do this execute
kubectl apply -f deploy.yaml

Navigate to the url http:// localhost:30040

Opening an account
```curl
curl --location --request POST 'http://localhost:8081/account/open' \
--header 'Content-Type: application/json' \
--data-raw '{
"customerId": "2",
"initialCredit": 100
}'
```

Retrieving user information
```curl
curl --location --request GET 'http://localhost:8081/customer/info/{customerId}' \
--header 'Content-Type: application/json'
```

### Docker
to create the docker image execute the following commands
mvn clean package
mvn docker:build
