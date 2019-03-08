# springboot-clients-and-their-cities
A project with two distinct applications made with Spring Boot using Maven, with the H2 embedded using JPA and MongoDB embedded database.
Also with use of RabbitMQ and REST APIs for communications between these applications.

Automated documentation with Swagger + Springfox
## Prerequisites
Rabbit already installed and running on ports:
```
15672
5672
```

## Accessing the Application

Cities Application
Swagger: http://localhost:8081/swagger-ui.html#/
H2 Embed: http://localhost:8082/h2-console

Clients Application
http://localhost:8082/swagger-ui.html#/
MongoDB accessing with MongoDB Compass

RabbitMQ
http://localhost:15672/#/

## System Functionalities

API REST:
* City registration
* Client registration
* Find city by name
* Find city by state
* Find client by name
* Find client by Id
* Remove client
* Change client name

RabbitMQ:
* Change name of user/client through City application

Consider registering with basic data:
* Cities: name and state
* Client: full name, gender, date of birth, age and city where you live.
