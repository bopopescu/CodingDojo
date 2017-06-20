import random
class Card(object):
    def __init__(self, suit, val):
        self.suit = suit
        self.val = val
    def show(self):
        # if self.value == 1:
        #     sval = "Ace"
        # elif self.value == 11:
        #     val = "Jack"
        # elif self.value == 12:
        #     val = "Queen"
        # elif self.value == 12:
        #     val = "Queen"
        # elif self.value == 13:
        #     val = "King"

        # def __unicode__(self):
        #     return self.show()
        # def __str__(self):
        #     return self.show()
        # def __repr__(self):
        #     return self.show()
        print "{} of {}".format(self.val, self.suit)
        return self
class Deck(object):
    def __init__(self):
        self.cards = []
        self.build()
    def build(self):
        self.cards = [] #want to rebuild this because don't want to call instance again
        suits = ["club", "spade", "heart", "diamond"]
        val = ["a", 2, 3, 4, 5, 6, 7, 8, 9, 10, "j", "q", "k"]
        for suit in suits:
            for value in val:
                myCard = Card(suit, value)
                self.cards.append(myCard)
        #return self

    def shuffleCards(self):
        random.shuffle(self.cards)
        return self
    def show(self):
        for card in self.cards:
            card.show()
        return self

    def resetDeck(self):
        self.build()
        return self

    def draw(self):
        self.shuffleCards()
        self.cards[0].show()
        return self.cards[0]

class Player(object):
    def __init__(self,myDeck, name):
        self.myDeck = myDeck
        self.name= name
        self.handDeals = []

    def draw(self):
        self.handDeals.append(self.myDeck.draw())

    def show(self):
        print "{} is {}".format(self.name, self.handDeals)

    def discard(self):
        return self.hand.pop()
myDeck = Deck()
myPlayer = Player(myDeck, "Bob")
myPlayer.draw()
myPlayer.show()





#     def show(self):
#     def shuffle(self):
#     def reset(self):
#     def draw(self):
#
# class Player(object):
#     def draw(self):
#     def show(self):
#     def discard(self):




#self is the instance you're calling method from -> more like pointer and reference
#deck should have build, show, shuffle index, reset, draw (return top card from the deck) - should give you card back
#player

#Player class: Draw from deck, Show card, and Discard a card
    #Use draw from deck