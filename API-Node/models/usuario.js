// Dependências
var restful = require('node-restful');
var mongoose = restful.mongoose;

// Schema 
var usuarioSchema = new mongoose.Schema({
	"tipo": String,
	"nome_fantasia": String,
	"razao_social": String,
	"user": String,
	"senha": String,
	"primeiro_nome": String,
	"segundo_nome": String,
	"cpf": String,
	"cnpj": String,
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
        "cliente_fornecedor_id": mongoose.Schema.Types.ObjectId
    }],
    "ativo": Boolean,
    "bloqueado": Boolean,
    "email": String,
    "email_confirmado": Boolean,
    "telefone": String,
    "redes_sociais": {
    	"facebook": String,
    	"google_plus": String
    },
    "dt_cadastro": Date,
    "dt_encerramento": Date,
    "trial": Boolean
});

// Return model
module.exports = restful.model('usuario', usuarioSchema);