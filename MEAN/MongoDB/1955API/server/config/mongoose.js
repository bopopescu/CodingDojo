var mongoose = require('mongoose');
var fs = require('fs')
var path = require('path')

mongoose.connect('mongodb://localhost/names_db');

var models_path = path.join(__dirname, './../models');

fs.readdirSync(models_path).forEach(function(file){
    if(file.indexOf('.js') >= 0){
        console.log(file.indexOf('.js'))
        console.log(file)
        console.log(models_path)
        require(models_path+'/'+file)
    }
})