# ✈️ Empresa de Viagens

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/POO-Programação%20Orientada%20a%20Objetos-2F80ED?style=for-the-badge">
  <img src="https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white">
  <img src="https://img.shields.io/badge/Status-Concluído-2EA44F?style=for-the-badge">
</p>

<p align="center">
  <strong>🌎 Sistema de gerenciamento de pacotes e vendas para uma agência de viagens</strong>
</p>

<p align="center">
  Projeto desenvolvido em Java para praticar conceitos de 
  <strong>Programação Orientada a Objetos (POO)</strong>.
</p>

<p align="center">
  <a href="#-sobre-o-projeto">Sobre</a> •
  <a href="#-funcionalidades">Funcionalidades</a> •
  <a href="#-estrutura">Estrutura</a> •
  <a href="#-conceitos">Conceitos</a> •
  <a href="#-execução">Execução</a>
</p>

---

## 🌎 Sobre o projeto

O **Empresa de Viagens** é uma aplicação de console desenvolvida em **Java**, simulando o funcionamento básico de uma agência de viagens.

O sistema permite criar um **pacote de viagem** composto por transporte, hospedagem, destino e quantidade de dias.

A aplicação também calcula o valor da hospedagem, aplica uma margem de lucro, adiciona taxas extras e apresenta o valor final do pacote em **dólares**.

Após a criação do pacote, é possível cadastrar uma venda informando os dados do cliente, forma de pagamento e a cotação do dólar para realizar a conversão do valor para **reais**.

---

## ✨ Funcionalidades

### 🧳 Pacote de viagem

* 🚍 Cadastro do tipo de transporte;
* 💵 Definição do valor do transporte;
* 🏨 Cadastro da hospedagem;
* 💰 Definição do valor da diária;
* 🌎 Definição do destino;
* 📅 Definição da quantidade de dias;
* 🧮 Cálculo do total da hospedagem;
* 📈 Aplicação da margem de lucro;
* 💸 Inclusão de taxas adicionais;
* 💵 Cálculo do valor total em dólar.

### 🛒 Venda

* 👤 Cadastro do nome do cliente;
* 💳 Definição da forma de pagamento;
* 📦 Associação com o pacote de viagem;
* 💱 Conversão de dólar para real;
* 📊 Exibição do valor final da venda.

---

## 🏗️ Estrutura do projeto

```text
Empresa_de_viagens/
│
├── 📁 Arquivos/
│   ├── 📄 Main.java
│   ├── 📄 Transporte.java
│   ├── 📄 Hospedagem.java
│   ├── 📄 PacoteViagem.java
│   └── 📄 Venda.java
│
├── 📄 LICENSE
└── 📄 README.md
```

---

## 🧩 Arquitetura das classes

```text
                    ┌─────────────────┐
                    │    Transporte   │
                    │─────────────────│
                    │ tipo            │
                    │ valor           │
                    └────────┬────────┘
                             │
                             │
                             ▼
                    ┌─────────────────┐
                    │  PacoteViagem   │
                    │─────────────────│
                    │ transporte      │
                    │ hospedagem      │
                    │ destino         │
                    │ quantidadeDias  │
                    └────────┬────────┘
                             │
                             │
                             ▼
                    ┌─────────────────┐
                    │      Venda      │
                    │─────────────────│
                    │ nomeCliente     │
                    │ formaPagamento  │
                    │ pacoteViagem    │
                    └─────────────────┘
                             ▲
                             │
                    ┌────────┴────────┐
                    │   Hospedagem    │
                    │─────────────────│
                    │ descricao       │
                    │ valorDiaria     │
                    └─────────────────┘
```

---

## 🚍 Transporte

A classe `Transporte` representa o meio de transporte utilizado no pacote.

### Atributos

| Atributo | Tipo     | Descrição           |
| -------- | -------- | ------------------- |
| `tipo`   | `String` | Tipo do transporte  |
| `valor`  | `double` | Valor do transporte |

Exemplos:

```text
✈️ Aéreo
🚌 Rodoviário
🚢 Marítimo
```

---

## 🏨 Hospedagem

A classe `Hospedagem` representa a hospedagem escolhida para a viagem.

### Atributos

| Atributo      | Tipo     | Descrição                     |
| ------------- | -------- | ----------------------------- |
| `descricao`   | `String` | Descrição do hotel/hospedagem |
| `valorDiaria` | `double` | Valor da diária               |

O valor total é calculado com base na quantidade de dias:

```text
Total hospedagem = Valor da diária × Quantidade de dias
```

---

## 🌎 PacoteViagem

A classe `PacoteViagem` reúne os principais elementos necessários para formar um pacote turístico.

### Atributos

| Atributo         | Tipo         |
| ---------------- | ------------ |
| `transporte`     | `Transporte` |
| `hospedagem`     | `Hospedagem` |
| `destino`        | `String`     |
| `quantidadeDias` | `int`        |

### Principais métodos

```java
calcularTotalHospedagem()
calcularValorComMargem()
calcularTotalPacote()
```

O valor final considera:

```text
┌───────────────────────────────┐
│       VALOR DO PACOTE         │
├───────────────────────────────┤
│ Transporte                    │
│ + Hospedagem                  │
│ + Taxas adicionais            │
│ + Margem de lucro             │
└───────────────────────────────┘
```

> 💡 Os valores do pacote são considerados em **dólares (US$)**.

---

## 💳 Venda

A classe `Venda` representa a comercialização do pacote para um cliente.

### Atributos

| Atributo         | Tipo           |
| ---------------- | -------------- |
| `nomeCliente`    | `String`       |
| `formaPagamento` | `String`       |
| `pacoteViagem`   | `PacoteViagem` |

### Conversão de moeda

O sistema utiliza a cotação informada pelo usuário:

```text
Valor em dólar × Cotação do dólar = Valor em reais
```

Exemplo:

```text
US$ 1.000,00
      ×
R$ 5,50
      ↓
R$ 5.500,00
```

---

## 🧠 Conceitos de Programação Orientada a Objetos

Este projeto foi desenvolvido com foco na prática de conceitos fundamentais de **POO**.

### 🔹 Classes e objetos

Cada entidade do sistema possui sua própria classe:

```text
Transporte
Hospedagem
PacoteViagem
Venda
```

### 🔹 Encapsulamento

Os atributos são privados e acessados através de métodos `getters` e `setters`.

### 🔹 Construtores

As classes utilizam construtores para facilitar a criação dos objetos.

### 🔹 Associação entre objetos

O `PacoteViagem` possui objetos de `Transporte` e `Hospedagem`.

A `Venda`, por sua vez, possui um objeto `PacoteViagem`.

### 🔹 Métodos

As regras de negócio foram organizadas em métodos específicos para facilitar a manutenção e compreensão do código.

### 🔹 Sobrescrita

A classe `PacoteViagem` utiliza `toString()` para apresentar suas informações de forma organizada.

---

## 🖥️ Exemplo de execução

```text
====================================
       EMPRESA DE VIAGENS
====================================

Cadastro do transporte
Tipo: Aéreo
Valor: US$ 500,00

Cadastro da hospedagem
Descrição: Hotel 4 estrelas
Valor da diária: US$ 120,00

Destino: Orlando
Quantidade de dias: 5

Margem de lucro: 20%
Taxas adicionais: US$ 50,00

------------------------------------
       PACOTE DE VIAGEM
------------------------------------

Destino: Orlando
Dias: 5
Transporte: Aéreo
Hospedagem: Hotel 4 estrelas

Total hospedagem: US$ 600,00
Total do pacote: US$ 1.380,00

------------------------------------
              VENDA
------------------------------------

Cliente: Samuel
Forma de pagamento: Cartão de crédito

Cotação do dólar: R$ 5,50

Total em dólar: US$ 1.380,00
Total em reais: R$ 7.590,00
```

---

## ▶️ Como executar

### Pré-requisitos

Antes de executar o projeto, tenha instalado:

* ☕ Java JDK;
* 💻 NetBeans ou outra IDE Java.

### Executando pelo NetBeans

1. Clone o repositório;
2. Abra o projeto no NetBeans;
3. Localize a classe `Main.java`;
4. Execute o projeto;
5. Informe os dados solicitados pelo console.

### Executando pelo terminal

Entre na pasta que contém os arquivos `.java` e compile:

```bash
javac *.java
```

Depois execute:

```bash
java Main
```

---

## 📚 Finalidade acadêmica

Este projeto foi desenvolvido como exercício prático para consolidar conhecimentos em **Java e Programação Orientada a Objetos**.

A proposta utiliza um cenário próximo de um sistema real para praticar a modelagem de entidades, relacionamento entre objetos e implementação de regras de negócio.

---

## 🚀 Próximos passos

Possíveis melhorias para versões futuras:

* [ ] Criar um menu interativo;
* [ ] Permitir cadastrar vários clientes;
* [ ] Permitir cadastrar vários pacotes;
* [ ] Criar histórico de vendas;
* [ ] Adicionar validação dos dados;
* [ ] Implementar conversão de real para dólar;
* [ ] Persistir informações em arquivos;
* [ ] Integrar com banco de dados;
* [ ] Criar interface gráfica;
* [ ] Criar testes automatizados.

---

## 🛠️ Tecnologias

| Tecnologia        | Utilização             |
| ----------------- | ---------------------- |
| ☕ **Java**        | Linguagem principal    |
| 💻 **NetBeans**   | IDE utilizada          |
| 🧠 **POO**        | Arquitetura do projeto |
| ⌨️ **Console**    | Interface da aplicação |
| 📦 **Git/GitHub** | Versionamento          |

---

## 👨‍💻 Autor

### Samuel Jorge Covalski

Estudante de **Desenvolvimento de Sistemas**, construindo projetos para desenvolver conhecimentos em programação e ampliar meu portfólio na área de tecnologia.

<p align="center">
  <a href="https://github.com/Sajoco-afk">
    <img src="https://img.shields.io/badge/GitHub-Sajoco--afk-181717?style=for-the-badge&logo=github">
  </a>
</p>

---

## 📄 Licença

Este projeto está disponível sob a licença **MIT**.

---

<p align="center">
  ⭐ <strong>Se este projeto ajudou nos seus estudos, considere deixar uma estrela!</strong>
</p>

<p align="center">
  Desenvolvido com ☕ Java, dedicação e aprendizado contínuo.
</p>
