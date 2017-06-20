class Bike(object):
	"""docstring for Bike"""
	def __init__(self, price, max_speed):
		self.price = price
		self.max_speed = max_speed
		self.miles = 0
	def displayInfo(self):
		print "Price", self.price
		print "Maximum Speed", self.max_speed
		if(self.miles < 0):
			print "You have negative miles!"
			self.miles = 0
		print "Total Miles", self.miles
		return self
	def ride(self):
		print "Riding..."
		self.miles += 10
		return self
	def reverse(self):
		print "Reversing..."
		self.miles -= 5
		return self




bike1 = Bike(200, "25mph")
print bike1.ride().ride().ride().reverse().displayInfo()
bike2 = Bike(500, "35mph")
print bike2.ride().ride().reverse().reverse().displayInfo()
bike3 = Bike(900, "65mph")
print bike3.reverse().reverse().reverse().displayInfo()