# types-of-cars
Tipos de carros

# java-back-end-
Este repositório contém o código do livro Java Back End.

## Serviços

A aplicação é composta do microserviços, carros-api.


## Banco de dados

A aplicações criam as tabelas automaticamente quando são executadas pela primeira vez, porém o banco de dados deve ser criado no Mysql.

As aplicações estão configuradas para se conectar ao banco de dados `dev`, por isso antes de rodar as aplicações, crie esse banco de dados. 
Se quiser alterar o nome do banco de dados, altere o arquivo application.properties de cada projeto. 


## Maven
Para subir no maven execute o comando onde esteja o jar,  com o comando
> java jar carros-0.0.1-SNAPSHOT.jar

## Postman
GET http://localhost:8080/api/v1/carros/
GET http://localhost:8080/api/v1/carros/1
GET http://localhost:8080/api/v1/carros/tipo/classicos
POST http://localhost:8080/api/v1/carros
PUT http://localhost:8080/api/v1/carros/1
DELETE http://localhost:8080/api/v1/carros/1
Para vê os usuários cadastrados http://localhost:8080/userInfo

## Execução

A maneira mais simples de executar a aplicação é com o Postman

## Versões

Eu utilizei a versão 2.7.5.RELEASE do Spring Boot para desenvolver a aplicação, 
pois ela era a versão mais recente.

Eu desenvolvi a aplicação utilizando o Java 8, 
não deve haver grandes problemas na utilização de versões mais recentes do Java,
no pom possui as seguintes dependência:

spring-boot-starter-web      
spring-boot-devtools
spring-boot-starter-data-jpa
        mysql-connector-java
org.springframework.boot
org.projectlombok
org.modelmapper
com.h2database
junit
springfox-swagger2
springfox-swagger-ui
spring-security-core
spring-boot-starter-security
