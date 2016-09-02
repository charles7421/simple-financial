// Dependências
const restful = require('node-restful');
const mongoose = restful.mongoose;
const Schema = mongoose.Schema;

// Schema 
const cpf = require('./fields/field-cpf');
const cnpj = require('./fields/field-cnpj');
const usuario_id = require('./fields/field-usuario-id');


var clienteFornecedorSchema = new Schema({
  	"tipo": String,
	"nome_fantasia": String,
    "razao_social": String,
    cpf,
    cnpj,
    "atividade_principal": String,
    "ativo": Boolean,
    "bloqueado": Boolean,
    "email": String,
    "enderecos": [{
        "cep": String,
        "endereco": String,
        "complemento": String,
        "cidade": String,
        "estado": String
    }],
    usuario_id,
    "telefone": String,
    "dt_cadastro": { type: Date, default: Date.now },
    "dt_ultima_alteracao": { type: Date, default: Date.now },
    "observacoes": [String],
    "palavras_chave": [String]
});

// Return model
module.exports = restful.model('cliente_fornecedor', clienteFornecedorSchema);