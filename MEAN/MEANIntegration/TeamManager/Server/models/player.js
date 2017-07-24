var mongoose = require('mongoose');

var PlayerSchema = new mongoose.Schema({
    name: String,
    preferred_position: String,
    gameone: {type: String, default: "Undecided"},
    gametwo: {type: String, default: "Undecided"},
    gamethree: {type: String, default: "Undecided"}
}, { timestamps: {} })

mongoose.model('Player', PlayerSchema);

