var mongoose = require('mongoose')

var Manatee = mongoose.model('Manatee')

module.exports = {
    index: function(req, res){
        //this is for get /
        Manatee.find({}, function(errors, manatees){
            if(errors){
                console.log(errors)
            }
            else{
                res.render('index', {allManatees: manatees})
            }
        })
    },
    getthatmanatee: function(req,res){
        // get /manatees/:id -> show particular manatee
        Manatee.findOne({_id: req.params.id}, function(errors, manatee){
            console.log('errors', errors);
            console.log('that manatee:', manatee)
            res.render('onemanatee', {thismanatee: manatee});
        })

    },
    create: function(req, res){
        //post /manatees -> creating a new manatee
        console.log("POST DATA fffffffffffffffffff", req.body);
        var manatee = new Manatee({name: req.body.name, ocean: req.body.ocean, image: req.body.image, age: req.body.age});
        // Try to save that new user to the database (this is the method that actually inserts into the db) and run a callback function with an error (if any) from the operation.
        manatee.save(function(err) {
        // if there is an error console.log that something went wrong!
            if(err) {
            console.log('something went wrong');
            res.render('index', {title: 'you have errors!', errors: manatee.errors});
            } else { // else console.log that we did well and then redirect to the root route
            console.log('successfully added a quote and name!');
            res.redirect('/');
            }
    })
    },
    edit: function(req, res){
        Manatee.findOne({_id: req.params.id}, function(errors, manatee){
            console.log('errors', errors);
            console.log('that manatee:', manatee)
            res.render('editonemanatee', {thismanatee: manatee});
        })
    },
    update: function(req, res){
        console.log("edit hghghghghg")
        Manatee.findOne({_id: req.params.id}, function(errors, manatee){
            manatee.name = req.body.name;
            manatee.ocean = req.body.ocean;
            manatee.image = req.body.image
            manatee.age = req.body.age
            manatee.save(function(err){
                if(err) {
                    console.log('something went wrong');
                    res.render('editonemanatee', {title: 'you have errors!', errors: manatee.errors,thismanatee: manatee});
                } else { // else console.log that we did well and then redirect to the root route
                    console.log('successfully added a quote and name!');
                    res.redirect('/manatees/' + manatee._id);
                }
            })    
        })
    },
    destroy: function(req, res){
        Manatee.remove({_id: req.params.id}, function(err){
            res.redirect('/');
        })
    }


}