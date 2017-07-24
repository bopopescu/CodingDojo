var mongoose = require('mongoose');
var fs = require('fs');
mongoose.Promise = global.Promise;

var promise = mongoose.connect('mongodb://localhost/playerDB')

promise.then(()=> {
  console.log("SUCCESSFULLY CONNECTED TO DATABASE")
})

// This is a great little function that imports all of our 
// models from the model directory, so if you change
// the folder structure you might have to update models_path
var models_path = __dirname + "/../models"

fs.readdirSync(models_path).forEach(function(file){
	if(file.indexOf('.js') > 0) {
        console.log(file)
		require(models_path + '/' + file);
	}
})