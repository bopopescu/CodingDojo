// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
var mongoose = require('mongoose');

// This is how we connect to the mongodb database using mongoose -- "basic_mongoose" is the name of
//   our db in mongodb -- this should match the name of the db you are going to use for your project.
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/basic_mongoose_app');
var ManateesSchema = new mongoose.Schema({
 name: {type: String, required: true, minlength: 3},
 ocean: {type: String, required: true, minlength: 3}
}, {timestamps: true})
mongoose.model('Manatee', ManateesSchema); // We are setting this Schema in our Models as 'User'
var Manatee = mongoose.model('Manatee') // We are retrieving this Schema from our Models, named 'User'


var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

var path = require('path');

app.use(express.static(path.join(__dirname, './static')));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    Manatee.find({}, function(errors, manatees){
        console.log('errors', errors);
        // console.log('users:', manatees)
        res.render('index', {allManatees: manatees});
        
    })
})

app.get('/manatees/new', function(req, res) {
    res.render('manateeform')
})

app.get('/manatees/:id', function(req, res) {
    Manatee.findOne({_id: req.params.id}, function(errors, manatee){
        console.log('errors', errors);
        console.log('that manatee:', manatee)

        res.render('onemanatee', {thismanatee: manatee});
        
    })
})



app.post('/manatees', function(req, res){
    console.log("POST DATA fffffffffffffffffff", req.body);
    var manatee = new Manatee({name: req.body.name, ocean: req.body.ocean});
  // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
  manatee.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong');
      res.render('index', {title: 'you have errors!', errors: manatee.errors});
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a quote and name!');
      res.redirect('/');
    }
  })
    
})

app.get('/manatees/edit/:id', function(req, res) {
    Manatee.findOne({_id: req.params.id}, function(errors, manatee){
        console.log('errors', errors);
        console.log('that manatee:', manatee)
        res.render('editonemanatee', {thismanatee: manatee});
    })
})

app.post('/manatees/:id', function(req, res){
    console.log("edit hghghghghg")
    Manatee.findOne({_id: req.params.id}, function(errors, manatee){
        manatee.name = req.body.name;
        manatee.ocean = req.body.ocean;
        manatee.save(function(err){
        if(err) {
            console.log('something went wrong');
            res.render('editonemanatee', {title: 'you have errors!', errors: manatee.errors,thismanatee: manatee});
        } else { // else console.log that we did well and then redirect to the root route
            console.log('successfully added a quote and name!');
            res.redirect('/manatees/' + manatee._id);
        }
        })
        
    })
})

app.post('/manatees/destroy/:id', function(req, res){
    Manatee.remove({_id: req.params.id}, function(err){
        res.redirect('/');
    })
})

// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})
