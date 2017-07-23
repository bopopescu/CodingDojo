// require express
var express = require("express");
// path module -- try to figure out where and why we use this
// create the express app
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');

// use it!
const path = require('path'); 

app.use(express.static(path.join(__dirname, './BlackBelt/dist')));
// mongoose.connect('mongodb://localhost/products');
// var QuoteSchema = new mongoose.Schema({
//   name: String,
//   quote: String
// })
// var Quote = mongoose.model('Quote', QuoteSchema);


var routes_setter = require('./config/routes.js');
// invoke the function stored in routes_setter and pass it the "app" variable
routes_setter(app);


app.listen(8000, function() {
 console.log("listening on port 8000");
});

