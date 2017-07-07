class Deck{
    constructor(){
        this.ranks = ["clubs","spades","hearts","diamonds"];
        this.values = [2, 3, 4, 5, 6, 7, 8, 9, 10, "jack", "queen", "king", "ace"]
        this.deck = []
    }

    createDeck(){
        for(var i = 0; i < this.values.length; i++){
            for(var j = 0; j<this.ranks.length; j++){
                var card = {value: this.values[i], rank: this.ranks[j]}
                this.deck.push(card)
            }
        }
        return this
    }
    shuffle(){
        console.log("shufflin'")
    }
    reset(){
        this.deck = []
        this.createDeck();
    }

    deal(){
        var randomIndex = Math.floor(Math.random(1, this.deck.length+1));
        return this.deck.splice(randomIndex)
    }
}

class Player{
    constructor(name){
        this.name = name;
        this.hand = [];
    }

    takeCard(deck){
        this.hand.push(deck.deal())
    }

    discardCard(rank, value){
        for(var i =0; i <this.hand.length; i++){
            if(this.hand[i].rank == rank && this.hand[i].value == value){
                console.log("car was found!", i)
                return this.hand.splice(i, 1);
            }
        }
        console.log("no card was found!")
    }
}

var thisdeck = new Deck();
console.log(thisdeck.deck)
thisdeck.createDeck().shuffle()
console.log(thisdeck.deck)

var firstPlayer = new Player("Sushma")
console.log(firstPlayer.name)
firstPlayer.takeCard(thisdeck)
console.log(firstPlayer.hand)
console.log(thisdeck.deck)
var hand = firstPlayer.hand;
console.log(firstPlayer.discardCard(hand[0].ranks, hand[0].values))