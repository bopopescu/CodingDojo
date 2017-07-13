// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
var mongoose = require('mongoose');

// This is how we connect to the mongodb database using mongoose -- "basic_mongoose" is the name of
//   our db in mongodb -- this should match the name of the db you are going to use for your project.
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/basic_mongoose_app');
var QuotesSchema = new mongoose.Schema({
 name: String,
 quotes: String
}, {timestamps: true})
mongoose.model('Quote', QuotesSchema); // We are setting this Schema in our Models as 'User'
var Quote = mongoose.model('Quote') // We are retrieving this Schema from our Models, named 'User'


var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

var path = require('path');

app.use(express.static(path.join(__dirname, './static')));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    res.render('index')
})

// Add Quotes Request 
app.post('/quotes', function(req, res) {
    console.log("POST DATA", req.body);
    var quote = new Quote({name: req.body.name, quotes: req.body.quote});
  // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
  quote.save(function(err) {
    // if there is an error console.log that something went wrong!
    if(err) {
      console.log('something went wrong');
      res.render('index', {title: 'you have errors!', errors: user.errors});
    } else { // else console.log that we did well and then redirect to the root route
      console.log('successfully added a quote and name!');
      res.redirect('/quotes');
    }
  })
})

app.get('/quotes', function(req, res){
    Quote.find({}, function(errors, quotes){
        console.log('errors', errors);
        console.log('users:', quotes)
        res.render('quotes', {allQuotes: quotes});
        
    })
})
// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})
