var mongoose = require('mongoose');

var Users = mongoose.model('UserBike');

module.exports = {
    showusers: function(req, res){
        console.log("I am in controller of users.js (server) in showusers")
        Users.find({}, function(err, users){
            if(err){
                console.log(err)
                res.json({error: true, errors: err})
            }
            else{
                console.log("in showusers!")
                res.json(users)
            }
        })
    },
    createuser: function(req, res){
        console.log("I am in controller of users.js (server) in createuser")
        console.log(req.body.first_name)
        // console.log(req.body.playerpreferredposition)
        var user = new Users({first_name: req.body.first_name, last_name: req.body.last_name, email: req.body.email, password: req.body.password})
        user.save(function(err){
			console.log("sending json back to player factory check browser console")				
            if(err){
                res.status(401).json({message: "something went wrong"})
            }
            else{
                console.log("in create!")
                console.log(user)
                res.json(user)
            }
        })
    },
    finduser: function(req, res){
        console.log("I am in controller of users.js (server) in showusers")
        Users.find({_id: req.body.thatuser._id}, function(err, user){
            if(err){
                console.log(err)
                res.json({error: true, errors: err})
            }
            else{
                console.log("in finduser!")
                res.json(user)
            }
        })        
    }


}