class Ninja {
    constructor(name){
        this.name = name;
        this.health = 100;
        this.speed = 3;
        this.strength = 3;
    }

    sayName(){
        console.log(`My ninja name is ${this.name}`);
    }

    showStats(){
        console.log(`Name: ${this.name} Health: ${this.health}, Speed: ${this.speed}, Strength: ${this.strength}`)
    }

    drinkSake(){
        this.health += 10;
        return this;
    }
}

let ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
// -> "My ninja name is Hayabusa!"

ninja1.showStats();
// -> "Name: Hayabusa, Health: 100, Speed: 3, Strength: 3"

ninja1.drinkSake().drinkSake();
ninja1.showStats();

class Sensei extends Ninja {
    constructor(name){
        super(name);
        this.health = 200;
        this.speed = 10;
        this.strength = 10;
        this.wisdom = 100;
    }
    speakWisdom(){
        super.drinkSake();
        console.log(`What one programmer can do in one month, two programmers can do in two months`)
    }
}

let super_sensei = new Sensei("Master Splinter");
super_sensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
super_sensei.showStats();
// -> "Name: Master Splinter, Health: 210, Speed: 10, Strength: 10"


