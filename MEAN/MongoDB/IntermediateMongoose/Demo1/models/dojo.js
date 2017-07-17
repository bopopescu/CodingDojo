var mongoose = require('mongoose')
var dojoSchema = new mongoose.Schema({
    location: {type: String}
}, {timestamps: true})
mongoose.model('Dojo', dojoSchema)
