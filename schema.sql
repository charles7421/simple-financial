============================
## Schema para utilização ##
============================

/*
- BD utilizado: MySQL 5.6.
- Padrões de normalização utilizados.
  * Ser o mais descritivo/intuitivo possível no nome do campo.
  * Seguir conceitos do não-relacional, "evitando" relacionamentos entre tabelas e otimizando/reduzindo código.
  * Nome das tabelas, sempre plural, sempre minúsculo. E no caso, dos campos somente minúsculo.
  * Toda tabela criada deve ter o seu devido comentário, data de criação, e se for o caso, data de atualização.
  * Identificador da tabela: id_nome_da_tabela.
  * Quando houver necessidade de nome composto na variavel, usar underline("_").
  * Campos pequenos: (varchar(100), int(10), decimal(4,2),  bit(1))
  * Campos médios:   (varchar(250), int(20), decimal(10,2), bit(1))
  * Campos maiores:  (varchar(500) ou TEXT, int(50), decimal(100,2), bit(1))
  * Campos "bit" sempre com default apropriado - Ex: DEFAULT b'0' quando padrão = false.
  * 
*/

=============
## TABELAS ##
=============

/*
--------------
Nome da tabela
--------------
usuários

-----------
Informações
-----------
Criação    : 27/08/2016
Atualização: 27/08/2016

----------
Descrição
----------
Tabela para armazenamento de usuários, sendo pessoa física ou jurídica.

*/

CREATE TABLE usuarios (
   id_usuario          int(10)       NOT NULL AUTO_INCREMENT,
   tipo                varchar(100)  DEFAULT NULL,
   nome_fantasia       varchar(250)  DEFAULT NULL,
   razao_social        varchar(500)  DEFAULT NULL,
   user                varchar(100)  DEFAULT NULL,
   senha               varchar(100)  DEFAULT NULL,
   primeiro_nome       varchar(250)  DEFAULT NULL,
   segundo_nome        varchar(250)  DEFAULT NULL,
   cpf                 varchar(20)   DEFAULT NULL,
   cnpj                varchar(30)   DEFAULT NULL,
   atividade_principal varchar(200)  DEFAULT NULL,
   regime_tributario   varchar(100)  DEFAULT NULL,
   aliquota_simples    decimal(4,2)  DEFAULT NULL,
   taxa_um             decimal(4,2)  DEFAULT NULL,
   taxa_dois           decimal(4,2)  DEFAULT NULL,
   caixa_inicial       decimal(10,2) DEFAULT NULL,
   logo                varchar(255)  DEFAULT NULL,
   ativo               bit(1)        DEFAULT b'1',
   bloqueado           bit(1)        DEFAULT b'0',
   email               varchar(100)  DEFAULT NULL,
   email_confirmado    bit(1)        DEFAULT b'0',
   telefone            varchar(100)  DEFAULT NULL,
   facebook            varchar(500)  DEFAULT NULL,
   dt_cadastro         date          DEFAULT NULL,
   dt_encerramento     date          DEFAULT NULL,
   trial               bit(1)        DEFAULT b'0',
   PRIMARY KEY (id_usuario)
);

/*
--------------
Nome da tabela
--------------
clientes_fornecedores

-----------
Informações
-----------
Criação    : 27/08/2016
Atualização: 27/08/2016

----------
Descrição
----------
Tabela para armazenamento de clientes e fornecedores para ambos os tipos de cadastro de usuário.
No caso desta tabela, os campos "cidade", "endereço", "estado", são buscado via webservice.
É gerada uma repetição, porem ganha-se em desempenho, por evitar os relacionamentos.

*/

CREATE TABLE clientes_fornecedores (
   id_cliente_fornecedor int(10)       NOT NULL AUTO_INCREMENT,
   id_usuario            int(10)       NOT NULL
   tipo                  varchar(100)  DEFAULT NULL,
   nome_fantasia         varchar(250)  DEFAULT NULL,
   razao_social          varchar(500)  DEFAULT NULL,
   cpf                   varchar(20)   DEFAULT NULL,
   cnpj                  varchar(30)   DEFAULT NULL,
   atividade_principal   varchar(200)  DEFAULT NULL,
   ativo                 bit(1)        DEFAULT b'1',
   email                 varchar(100)  DEFAULT NULL,
   telefone              varchar(100)  DEFAULT NULL,
   cep                   varchar(100)  DEFAULT NULL,
   endereco              varchar(500)  DEFAULT NULL,
   complemento           varchar(500)  DEFAULT NULL,
   cidade                varchar(250)  DEFAULT NULL,
   estado                varchar(100)  DEFAULT NULL,
   telefone              varchar(100)  DEFAULT NULL,
   dt_cadastro           date          DEFAULT NULL,
   dt_ultima_alteracao   date          DEFAULT NULL,
   observacoes           text          DEFAULT NULL,
   palavras_chave        varchar(500)  DEFAULT NULL,
   PRIMARY KEY (id_cliente_fornecedor),
   CONSTRAINT `fk_clientes_fornecedores_usuarios` FOREIGN KEY ("id_usuario") REFERENCES usuarios ("id_usuario")
);


/*
--------------
Nome da tabela
--------------
categorias

-----------
Informações
-----------
Criação    : 27/08/2016
Atualização: 27/08/2016

----------
Descrição
----------
Tabela para identificar qual categoria a despesa/receita se enquadra.
Ex: Salário, Estudos, Gasolina ou ainda, escritório, despesas fixas, internet.

*/

CREATE TABLE categorias (
  id_categoria        int(10)      NOT NULL AUTO_INCREMENT,
  descricao           varchar(500) DEFAULT NULL,
  PRIMARY KEY (id_categoria)
)
