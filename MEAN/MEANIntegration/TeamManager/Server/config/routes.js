var path = require('path')
var player = require('../controllers/players.js')

module.exports = function(app){
    app.get('/players/list', function(req, res){
        console.log("getting list of players")
        player.show(req, res)
    });
    app.post('/addingplayer', (req, res, next) => {
        console.log("adding player from config/routes.js");
        //console.log(req)
        player.create(req, res)
    });
    app.post('/deleteplayers/:id', function(req, res){
        console.log("removing player from config/routes.js");
        player.delete(req, res)
    });
    app.post("/updateplayers/:id", function(req, res, next){
        console.log("changing player's status from config/routes.js");
        console.log(req.params.id)
        console.log(req.query)
        player.updateStatus(req, res)        
    })
    app.all("*", (req,res,next) => {
        res.sendfile(path.resolve("./../TeamClient/dist/index.html"))
    });

}