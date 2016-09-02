// Dependências
const restful = require('node-restful');
const mongoose = restful.mongoose;
const Schema = mongoose.Schema;

//var funcoes = require('../util/functions');

const cpf = require('./fields/field-cpf');
const cnpj = require('./fields/field-cnpj');

// Schema 
var usuarioSchema = new Schema({
	"tipo": String,
	"nome_fantasia": String,
	"razao_social": String,
	"user": { type: String, required: true, unique: true },
	"senha": { type: String, required: true, select: false },
	"primeiro_nome": String,
	"segundo_nome": String,
	cpf,
    cnpj,
	"configuracoes": {
		"atividade_principal": String,
		"regime_tributario": String,
		"aliquota_simples": Number,
		"moeda": String,
		"taxa_um": Number,
		"taxa_dois": Number,
		"caixa_inicial": String,
		"logo_path": String
	},
	"auth": {
        "username" : String,
        "email" : String,
        "password" : String,
        "last_access" : Date,
        "online" : Boolean,
        "disabled" : Boolean,
        "hash_token" : String
    },
    "arquivos": [{
		"name": String,
        "path": String,
        "weight": String
    }],
    "clientes_fornecedores": [{
        "tipo": String,
        "nome": String,
        "cliente_fornecedor_id": [{ type: Schema.Types.ObjectId, ref: 'cliente_fornecedor' }]
    }],
    "ativo": { type: Boolean, default: true },
    "bloqueado": { type: Boolean, default: false },
    "email": String,
    "email_confirmado": { type: Boolean, default: false },
    "telefone": String,
    "redes_sociais": {
    	"facebook": String,
    	"google_plus": String
    },
    "dt_cadastro": { type: Date, default: Date.now },
    "dt_encerramento": Date,
    "trial": { type: Boolean, default: false }
});


// Return model
module.exports = restful.model('usuario', usuarioSchema);