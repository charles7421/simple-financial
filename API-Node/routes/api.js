// Dependências
var express = require('express');
var router = express.Router();

// Models
var Products = require('../models/products');

// Routes
Products.methods(['get', 'put', 'post', 'delete']);
Products.register(router, '/products');


// Return router
module.exports = router;