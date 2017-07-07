class Deck{
    constructor(){
        this.cards = [];
        this.Build()
    }

    Build(){
        let suitArr = ["clubs","spades","hearts","diamonds"];
        let valArr = ["A", 2, 3, 4, 5, 6, 7, 8, 9, 10, "J", "Q", "K"]

        for (let suit in suitArr){
            for(let val in valArr){
                this.cards.push([suitArr[suit], valArr[val]])
            }
        }

    }

    PrintCards(){
        for(let i =0; i < this.cards.length; i++){
            console.log(this.cards[i])
        }
    }

    Shuffle(){
        var i, t;
        var iter = this.cards.length
        while(iter){
            i = Math.floor(Math.random() * iter--);
            t = this.cards[iter]
            this.cards[iter] = this.cards[i]
            this.cards[i] = t
        }
        return this;
    }

    Reset(){
        this.Build();
        return this;
    }

    Deal(){
        this.Shuffle().PrintCards()
        //console.log(this.cards[this.cards.length-1])
        return this.cards.pop();
    }


}

class Player{
    constructor(name, myDeck){
        this.name = name;
        this.myDeck = myDeck;
        this.handDeals = [];
    }

    Draw(){
        let somecard = this.myDeck.Deal()
        console.log(somecard)
        this.handDeals.push(somecard);
        console.log("handDEALS", this.handDeals)
        return this;
    }

    Discard(){
        return this.handDeals.pop();
    }

    Show(){
        
        console.log(this.handDeals)
        return this;

    }
}

let card1 = new Deck();
card1.PrintCards()

myPlayer = new Player("Bob",card1)
myPlayer.Draw()
myPlayer.Draw()
myPlayer.Draw()
myPlayer.Discard()
myPlayer.Show();
//myPlayer.show()
