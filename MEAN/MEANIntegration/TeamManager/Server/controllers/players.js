var mongoose = require('mongoose');

var Players = mongoose.model('Player');

module.exports = {
    show: function(req, res){
        console.log("I am in controller of player.js (server) in index")
        Players.find({}, function(err, players){
            if(err){
                console.log(err)
                res.json({error: true, errors: err})
            }
            else{
                console.log("in index!")
                res.json(players)
            }
        })
    },
    create: function(req, res){
        console.log("I am in controller of player.js (server) in create")
        console.log(req.body.playername)
        console.log(req.body.playerpreferredposition)
        var player = new Players({name: req.body.name, preferred_position: req.body.preferred_position})
        player.save(function(err){
			console.log("sending json back to player factory check browser console")				
            if(err){
                res.status(401).json({message: "something went wrong"})
            }
            else{
                console.log("in create!")
                console.log(player)
                res.json(player)
            }
        })
    },
    delete: function(req, res){
        console.log(req.params.id, 'CONTROLLER id??')
        var getdeletedplayer = req.body.thatplayer._id;
        console.log(getdeletedplayer)
        Players.remove({_id: getdeletedplayer}, function(err, message){
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
    updateStatus: function(req, res){
        // console.log("I am in controller of player.js (server) in updateStatus")
        var getplayer = req.params.id;
        // console.log(getplayer)
        // console.log("game from controller", req.body.game)
        // if(req.body.game == "gameone"){
        //     var get = req.body.game
        // }
        // console.log(req.body.newstatus, 'this is from controller')
        // var get = req.body.game;
        // console.log(get, 'CONTROLLER');
        if(req.body.game=="gameone"){
            Players.update({_id: getplayer}, {gameone: req.body.newstatus}, function(err, message){
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
        }
        else if(req.body.game=="gametwo"){
            Players.update({_id: getplayer}, {gametwo: req.body.newstatus}, function(err, message){
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
        }
        else if(req.body.game=="gamethree"){
            Players.update({_id: getplayer}, {gamethree: req.body.newstatus}, function(err, message){
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
        }
          
    }
    

}