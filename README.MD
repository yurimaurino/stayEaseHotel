# 🏨 StayEase — Sistema de Gerenciamento de Reservas

Aplicação web para gerenciamento de reservas hoteleiras com CRUD completo, desenvolvida com Java e padrão MVC.

---

## ✨ Funcionalidades

- Cadastrar reservas com validação de dados (CPF, e-mail, telefone, datas)
- Consultar todas as reservas
- Buscar reserva por ID
- Atualizar dados de uma reserva
- Excluir reservas
- Cálculo automático do valor total por diárias
- Controle de status: **Confirmada**, **Pendente** e **Cancelada**

---

## 🛠️ Tecnologias

- Java 17
- Jakarta EE (Servlets)
- JSP
- MySQL
- JDBC
- HTML5 / CSS3

---

## 🏗️ Arquitetura

O projeto segue o padrão **MVC**:

```
├── model
│   └── Reserva.java
├── dao
│   └── ReservaDAO.java
├── controller
│   └── ReservaController.java
├── validator
│   └── ReservaValidator.java
├── connection
│   └── conexaoBD.java
└── webapp
    ├── index.html
    ├── consultarReservas.jsp
    ├── consultarReservaID.jsp
    ├── atualizarReservas.jsp
    ├── resultado.jsp
    └── erro.jsp
```

---

## ⚙️ Como executar

**Pré-requisitos:** Java 17+, Apache Tomcat, MySQL

1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/stayEase.git
```

2. Crie o banco de dados
```sql
CREATE DATABASE stayBD;

USE stayBD;

CREATE TABLE reserva (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100),
    cpf_cliente VARCHAR(11),
    email_cliente VARCHAR(100),
    telefone_cliente VARCHAR(11),
    tipo_quarto VARCHAR(20),
    data_checkin DATE,
    data_checkout DATE,
    quant_hospede INT,
    valor_total DOUBLE,
    status_reserva VARCHAR(20)
);
```

3. Configure a conexão em `conexaoBD.java`
```java
String URL      = "jdbc:mysql://localhost:3306/stayBD";
String USERNAME = "seu_usuario";
String PASSWORD = "sua_senha";
```

4. Faça o deploy no Tomcat e acesse `http://localhost:8080/stayEase`

---

## 💰 Tabela de preços

| Tipo de Quarto | Diária |
|---|---|
| Simples | R$ 150,00 |
| Luxo | R$ 300,00 |

---

## 👨‍💻 Autores

Feito por **Matheus** - [LinkedIn](https://www.linkedin.com/in/matheus-souza1/) e <BR/>
**Yuri** — [LinkedIn](https://www.linkedin.com/in/yurimaurinoborges/)