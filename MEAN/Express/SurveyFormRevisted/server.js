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
// app.post('/result', function(req, res) {
//      var sess = req.session;
//      sess.name = req.body.name;
//      sess.location = req.body.location
//      sess.language = req.body.language
//      sess.comment = req.body.comment

//     res.render("submit", {name: sess.name, location: sess.location, language: sess.language, comment: sess.comment});
// });


var server  = app.listen(8000, function() {
 console.log( "listening on port 8000");
});

// this is a new line we're adding AFTER our server listener
// take special note how we're passing the server
// variable. unless we have the server variable, this line will not work!!
var io  =  require( 'socket.io').listen(server);

// Whenever a connection event happens (the connection event is built in) run the following code
io.sockets.on( 'connection', function (socket) {
  console. log( "WE ARE USING SOCKETS!");
  console. log(socket.id);

  //all the socket code goes in here!
    socket.on( "posting_form", function (data){
        console.log('test');
        console.log('message: ' + data.myValue);

        console.log(data.myValue.name + " "+data.myValue.location+" "+data.myValue.language+" "+data.myValue.comment);

        socket.emit( 'updated_message', {response:  "{name: "+data.myValue.name+", location: "+data.myValue.location+", language:  "+data.myValue.language+", comment: "+data.myValue.comment+ "} " });
        socket.emit('random_number', {randomnumber: Math.floor(Math.random()*1000)+1})

    })

})
