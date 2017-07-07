function Ninja(name){
    this.name = name;
    this.health = 100;
    var speed = 3;
    var strength = 3;

    this.sayName = function(){
        console.log("My ninja name is "+this.name);
    }
    this.showStats = function(){
        console.log("Name: "+this.name+", Health: "+this.health+", Speed: "+speed+", Strength: "+strength)
    }
    this.drinkSake = function(){
        this.health += 10;
        return this;
    }
    this.punch = function(objectthatgetspunched){
        if (objectthatgetspunched instanceof Ninja){
            objectthatgetspunched.health -= 5;
            console.log(objectthatgetspunched.name+ " was punched by " + this.name+ " and lost 5 Health!")
        }
        else{
            return false;
        }
    }

    this.kick = function(objectthatgetskicked){
        if (objectthatgetskicked instanceof Ninja){
            objectthatgetskicked.health -= 5*this.strength;
            console.log(objectthatgetskicked.name+ " was kicked by " + this.name+ " and lost 15 Health!")
        }
        else{
            return false;
        }
    }
}

var ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
// -> "My ninja name is Hayabusa!"

ninja1.showStats();
// -> "Name: Hayabusa, Health: 100, Speed: 3, Strength: 3"

ninja1.drinkSake().drinkSake();
ninja1.showStats();
var blue_ninja = new Ninja("Goemon");
var red_ninja = new Ninja("Bill Gates");

red_ninja.punch(blue_ninja);
blue_ninja.showStats()
red_ninja.showStats()
// -> "Goemon was punched by Bill Gates and lost 5 Health!"

blue_ninja.kick(red_ninja);
// -> "Bill Gates was kicked by Goemon and lost 15 Health!"
