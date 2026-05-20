# StudyAI

StudyAI é uma aplicação backend desenvolvida em Java com Spring Boot voltada para auxiliar estudantes na organização dos estudos através da geração automática de resumos e perguntas de revisão.

O projeto foi desenvolvido como atividade prática da disciplina de Inteligência Artificial para Devs, aplicando conceitos de APIs REST, autenticação JWT, persistência de dados e arquitetura backend.

---

## Funcionalidades

- Cadastro de usuários
- Login com autenticação JWT
- Criptografia de senha com BCrypt
- Validação de CPF duplicado
- Geração automática de resumos
- Geração automática de perguntas de revisão
- Histórico de resumos
- Busca de resumo por ID
- Exclusão de resumos
- Tratamento global de exceções

---

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT
- MySQL
- Maven
- Postman
- Git e GitHub

---

## Estrutura do projeto

O projeto foi organizado utilizando arquitetura em camadas:

- controller
- service
- repository
- entity
- dto
- security
- exception

---

## Endpoints principais

### Usuários

- POST /users
- POST /users/login
- GET /users

### Resumos

- POST /resumos
- GET /resumos
- GET /resumos/{id}
- DELETE /resumos/{id}

---

## Futuras melhorias

- Integração com IA real (OpenAI/Gemini)
- Exportação de resumos em PDF
- Geração de resumo através de links
- Sistema de favoritos
- Interface frontend

---

## Autor

Desenvolvido por Samis Monteiro.
