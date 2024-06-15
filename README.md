# FinTech Solutions

## Descrição

FinTech Solutions é um sistema de gerenciamento financeiro que permite aos usuários gerenciar cartões de crédito, transações e recebimentos. O sistema é construído usando tecnologias Java EE, JSP, JSTL, e JDBC para a comunicação com o banco de dados.

## Funcionalidades

- Gerenciamento de Cartões de Crédito
- Gerenciamento de Transações
- Gerenciamento de Recebimentos
- Autenticação de Usuário

## Estrutura do Projeto

- **src**: Contém os arquivos de código-fonte Java.
- **webapp**: Contém os arquivos JSP e recursos estáticos como CSS e JS.
- **sql**: Contém os scripts SQL para criação das tabelas necessárias.

## Pré-requisitos

- Java JDK 8 ou superior
- Apache Tomcat 9 ou superior
- MySQL 5.7 ou superior
- Maven 3.6 ou superior

## Configuração do Banco de Dados

1. **Criação do Banco de Dados**: Execute o script abaixo para criar o banco de dados necessário.

```sql
CREATE DATABASE fintech_solutions;

USE fintech_solutions;

CREATE TABLE Usuario (
    idUsuario CHAR(36) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE Cartao (
    idCartao CHAR(36) PRIMARY KEY,
    idUsuario CHAR(36) NOT NULL,
    tipoCartao VARCHAR(255) NOT NULL,
    numeroCartao VARCHAR(255) NOT NULL UNIQUE,
    dataValidade VARCHAR(10) NOT NULL,
    cvv VARCHAR(4) NOT NULL,
    limiteCredito DOUBLE NOT NULL,
    saldoDebito DOUBLE NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Recebimento (
    idRecebimento CHAR(36) PRIMARY KEY,
    idUsuario CHAR(36) NOT NULL,
    tipoRecebimento VARCHAR(255) NOT NULL,
    tipoPagamento VARCHAR(255) NOT NULL,
    dthrRecebimento VARCHAR(19) NOT NULL,
    valorRecebimento DOUBLE NOT NULL,
    documentoAnexado VARCHAR(255) NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Transacao (
    idTransacao CHAR(36) PRIMARY KEY,
    idUsuario CHAR(36) NOT NULL,
    dataTransacao VARCHAR(19) NOT NULL,
    tipoTransacao VARCHAR(255) NOT NULL,
    valor DOUBLE NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);
