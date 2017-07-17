var mongoose = require('mongoose')

var Name = mongoose.model('Name')

module.exports = {
    index: function(req, res){
        var names = Name.find({}, function(err, data){
            if(err){
                res.json(err);
                return;
            }
            res.json(data)
        });
    },
    create: function(req,res){
        var name = new Name({name: req.params.name})
        name.save(function(err, aName){
            if(err){
                res.json(err)
                return;
            }
            res.json(aName)
        })
    },
    remove: function(req, res){
        Name.remove({name: req.params.name}, function(err){
            res.redirect('/');
        })
    },
    find: function(req, res){
        Name.findOne({name: req.params.name}, function(err, data){
            if(err){
                res.json(err)
                return;
            }
            res.json(data)
        })
    }



}