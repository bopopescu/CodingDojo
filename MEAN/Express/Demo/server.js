// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
var mongoose = require('mongoose');

// This is how we connect to the mongodb database using mongoose -- "basic_mongoose" is the name of
//   our db in mongodb -- this should match the name of the db you are going to use for your project.
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/basic_mongoose_app');
var UserSchema = new mongoose.Schema({
 name: {type: String},
 email: {type: String},
 password: {type: String}
}, {timestamps: true})
mongoose.model('User', UserSchema); // We are setting this Schema in our Models as 'User'
var User = mongoose.model('User') // We are retrieving this Schema from our Models, named 'User'


// Require body-parser (to receive post data from clients)
var bodyParser = require('body-parser');
// Integrate body-parser with our App
app.use(bodyParser.urlencoded({ extended: true }));
// Require path
var path = require('path');
// Setting our Static Folder Directory
app.use(express.static(path.join(__dirname, './static')));
// Setting our Views Folder Directory
app.set('views', path.join(__dirname, './views'));
// Setting our View Engine set to EJS
app.set('view engine', 'ejs');
// Routes
// Root Request
app.get('/', function(req, res) {
    var users = User.find({}, function(err, data){
        console.log(data)
        if(err){
            console.log(err, "there's error!")
        }
        res.render('index', {users: data});
    })
    console.log("runnnningggg")
    
})

 
  
     
// Add User Request 
app.post('/users', function(req, res) {
    console.log("POST REQUEST USERS", req.body);
    var user = new User({name: req.body.name, email: req.body.email, password: req.body.password})
    user.save();
    res.redirect('/');
})
// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})
