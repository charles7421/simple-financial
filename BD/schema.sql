/*

============================
## Schema para utilização ##
============================

/*
- BD utilizado: MySQL 5.6.
- Padrões de normalização utilizados.
  * Ser o mais descritivo/intuitivo possível no nome do campo.
  * Seguir conceitos do não-relacional, "evitando" relacionamentos entre tabelas e otimizando/reduzindo código.
  * Nome das tabelas e campos sempre em minúsculo.
  * Toda tabela criada deve ter o seu devido comentário, data de criação, e se for o caso, data de atualização.
  * Identificador da tabela: id_nome_da_tabela, no singular.
  * Quando houver necessidade de nome composto na variavel, usar underline("_").
  * Campos pequenos: (varchar(100), int(10), decimal(4,2),  bit(1))
  * Campos médios:   (varchar(250), int(20), decimal(10,2), bit(1))
  * Campos maiores:  (varchar(500) ou TEXT, int(50), decimal(100,2), bit(1))
  * Campos "bit" sempre com default apropriado - Ex: DEFAULT b'0' quando padrão = false.
  * Toda tabela descritiva deve ter um registro sem valor, um com valor irrelevante (Ex: Sem categoria, sem tipo documento).
*/

CREATE SCHEMA IF NOT EXISTS testews;
USE testews;

/*
=============
## TABELAS ##
=============
*/

/*
--------------
Nome da tabela
--------------
usuário

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
CREATE TABLE IF NOT EXISTS usuario (
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
   moeda               varchar(100)  DEFAULT NULL,
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
cliente_fornecedor

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

CREATE TABLE IF NOT EXISTS cliente_fornecedor (
   id_cliente_fornecedor int(10)       NOT NULL AUTO_INCREMENT,
   id_usuario            int(10)       NOT NULL,
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
   dt_cadastro           date          DEFAULT NULL,
   dt_ultima_alteracao   date          DEFAULT NULL,
   observacoes           text          DEFAULT NULL,
   palavras_chave        varchar(500)  DEFAULT NULL,
   PRIMARY KEY (id_cliente_fornecedor),
   CONSTRAINT fk_cliente_fornecedor_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
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
Tabela para identificar qual categoria a despesa/receita se enquadra. Semelhante a uma plano de contas simplificado.
Ex: Alimentação, Lazer, Moradia (Versão pessoa física), Despesas Fixas(Água, Luz, Telefone), Despesas Variaveis (Simples, Escritório)

*/

CREATE TABLE IF NOT EXISTS categoria (
  id_categoria        int(10)      NOT NULL AUTO_INCREMENT,
  descricao           varchar(250) DEFAULT NULL,
  PRIMARY KEY (id_categoria)
);

/*
--------------
Nome da tabela
--------------
sub_categoria

-----------
Informações
-----------
Criação    : 27/08/2016
Atualização: 27/08/2016

----------
Descrição
----------
Tabela para criar sub-categorias dentro de categorias.
Ex: Água, Luz, Telefone (Despesas Fixas), Alimentação (Compras, lanches).

*/

CREATE TABLE IF NOT EXISTS sub_categoria (
  id_sub_categoria    int(10)      NOT NULL AUTO_INCREMENT,
  id_categoria        int(10)      NOT NULL,
  descricao           varchar(250) DEFAULT NULL,
  PRIMARY KEY (id_sub_categoria)
);

ALTER TABLE sub_categoria 
  ADD CONSTRAINT `fk_sub_categoria_categoria` FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria);

/*
--------------
Nome da tabela
--------------
tipo_documento

-----------
Informações
-----------
Criação    : 29/08/2016
Atualização: 29/08/2016

----------
Descrição
----------
Tabela para identificar qual tipo de documento do lançamento financeiro.
Ex: Boleto, Cartão (Débito ou Crédito), Dinheiro, sem documento.

*/

CREATE TABLE IF NOT EXISTS tipo_documento (
  id_tipo_documento   int(10)      NOT NULL AUTO_INCREMENT,
  descricao           varchar(250) DEFAULT NULL,
  PRIMARY KEY (id_tipo_documento)
);

/*
--------------
Nome da tabela
--------------
cartao_credito

-----------
Informações
-----------
Criação    : 29/08/2016
Atualização: 29/08/2016

----------
Descrição
----------
Tabela para armazenar os cartões de crédito que o usuário possua.

*/

CREATE TABLE IF NOT EXISTS cartao_credito (
  id_cartao_credito     int(10)       NOT NULL AUTO_INCREMENT,
  descricao             varchar(250)  DEFAULT NULL,
  dt_vencimento_fatura  date          DEFAULT NULL,
  dt_fechamento_fatura  date          DEFAULT NULL,
  limite                decimal(10,2) DEFAULT NULL,
  saldo_restante        decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (id_cartao_credito)
);

/*
--------------
Nome da tabela
--------------
lancamento_financeiro

-----------
Informações
-----------
Criação    : 29/08/2016
Atualização: 29/08/2016

----------
Descrição
----------
Tabela para armazenar os lançamentos financeiros, seja contas a receber ou contas a pagar, separados apenas pelo tipo.
Campo id_lancamento_financeiro_vinculado é utilizado para vincular uma conta a receber ou pagar a outra. 
Ex: Várias parcelas de uma mesma fonte recebedora ou pagadora (Borderô).

-----------
Observações
-----------
Tipos: Conta a Receber, Conta a Pagar.
Status: Pago, Não Pago, Recebido, Não Recebido.
Campo ocorrencia_parcelamento (Diário, Mensal, Anual)

*/

CREATE TABLE IF NOT EXISTS lancamento_financeiro (
  id_lancamento_financeiro           int(10)       NOT NULL AUTO_INCREMENT,
  id_cliente_fornecedor              int(10)       NOT NULL,
  id_categoria                       int(10)       NOT NULL,
  id_sub_categoria                   int(10)       NOT NULL,
  id_tipo_documento                  int(10)       NOT NULL,
  id_cartao_credito                  int(10)       NOT NULL,
  descricao                          varchar(500)  DEFAULT NULL,
  tipo                               varchar(255)  DEFAULT NULL,
  situacao                           varchar(100)  DEFAULT NULL,
  dt_lancamento                      date          DEFAULT NULL,
  dt_vencimento                      date          DEFAULT NULL,
  dt_estorno                         date          DEFAULT NULL,
  despesa_fixa                       bit(1)        DEFAULT b'0',
  ocorrencia_despesa                 varchar(255)  DEFAULT NULL,
  parcelado                          bit(1)        DEFAULT b'0',
  ocorrencia_parcelamento            int(10)       DEFAULT NULL,
  qtd_parcelamento                   varchar(255)  DEFAULT NULL,
  valor                              decimal(10,2) DEFAULT NULL,
  observacao                         text,
  PRIMARY KEY (id_lancamento_financeiro)
); 

ALTER TABLE lancamento_financeiro
  ADD CONSTRAINT `fk_lancamento_financeiro_cliente_fornecedor`
      FOREIGN KEY (id_cliente_fornecedor)
      REFERENCES cliente_fornecedor (id_cliente_fornecedor);

ALTER TABLE lancamento_financeiro
  ADD CONSTRAINT `fk_lancamento_financeiro_categoria`
      FOREIGN KEY (id_categoria)
      REFERENCES categoria (id_categoria);

ALTER TABLE lancamento_financeiro
  ADD CONSTRAINT `fk_lancamento_financeiro_sub_categoria`
      FOREIGN KEY (id_sub_categoria)
      REFERENCES sub_categoria (id_sub_categoria);

ALTER TABLE lancamento_financeiro
  ADD CONSTRAINT `fk_lancamento_financeiro_tipo_documento`
      FOREIGN KEY (id_tipo_documento)
      REFERENCES tipo_documento (id_tipo_documento);

ALTER TABLE lancamento_financeiro
  ADD CONSTRAINT `fk_lancamento_financeiro_cartao_credito`
      FOREIGN KEY (id_cartao_credito)
      REFERENCES cartao_credito (id_cartao_credito);

INSERT
  INTO usuario
(tipo, user, senha, primeiro_nome, segundo_nome, cpf, moeda, caixa_inicial, email, email_confirmado, telefone, dt_cadastro) VALUES
('Física', 'charles7421', '123', 'Charles', 'Garcia', '087,549,036-02', 'Real (R$)', 0, 'charles7421@hotmail.com', b'1', '(34) 3821 0889', '2016-08-30');








