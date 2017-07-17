var mongoose = require('mongoose')



var UserSchema = new mongoose.Schema({
 email: {type: String, required: true, minlength: 3},
 first_name: {type: String, required: true, minlength: 3},
 last_name:{type: String, required: true, minlength: 3},
 password:{type: String, required: true, minlength: 3},
 birthday: {type: String, required: true, minlength: 3},

}, {timestamps: true})

var User = mongoose.model('User', UserSchema);