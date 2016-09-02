// Dependências
var express = require('express');
var router = express.Router();

// Models
var Usuarios = require('../models/usuario');
var ClientesFornecedores = require('../models/cliente_fornecedor');

// Routes
Usuarios.methods( [ 'get', 'put', 'post', 'delete' ] );
Usuarios.register(router, '/usuarios');

ClientesFornecedores.methods( [ 'get', 'put', 'post', 'delete' ] );
ClientesFornecedores.register(router, '/clientes_fornecedores');


// Return router
module.exports = router;