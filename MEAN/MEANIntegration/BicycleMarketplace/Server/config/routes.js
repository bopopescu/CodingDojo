var path = require('path')
var bike = require('../controllers/bikes.js')
var user = require('../controllers/users.js')

module.exports = function(app){
    app.post('/addinguser', function(res, req){
        console.log("in adding user of routes.js in SERVER")
        console.log(req)
        user.createuser(req, res)
    });
    app.post('/findinguser', function(res, req){
        console.log("in adding user of routes.js in SERVER")
        user.finduser(req, res)        
    })
    app.get('/browsing', function(req, res){
        console.log("getting list of bikes from config/routes.js")
        bike.showbikes(req, res)
    });
    app.post('/addingbike', (req, res, next) => {
        console.log("adding bike from config/routes.js");
        //console.log(req)
        bike.createbike(req, res)
    });
    app.post('/deletebike/:id', function(req, res){
        console.log("removing bike from config/routes.js");
        bike.deletebike(req, res)
    });
    app.post("/updatebike/:id", function(req, res, next){
        console.log("updating bike from config/routes.js");
        console.log(req.params.id)
        console.log(req.query)
        bike.editbike(req, res)        
    })
    app.all("*", (req,res,next) => {
        res.sendfile(path.resolve("./../TeamClient/dist/index.html"))
    });

}