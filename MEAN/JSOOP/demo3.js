class Dot {
    constructor(x, y){
        this.x = x;
        this.y = y;
        console.log("You created a Dot!");
    }
}
let dot = new Dot(10, 10);

// Old ES5 way
// var Dot2 = function Dot2(x, y){
//     this.x = x;
//     this.y = y;
// }
// Dot2.prototype.showLocation(){
//     console.log("This Dot is at x " + this.x + " and y " + this.y);
// }
// var dot1 = new Dot2(55, 20);
// dot1.showLocation();



// New ES6 way
class Dot1 {
    constructor(x, y){
        this.x = x;
        this.y = y;
    }
    showLocation(){
        // ES6 String Interpolation!
        console.log(`This Dot is at x ${this.x} and y ${this.y}`);
    }
    static getHelp(){
        console.log("This is a Dot class, for created Dots! A Dot takes x and y coordinates, type 'new Dot' to create one!");
    }
}
let dot2 = new Dot1(5, 13);
dot2.showLocation();

let dot3 = new Dot1(4, 2);

console.log(dot3.showLocation);
dot3.showLocation();
// but we can't see getHelp
//console.log(getHelp);
// however we can call getHelp this way:
Dot1.getHelp()


