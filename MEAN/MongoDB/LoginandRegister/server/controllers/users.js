var mongoose = require('mongoose')
var User = mongoose.model('User')

mongoose.Promise = global.Promise;

module.exports = {
    show: function(req, res){
        User.find({}, function (err, users){
            res.render('main', {users:users});  
        });
    },
    create: function(req, res){
        console.log("whyyyy")
        console.log(req.body)
            console.log("what")
            var user = new User({email: req.body.email, first_name: req.body.first_name, last_name: req.body.last_name, password: req.body.password, birthday: req.body.birthday});
            user.save(function(err) {
                if(err){
                console.log("something went wrong");
                } else {
                res.redirect('/main');
            }
        })

        
        
    }
}   