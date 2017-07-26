var mongoose = require('mongoose');

var UserSchema = new mongoose.Schema({
    first_name: String,
    last_name: String,
    email: String,
    password: String,
    bikeitemstosell: [{ type: Schema.Types.ObjectId, ref: 'Bike' }]
}, { timestamps: {} })

mongoose.model('UserBike', UserSchema);

