class Vehicle(object):
    def __init__(self, wheels, capacity, make, model):
        self.wheels = wheels
        self.capacity = capacity
        self.make = make
        self.model = model
        self.mileage = 0
    def drive(self, mileage):
        self.mileage += mileage
        return self
    def reverse(self, mileage):
        self.mileage -= mileage
        return self
class Bike(Vehicle):
    def vehicle_type(self):
        return "Bike"
class Car(Vehicle):
    def set_wheels(self):
        self.wheels = 4
        return self
class Airplane(Vehicle):
    def fly(self, miles):
        self.mileage += miles
        return self
v = Vehicle(4,8, "dodge", "minivan").drive(100)
print v.make
b = Bike(2,1, "Schwinn", "Paramount")
print b.vehicle_type()
c = Car(8,5, "Jetta", "sedan")
c.set_wheels()
print c.wheels
a = Airplane(22,853, "Airbus", "A380")
a.fly(580)
print a.mileage

def varargs(arg1, *args):
  print "Got "+arg1+" and "+ ", ".join(args)
varargs("one") # output: "Got one and "
varargs("one", "two") # output: "Got one and two"
varargs("one", "two", "three") # output: "Got one and two, three"
