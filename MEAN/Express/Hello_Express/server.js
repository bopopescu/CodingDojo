var express = require("express");
var bodyParser = require('body-parser');

var session = require('express-session');


var app = express();

app.get('/', function(request, response){
    response.send("Hello Express!");
})

app.listen(5000, function(){
    console.log("listening on 8000");
})

app.use(express.static(__dirname + "/static"));

app.set('views', __dirname + '/views'); 

app.set('view engine', 'ejs');

app.get("/users", function (request, response){
    // hard-coded user data
    var users_array = [
        {name: "Michael", email: "michael@codingdojo.com"}, 
        {name: "Jay", email: "jay@codingdojo.com"}, 
        {name: "Brendan", email: "brendan@codingdojo.com"}, 
        {name: "Andrew", email: "andrew@codingdojo.com"}
    ];
    response.render('users', {users: users_array});
})


app.post("/users", function (request, response){
    // hard-coded user data
    console.log("POST DATA \n\n", request.body)
    request.session.name = request.body.name;
    console.log(request.session.name);
    //code to add user to db goes here!
    // redirect the user back to the root route.  
    res.redirect('/')
})

app.get("/users/:id", function (req, res){
    console.log("The user id requested is:", req.params.id);
    // just to illustrate that req.params is usable here:
    res.send("You requested the user with id: " + req.params.id);
    // code to get user from db goes here, etc...
});


// use it!
app.use(bodyParser.urlencoded({extended: true}));

app.use(session({secret: 'codingdojorocks'}));  // string for encryption


// npm init -y
// then run npm install express