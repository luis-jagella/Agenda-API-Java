# Agenda API

Bem-vindo à **Agenda API**, uma aplicação simples para gerenciamento de contatos, desenvolvida em **Java** com **Spring Boot**.  

O projeto surgiu como evolução do meu estudo com **CLI Java** (Agenda CLI) e foi transformado em uma API RESTful para praticar conceitos de **Spring Boot, JPA e H2 Database**.

---

## Funcionalidades

- Adicionar um contato (POST `/contatos`)
- Listar todos os contatos (GET `/contatos`)
- Buscar contato por ID (GET `/contatos/{id}`)
- Atualizar contato (PUT `/contatos/{id}`)
- Remover contato (DELETE `/contatos/{id}`)

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.6
- Spring Data JPA
- H2 Database (em memória)
- Maven
- Postman (para testes de API)

---

## Como Rodar

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/agenda-api.git
```

2. Abra o projeto no **IntelliJ** (ou sua IDE favorita) como **Maven Project**.
3. Certifique-se de que o **JDK 17** está configurado.
4. Rode a aplicação: `AgendaApiApplication.java` (Run as Java Application).
5. A API estará disponível em: `http://localhost:8080`

---

## Testando a API

Você pode usar o **Postman** para testar os endpoints.  
Exemplo de importação de coleção Postman: `postman/AgendaAPI_Collection.json`.

---

## Estrutura do Projeto

```
agenda-api/
├─ src/main/java/org/example/agenda_api
│  ├─ controller
│  └─ model
├─ pom.xml
├─ README.md
└─ postman/
   └─ AgendaAPI_Collection.json
```

---

## Observações

- Banco de dados H2 é em memória, então os dados não persistem após a aplicação ser desligada.
- A API foi pensada para aprendizado e demonstração, podendo ser facilmente adaptada para banco real.

---

## Contato

- Desenvolvedor: **Luís Gabriel Pereira**
- LinkedIn: [Luís Gabriel Pereira Jagella](https://www.linkedin.com/in/lu%C3%ADs-gabriel-pereira-jagella-ab6ba8308/?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=ios_app)

