var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var ejs = require('ejs')
var path = require("path");
var app = express();
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json())
// static content
app.use(express.static(path.join(__dirname, '../NoteApp/dist')));
// setting up ejs and our views folder
// app.set('views', path.join(__dirname, './views'));
// app.set('view engine', 'ejs');

//CONNECT TO MONGODB

require('./config/db.js')

var routes_setter = require('./config/routes.js')
routes_setter(app)
// mongoose.connect('mongodb://localhost/meanapp');
app.listen(8000, function() {
    console.log("listening on port 8000");
});