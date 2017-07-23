var mongoose = require('mongoose');
// Importing User model, using mongoose getter method -- look at model page for more info
var Notes = mongoose.model('Note');

module.exports = {
	index: function(req, res){
        console.log('find function users controller /Server/controllers/notes.js');
        console.log("in the index")
		Notes.find({}, function(err, notes){
			if(err){
				console.log(err);
				res.json({error: true, errors: err})
			} else {
                console.log("in index")
				res.json(notes);
			}
		})		
	},
	create: function(req, res){
        console.log('fourth: create function users controller /Server/controllers/notes.js');	
		var note = new Notes({text: req.body.text})	
		console.log(note)
        console.log("in the create")
		note.save(function(err){
			console.log("sending json back to user factory check browser console")				
			if(err){
				// console.log(err);
				res.status(401).json({message: "something went wrong"})
			} else {
                console.log("in create")
				res.json(note);
			}
		})
	},
	show: function(req, res){
		// retrieve single user
        // this is how we retrieve the users id
        console.log("in the show")
        Notes.find({}, function(err, notes){
            console.log("in show")
            res.json(notes)
        })
	}
}

