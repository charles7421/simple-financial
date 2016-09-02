const mongoose = require('mongoose');

module.exports = { "usuario_id": { type: mongoose.Schema.Types.ObjectId, ref: 'usuario' }}
