// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");

var session = require('express-session');

var bodyParser = require('body-parser');
// use it!


// create the express app
var app = express();
app.use(bodyParser.urlencoded({extended: true}));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view

app.use(session({secret: 'codingdojorocks'}));  // string for encryption

app.get('/', function(req, res) {
    res.render("form");
});

// post route for adding a user
app.post('/result', function(req, res) {
 console.log("POST DATA", req.body);
     var sess = req.session;
     console.log(req.body.name)
     sess.name = req.body.name;
     sess.location = req.body.location
     sess.language = req.body.language
     sess.comment = req.body.comment

    res.render("submit", {name: sess.name, location: sess.location, language: sess.language, comment: sess.comment});
});


app.listen(8000, function() {
 console.log("listening on port 8000");
});


