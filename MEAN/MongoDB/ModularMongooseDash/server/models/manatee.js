var mongoose = require('mongoose')

var ManateeSchema = new mongoose.Schema({
  name: String,
  ocean: String,
  image: String,
  age: Number
})

var Manatee = mongoose.model('Manatee', ManateeSchema);