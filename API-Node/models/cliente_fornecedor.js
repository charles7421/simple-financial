// Dependências
var restful = require('node-restful');
var mongoose = restful.mongoose;

// Schema 
var clienteFornecedorSchema = new mongoose.Schema({
  	"tipo": String,
	"nome_fantasia": String,
    "razao_social": String,
    "cpf": String,
    "cnpj": String,
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
    "usuario_id": mongoose.Schema.Types.ObjectId,
    "telefone": String,
    "dt_cadastro": { type: Date, default: Date.now },
    "dt_ultima_alteracao": { type: Date, default: Date.now },
    "observacoes": [],
    "palavras_chave": []
});

// Return model
module.exports = restful.model('cliente_fornecedor', clienteFornecedorSchema);