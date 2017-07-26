var mongoose = require('mongoose');

var Bikes = mongoose.model('Bike');
var Users = mongoose.model('UserBike');

module.exports = {
    showbikes: function(req, res){
        console.log("I am in controller of bikes.js (server) in showbikes")
        Bikes.find({}, function(err, bikes){
            if(err){
                console.log(err)
                res.json({error: true, errors: err})
            }
            else{
                console.log("in showbikes!")
                res.json(bikes)
            }
        })
    },
    deletebike: function(req, res){
        console.log("I am in controller of bikes.js (server) in deletebike")
        // console.log(req.body.playername)
        // console.log(req.body.playerpreferredposition)
        var getdeletedbike = req.body.deletebike._id;
        console.log(getdeletedbike)
        Bikes.remove({_id: getdeletedbike}, function(err, message){
			console.log("sending json back to player factory check browser console")				
            if(err){
                console.log(err)
                res.json({error: true, errors: err})
            }
            else{
                console.log("in delete!")
                res.json({message: "Yay! You deleted it!"})
            }
        })    
      },
    editbike: function(req, res){
        console.log("I am in controller of users.js (server) in showusers")
        var getthebike = req.body.editbike._id;
        Bikes.update({_id: getthebike}, {title: req.body.title, description: req.body.description, price: req.body.price, location: req.body.location, image: req.body.image}, function(err, message){
                console.log("sending json back to player factory check browser console")				
                if(err){
                    console.log(err)
                    res.json({error: true, errors: err})
                }
                else{
                    console.log("in updateStatus!")
                    res.json({message: "Yay! You changed it!"})
                }
        })      
    },
    createbike: function(req, res){
        var bike = new Bikes({title: req.body.title, description: req.body.description, price: req.body.price, location: req.body.location, image: req.body.image})
        bike.save(function(err){
            console.log("sending json back to player factory check browser console")
            var thatuser = Users.find({_id: theusers})				
            thatuser.bikeitemstosell.push(bike);
            thatuser.save(function(err) {
                if(err){
                    res.status(401).json({message: "something went wrong"})
                }
                else{
                    console.log("in create!")
                    console.log(bike)
                    res.json(bike)
                }            
            });
            
        })
    },
    


}