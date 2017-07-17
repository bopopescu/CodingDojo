var mongoose = require('mongoose')
var User = mongoose.model('User')

var users = require('../controllers/users.js')

module.exports = function(app){
    app.get('/', function(req, res) {
        res.render("index");
    })
    app.post('/usersnames', function(req,res){
        console.log(req.body)
        console.log("Dsds")
        users.create(req, res)
    })
    app.get('/main', function (req, res) {
        users.show(req, res)
    })
}