var mongoose = require('mongoose');

var NoteSchema = new mongoose.Schema({
    text: String
}, { timestamps: {} })

mongoose.model('Note', NoteSchema);

