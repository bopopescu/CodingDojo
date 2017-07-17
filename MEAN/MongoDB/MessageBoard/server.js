// Require the Express Module
var express = require('express');
// Create an Express App
var app = express();
var mongoose = require('mongoose');

// This is how we connect to the mongodb database using mongoose -- "basic_mongoose" is the name of
//   our db in mongodb -- this should match the name of the db you are going to use for your project.
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/MessageBoard');
// define Schema variable
var Schema = mongoose.Schema;
// define Post Schema
var PostSchema = new mongoose.Schema({
 name: {type: String, required: true, minlength: 4},
 text: {type: String, required: true}, 
 comments: [{type: Schema.Types.ObjectId, ref: 'Comment'}]
}, {timestamps: true });
// define Comment Schema
var CommentSchema = new mongoose.Schema({
 _post: {type: Schema.Types.ObjectId, ref: 'Post'},
 name: {type: String, required: true, minlength: 4  },
 text: {type: String, required: true }
}, {timestamps: true });
// set our models by passing them their respective Schemas
mongoose.model('Post', PostSchema);
mongoose.model('Comment', CommentSchema);
// store our models in variables
var Post = mongoose.model('Post');
var Comment = mongoose.model('Comment');


var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));

var path = require('path');

app.use(express.static(path.join(__dirname, './static')));
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');



app.get('/', function(req, res) {
    Post.find({})
        .populate('comments')
        .exec(function(errors, data){
            console.log(data)
            res.render('index', {allPosts: data});
        });
        
    })

app.post('/postmessage', function(req, res){
    console.log("POST DATA", req.body)
    var themessage = new Post({name: req.body.name, text: req.body.message})

    themessage.save(function(err){
        if(err) {
            console.log('something went wrong');
            res.render('index', {title: 'you have errors!', errors: themessage.errors});
        } else { // else console.log that we did well and then redirect to the root route
            console.log('successfully added a quote and name!');
            res.redirect('/');
        }
    })

})

/*
    so for example:
    User{id: 3, name: "Sue", posts: [345, 346]}
    Post: {id: 345, post: , _userId: 3}, {id: 346, post: , _userId: 3}
*/


// route for getting a particular post and comments
app.get('/posts/:id', function (req, res){
 Post.findOne({_id: req.params.id})
 .populate('comments') //you get all the comments for particular post
 .exec(function(err, post) { //this is when you execute!
      res.render('index', {allPosts: post});
        });
});
// route for creating one comment with the parent post id
app.post('/posts/:id', function (req, res){
    console.log("commentsss!!!!");  
  Post.findOne({_id: req.params.id}, function(err, post){
         var comment = new Comment({name: req.body.name, text: req.body.comment});
         //var comment = new Comment({_post: req.params.id, name: req.body.name, text: req.body.comment})
         comment._post = post._id;
         console.log(post.name)
         console.log(comment)
         post.comments.push(comment);
         comment.save(function(err){
                 post.save(function(err){
                       if(err) { console.log('Error'); } 
                       else { 
                           console.log("it workssss")
                           res.redirect('/'); }
                 });
         });
   });
 });


// Setting our Server to Listen on Port: 8000
app.listen(8000, function() {
    console.log("listening on port 8000");
})
