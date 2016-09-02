// Dependências
var express = require('express');
var bodyParser = require('body-parser');
require('./util/config');

// Express
var app = express();
app.use( bodyParser.urlencoded( { extended: true } ) );
app.use( bodyParser.json() );

// Routes
app.use('/api', require('./routes/api'));

// Start server
app.listen(3000);
console.log('API is running on port 3000');
