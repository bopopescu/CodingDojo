
class Car(object):
	"""docstring for Car"""
	def __init__(self, price, speed, fuel, mileage):		
		self.price = price
		self.speed = speed
		self.fuel = fuel
		self.mileage = mileage
		if(self.price > 10000):
			self.tax = .15
		else:
			self.tax = .12
	def diplay_all(self):
		print "Price:", self.price
		print "Speed:", self.speed
		print "Fuel:", self.fuel
		print "Mileage:", self.mileage
		print "Tax:", self.tax
		return self

car1 = Car(2000, "35mph", "Full", "15mpg")
car2 = Car(2000, "5mph", "Not Full", "105mpg")
car3 = Car(2000, "15mph", "Kind of Full", "95mpg")
car4 = Car(2000, "25mph", "Full", "25mpg")
car5 = Car(2000, "45mph", "Empty", "25mpg")
car6 = Car(20000000, "35mph", "Empty", "15mpg")

print car1.diplay_all()
print car2.diplay_all()
print car3.diplay_all()
print car4.diplay_all()
print car5.diplay_all()
print car6.diplay_all()
