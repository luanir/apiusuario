# API de Usuários com Spring Boot e JWT

API REST desenvolvida em Java com Spring Boot, focada em autenticação, segurança e boas práticas de backend.
O projeto implementa CRUD de usuários, login com JWT, validações, tratamento global de exceções e rotas protegidas com Spring Security.

## 🚀 Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- BCrypt Password Encoder
- Hibernate
- Jakarta Validation
- Maven
- Banco de dados relacional (H2 / MySQL / PostgreSQL)

## 📌 Funcionalidades
- Cadastro de usuário
- Login com autenticação JWT
- CRUD completo de usuários
- Validação de dados com DTOs
- Criptografia de senha (BCrypt)
- Tratamento global de exceções
- Rotas protegidas com Spring Security
- Arquitetura em camadas (Controller, Service, Repository)

## 🔐 Autenticação

POST /auth/login

Request:
{
  "email": "usuario@email.com",
  "password": "123456"
}

Response:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

O token deve ser enviado nas requisições protegidas no header:
Authorization: Bearer SEU_TOKEN_AQUI

## 👤 Endpoints de Usuário

POST /users
GET /users
GET /users/{id}
PUT /users/{id}
DELETE /users/{id}

(GET, PUT e DELETE são rotas protegidas)

## 🧱 Arquitetura

controller
- endpoints REST

service
- regras de negócio

repository
- acesso ao banco de dados

dto
- request
- response

security
- JWT
- filtros
- configurações de segurança

exception
- tratamento global de erros

## ▶️ Execução da aplicação

A aplicação será iniciada em:
http://localhost:8080

## 🧪 Testes

Os endpoints podem ser testados via:
- Postman
- Insomnia

## 📚 Aprendizados do Projeto
- Implementação de autenticação com JWT
- Configuração do Spring Security
- Uso correto de DTOs
- Boas práticas de API REST
- Tratamento centralizado de exceções
- Organização de código em camadas

## 📌 Observações
Este projeto tem foco exclusivamente em backend, sendo ideal para estudo, portfólio e base para aplicações mais complexas.

## 👨‍💻 Autor
Desenvolvido por Luan
