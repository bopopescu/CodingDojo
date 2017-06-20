class Call(object):
    def __init__(self, name, number):
        self.name = name
        self.number = number

    def show(self):
        print self.name, self.number


class CallCenter(object):
    def __init__(self, name, number):
        self.calls = []
        self.name = name
        self.number = number

    def showCalls(self):
        for call in self.calls:
            call.show()
        return self

    def addCall(self, name, number):
        if not isinstance(name, str):
            print "name must be a string"
        elif not isinstance(number, int):
            print "number must be a number"
        else:
            newCall = Call(name, number)
            self.calls.append(newCall)
        return self

    def show(self):
        print self.name, self.number


# center = CallCenter("Super Call Center", 2132342344)
# center.show()
# center.addCall("Bob", 3457777777)
# center.addCall("Tim", "9832344234")
# center.showCalls()


class Animal(object):
    def __init__(self, name, health):
        self.name = name
        self.health = health

    def display(self):
        print "{} has {} health".format(self.name, self.health)


# animal = Animal("Thing", 100)
# animal.display()

class Dog(Animal):
    def __init__(self, name, color):
        super(Dog, self).__init__(name, 150)
        self.color = color

    def speak(self):
        print "Woof im {}".format(self.color)

    def display(self):
        super(Dog, self).display()
        self.speak()


class AnimalHospital(object):
    def __init__(self):
        self.animals = []

    def addAnimals(self, *animals):
        for animal in animals:
            self.animals.append(animal)

    def showAnimals(self):
        for animal in self.animals:
            animal.display()


dog = Dog("Spot", "Brown")
dog1 = Dog("Spots Bro", "Black")
dog2 = Dog("Spots Other Bro", "White")
cat = Dog("Im not a dog", "Orange")

hospital = AnimalHospital()
hospital.addAnimals(dog, dog1, dog2)
hospital.addAnimals(cat)
hospital.showAnimals()

print type(hospital)