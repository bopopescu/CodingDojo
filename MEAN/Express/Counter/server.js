var express = require("express");
var path = require("path");
var session = require('express-session');


var app = express();
app.set('views', path.join(__dirname, './views'));
app.set('view engine', 'ejs');
// root route to render the index.ejs view

app.use(session({secret: 'codingdojorocks'}));  // string for encryption

app.get('/', function(req, res) {
    var sess = req.session;
    console.log(sess.views)
    if(sess.views != undefined){
        sess.count += 1;
        
    }
    else{
        sess.views = 1;
        sess.count = 1;
    }
    res.render("count", {count: sess.count});
})

app.listen(8000, function() {
 console.log("listening on port 8000");
});

