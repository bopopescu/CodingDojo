var mongoose = require('mongoose');


// var UserSchema = new mongoose.Schema({
//     first_name: String,
//     last_name: String,
//     email: String,
//     password: String,
//     bikeitemstosell: [{ type: Schema.Types.ObjectId, ref: 'Bike' }]
// }, { timestamps: {} })

// mongoose.model('UserBike', UserSchema);
var UserBike = mongoose.model('UserBike');

var BikeSchema = new mongoose.Schema({
    title: String,
    description: String,
    price: Number,
    location: String,
    image: String,
    seller: [{ type: mongoose.Schema.Types.ObjectId, ref: 'UserBike' }]
}, { timestamps: {} })

mongoose.model('Bike', BikeSchema);





