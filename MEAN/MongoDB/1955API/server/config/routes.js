var mongoose = require('mongoose')
// var Manatee = mongoose.model('Manatee')

var names = require('../controllers/names.js')

module.exports = function(app){
    app.get('/', function(req, res) {
        console.log("dsddindex")
        names.index(req, res)
    })
    app.get('/new/:name', function(req,res){
        names.create(req, res)
    })
    app.get('/remove/:name', function (req, res) {
        names.remove(req, res)
    })
    app.get('/:name', function(req, res){
        names.find(req, res)
    })

}