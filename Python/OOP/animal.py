class Animal(object):
    def __init__(self, name, health):
        self.name = name
        self.health = health
    def walk(self):
        self.health -= 1
        return self
    def run(self):
        self.health -= 5
        return self
    def displayHealth(self):
        print "Name:", self.name
        print "This is a", self.name
        print "Health:", self.health
        return self

a = Animal("Gato",15).walk().walk().walk().run().run().displayHealth()

class Dog(Animal):
    def __init__(self, name):
        super(Dog, self).__init__(name, 150)
    def pet(self):
        self.health += 5
        return self
    def speak(self):
        print "Woof"
    def displayHealth(self):
        super(Dog, self).displayHealth()
        self.speak()



d = Dog("Nyko").walk().walk().walk().run().run().pet().displayHealth()

class Dragon(Animal):
    def __init__(self, name):
        super(Dragon, self).__init__(name, 170)
    def fly(self):
        self.health -= 10
    def displayHealth(self):
        super(Dragon, self).displayHealth()
        print "I am a Dragon"


dr = Dragon("Drogon").displayHealth()
