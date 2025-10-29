# Sistema E-commerce em Java

Desenvolva um sistema de gerenciamento de produtos para um e-commerce, com **conexão a banco de dados MySQL** e operações básicas de listagem de produtos.

> Dicas para implementação:
>
> * Use o padrão DAO (Data Access Object) para separar a lógica de acesso ao banco
> * Crie uma interface para definir os métodos do repositório de produtos
> * Utilize uma classe de conexão (`ConexaoMySQL`) para gerenciar a conexão com o banco
> * Teste a listagem de produtos com a classe principal (`SistemaEcommerce`)

---

## Estrutura do Projeto

* `ucb.estudo.dao`
  Contém classes para acesso ao banco de dados:

    * `ConexaoMySQL` – gerencia conexão com MySQL
    * `ConexaoMySQLInterface` – define os métodos da conexão com MySQL
    * `RepositorioDeProdutos` – implementa operações de CRUD para produtos
    * `RepositorioDeProdutosInterface` – define os métodos do CRUD de produtos


* `ucb.estudo.model`
  Contém a classe modelo:

    * `Produto` – representa os produtos do e-commerce


* `ucb.estudo.app`
  Contém a classe principal:

    * `SistemaEcommerce` – testa a listagem de produtos e interação com o usuário

---

## Funcionalidades Implementadas

* Conexão com banco MySQL
* Listagem de todos os produtos disponíveis
* Tratamento de exceções ao conectar e consultar o banco
* Fechamento seguro de conexões, statements e result sets
