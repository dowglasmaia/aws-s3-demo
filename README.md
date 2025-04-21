# 📁 Demo AWS S3 API – Upload de PDF com Spring Boot

Este é um projeto **demo** que demonstra como integrar uma aplicação **Java 21 + Spring Boot 3** com o serviço **Amazon S3 (SDK v2)** da AWS.

A aplicação expõe uma API REST que permite **fazer upload de arquivos PDF para um bucket S3**, utilizando as melhores práticas atuais do SDK v2 da AWS.

---

## 📌 Tecnologias Utilizadas

- ✅ Java 21
- ✅ Spring Boot 3.x
- ✅ AWS SDK for Java v2
- ✅ Maven
- ✅ Amazon S3 (armazenamento de arquivos)

---

## 🎯 Objetivo

Demonstrar como configurar e utilizar a biblioteca **AWS SDK v2** em um projeto Spring Boot moderno, com o seguinte fluxo:

1. Enviar um arquivo PDF via endpoint HTTP (upload)
2. Processar o arquivo com `MultipartFile`
3. Salvar o arquivo no bucket S3, com configuração de região e credenciais.
4. Garantir segurança e privacidade no bucket

---

## 🚀 Como executar o projeto

### Pré-requisitos:
- Conta AWS com acesso ao S3
- Bucket criado na AWS (ex: `dk-maia-by-terraform`)
- Java 21 instalado
- Maven instalado

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/demo-aws-s3.git
cd demo-aws-s3
