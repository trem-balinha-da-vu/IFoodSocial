# 🍽️ IFoodSocial

Trabalho desenvolvido para a disciplina **Linguagem de Programação III** do curso de Ciência da Computação na **UESC**. Este sistema foi criado para simular um ambiente de **cadastro de produtos e pedidos**, com a simulação de **entregas realizadas por diferentes meios**, como a pé, de carro e por drone. O código foi feito por mim durante o semestre **2024.2**.

---

## ☕ Sobre o Projeto

**IfoodSocial** é uma aplicação que permite o cadastro de categorias de produtos, produtos em si, e a gestão de pedidos com uma simulação interativa das entregas. As entregas podem ser realizadas por diferentes meios, e o programa exibe o caminho percorrido pelo entregador, além de calcular o consumo de combustível (quando aplicável).

## 📁 Estrutura do Programa

O sistema é composto por várias classes que se inter-relacionam para fornecer as funcionalidades principais.

### 🏁 1. Classe Principal

A classe principal **gerencia a execução do programa**, interage com o usuário, e aciona as funcionalidades das demais classes.

### 🗂️ 2. Classe Categoria

- **Responsabilidade:** Representa uma categoria de produtos (como "Lanches" ou "Bebidas").
- **Atributos:** Contém código e descrição.
- **Métodos:** Getters, setters e `imprimir()` para exibir os detalhes de maneira formatada.

### 🛒 3. Classe Produto

- **Responsabilidade:** Representa um produto, associando-o a uma categoria.
- **Atributos:** Código, descrição, preço, e categoria.
- **Funcionalidade:** Usa `NumberFormat` para formatação monetária.
- **Métodos:** Getters, setters e `imprimir()` para exibir os detalhes formatados.

### 📦 4. Classe Pedido

- **Responsabilidade:** Representa um pedido com código gerado aleatoriamente.
- **Atributos:** Código do pedido e lista de produtos.
- **Métodos:** Adição de produtos, getters e `imprimir()` para exibir os detalhes do pedido.

---

## 🚚 5. Simulação de Entrega

O sistema implementa uma simulação de entregas através de uma classe base e suas derivadas.

### 🏗️ Classe Base: Entrega

- **Responsabilidade:** Armazena informações gerais da entrega (entregador, lista de movimentos, distância percorrida).
- **Métodos:** Movimentação nas direções cardeais (Norte, Sul, Leste, Oeste), exibição do caminho e do mapa da entrega.

### 🚶‍♂️ Entrega a Pé

Simula uma entrega a pé.

### 🚗 Entrega de Carro

Inclui o cálculo de consumo de combustível com base na distância percorrida.

### 🚁 Entrega por Drone

Permite movimentar o drone diretamente para coordenadas específicas, calculando a distância percorrida.

---

## 🔧 Funcionalidades do Programa

- **📑 Cadastro de Categorias e Produtos:** O usuário pode criar e gerenciar categorias e associar produtos a elas.
- **🛍️ Criação de Pedidos:** Permite adicionar produtos ao pedido e visualizar detalhes.
- **🚀 Simulação de Entregas:** O entregador pode ser movido pelo mapa e o sistema calcula a distância percorrida.
- **📊 Visualização de Caminho e Consumo:** O programa exibe o mapa do caminho e calcula o consumo de combustível para entregas de carro.

---

## 🖥️ Exemplo de Uso

1. O usuário cadastra categorias, como "Lanches" e "Bebidas".
2. Produtos são atribuídos a essas categorias.
3. Um pedido é criado, e produtos são adicionados ao pedido.
4. A entrega é simulada com a escolha do meio de transporte (a pé, carro ou drone).
5. O programa exibe a distância percorrida, o caminho visual e o consumo de combustível, quando aplicável.

---

## 📑 Detalhes Técnicos

- **Encapsulamento:** Atributos privados, acessados por métodos getters e setters.
- **Herança:** Classes de entrega (a pé, carro, drone) herdam da classe base `Entrega`.
- **Formatação Monetária:** Uso de `NumberFormat` para formatar preços.

---

## 🛠️ Tecnologias Utilizadas

- **Java** ![Java logo](https://cdn.iconscout.com/icon/free/png-256/java-60-1174953.png)
- **NumberFormat** para formatação monetária.
- **Princípios de Orientação a Objetos**, incluindo encapsulamento e herança.
