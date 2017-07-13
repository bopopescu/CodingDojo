var express = require("express");
var path = require("path");
var session = require('express-session');


var app = express();
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view

app.use(session({secret: 'codingdojorocks'}));  // string for encryption

app.get('/', function(req, res) {
    res.render("count");
});

// app.get('/', function(req, res) {
//     var sess = req.session;
//     console.log(sess.views)
//     if(sess.views != undefined){
//         sess.count += 1;
        
//     }
//     else{
//         sess.views = 1;
//         sess.count = 1;
//     }
//     res.render("count", {count: sess.count});
// })

var server  = app.listen(9000, function() {
 console.log( "listening on port 9000");
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
    socket.on( "countingthenumber", function (data){
        console.log('test');
        if(session.count != undefined){
            session.count += 1
        }
        else{
            session.count = 1;
        }
        console.log('message: ' + session.count);

        socket.emit( 'updated_message', {response:  session.count });
    })
    socket.on( "resettingthenumber", function (data){
        console.log('testtwo');
        session.count = 0;
        console.log('message: ' + session.count);

        socket.emit( 'updated_message', {response:  session.count });
    })

})
