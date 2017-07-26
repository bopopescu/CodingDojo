var mongoose = require('mongoose');

var Bikes = mongoose.model('Bike');
var Users = mongoose.model('UserBike');

module.exports = {
    showbikes: function(req, res){
        console.log("I am in controller of bikes.js (server) in showbikes")
        console.log(req.body.theuser)
        Users.findOne({email: req.body.theuser.email}, function(err, user){
                console.log(user._id)
                Bikes.find({userId: user._id}, function(err, bikes){
                if(err){
                    console.log(err)
                    res.json({error: true, errors: err})
                }
                else{
                    console.log("in showbikes!")
                    console.log(bikes)
                    res.json(bikes)
                }
            })
        })
        
    },
    searchbike: function(req, res){
        console.log("I am in controller of bikes.js (server) in searchbike")
        console.log(req.body.filter_bike)
        if(req.body.filter_bike == ""){
            Bikes.find({}, function(err, allbikes){
        if(err){
            console.log(err)
            res.json({error: true, errors: err})
        }
        else{
            console.log("in allbikes!")
            console.log(allbikes)
            res.json(allbikes)
        }
    
        })
        }
        else{
            Bikes.find({title: req.body.filter_bike}, function(err, allbikes){
            if(err){
                console.log(err)
                res.json({error: true, errors: err})
            }
            else{
                console.log("in allbikes!")
                console.log(allbikes)
                res.json(allbikes)
            }
        
            })
        }
        
    },
    allbikes: function(req, res){
        console.log("I am in controller of bikes.js (server) in allbikes")
        console.log(req.body.theuser)
        Bikes.find({}, function(err, allbikes){
        if(err){
            console.log(err)
            res.json({error: true, errors: err})
        }
        else{
            console.log("in allbikes!")
            console.log(allbikes)
            res.json(allbikes)
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
        console.log("re.body.userId createbike", req.body.userId)
        var bike = new Bikes({title: req.body.title, description: req.body.description, price: req.body.price, location: req.body.location, image: req.body.image, userId: req.body.userId})
        console.log(bike)
        Users.findOne({_id: req.body.userId}, function(err, user){
            console.log("found the user! yatyy", user)
            user.bikeitemstosell.push(bike);
            bike.save(function(err){
            user.save(function(err){
            if(err){
                res.status(401).json({error: "AHHHHH"})
            }
            else{
                Bikes.findOne({_id: bike._id})
                .populate("userId")
                .exec(function(err, bike){
                    res.json({bike: bike})
                })
            }
            
            })
            })
        })
        
    },
    


}