# springboot-clients-and-their-cities
A project with two distinct applications made with Spring Boot using Maven, with the H2 Runtime database and JPA.
Also with use of RabbitMQ and REST APIs for communications between these applications.

Automated documentation with Swagger + Springfox

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
