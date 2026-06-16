# Project Java JDBC

Projeto desenvolvido para praticar e consolidar os conceitos de JDBC (Java Database Connectivity) com banco de dados MySQL.

---

## Sobre o Projeto

Este projeto foi criado como estudo prático de JDBC em Java, aplicando o padrão DAO (Data Access Object) para separar a lógica de acesso ao banco de dados das regras de negócio.

---

## Tecnologias Utilizadas

- Java 17
- JDBC
- MySQL
- VS Code

---

## Banco de Dados

O banco de dados possui duas tabelas principais:

- department - armazena os departamentos
- seller - armazena os vendedores, com chave estrangeira para department

As configurações de conexão ficam no arquivo db.properties.

---

## Como Executar

1. Clone o repositório git clone https://github.com/LucasDeveloper07/project-java-jdbc.git

2. Configure o arquivo db.properties com suas credenciais do MySQL

3. Execute o projeto pela classe ProgramTest ou ProgramTest2 dentro da pasta application

# Project Java JDBC

Project developed to practice and consolidate JDBC (Java Database Connectivity) concepts with a MySQL database.

---

## About

This project was created as a hands-on study of JDBC in Java, applying the DAO (Data Access Object) pattern to separate database access logic from business rules.

---

## Technologies

- Java 17
- JDBC
- MySQL
- VS Code

---

## Database

The database has two main tables:

- department - stores the departments
- seller - stores the sellers, with a foreign key referencing department

Connection settings are configured in the db.properties file.

---

## Getting Started

1. Clone the repository git clone https://github.com/LucasDeveloper07/project-java-jdbc.git

2. Configure the db.properties file with your MySQL credentials

3. Run the project through the ProgramTest or ProgramTest2 class inside the application package