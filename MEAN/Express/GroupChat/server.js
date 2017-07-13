// require express
var express = require("express");
// path module -- try to figure out where and why we use this
var path = require("path");

var session = require('express-session');

var bodyParser = require('body-parser');
// use it!

// create the express app
var app = express();
app.use(express.static(path.join(__dirname, 'static')));

app.use(bodyParser.urlencoded({extended: true}));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view

app.use(session({secret: 'codingdojorocks'}));  // string for encryption

app.get('/', function(req, res) {
    res.render("index");
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

var messages = [];
// Whenever a connection event happens (the connection event is built in) run the following code
io.sockets.on( 'connection', function (socket) {
  console. log( "WE ARE USING SOCKETS!");
  console. log(socket.id);
  var users = []
  //all the socket code goes in here!
    
    socket.on( "got_a_new_user", function (data){
        console.log('test');
        console.log('message: ' + data.name);
        socket.emit('new_user', {name: data.name, previous_convo: messages})
        console.log("getting prev "+messages)
        users.push(data.name)
        socket.emit("existing_users", users)

    })
    
    socket.on("theconvo", function(data){
        console.log("the message on the server side is "+data.themessage);
        var theresponse = data.user_name+": "+data.themessage;
        messages.push(theresponse);
        io.sockets.emit("updated_chat", {response: theresponse})
    })

    

})
