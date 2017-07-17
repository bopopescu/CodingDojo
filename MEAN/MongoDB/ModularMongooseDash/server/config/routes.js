var mongoose = require('mongoose')
// var Manatee = mongoose.model('Manatee')

var manatees = require('../controllers/manatees.js')

module.exports = function(app){
    app.get('/', function(req, res) {
        console.log("dsddindex")
        manatees.index(req, res)
    })
    app.get('/manatees/new', function(req,res){
        res.render("manateeform")
    })
    app.get('/manatees/:id', function (req, res) {
        manatees.getthatmanatee(req, res)
    })
    app.post('/manatees', function(req, res){
        manatees.create(req, res)
    })
    app.get('/manatees/edit/:id', function(req, res) {
        manatees.edit(req, res)
    })
    app.post('/manatees/:id', function(req, res){
        manatees.update(req, res)
    })
    app.post('/manatees/destroy/:id', function(req, res){
        manatees.destroy(req, res)
    })

}