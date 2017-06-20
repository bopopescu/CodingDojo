class Product(object):
	def __init__(self, price, item_name, weight, brand, cost, status):
		self.price = price
		self.item_name = item_name
		self.weight = weight
		self.brand = brand
		self.cost = cost
		self.status = "for sale"
	def sell(self):
		self.status = "sold"
		return self
	def add_tax(self):
		sales_tax = .15
		self.price = self.price*sales_tax + self.price
		return self
	def returnthis(self):
		if(self.status == "defective"):
			self.status = "defective"
			self.price = 0
		elif(self.status == "new"):
			self.status = "for sale"
			self.price = self.price*.20 + self.price
		return self
	def displayInfo(self):
		print "Price: ", self.price
		print "Item Name:", self.item_name
		print "Weight:", self.weight
		print "Brand:", self.brand
		print "Cost:", self.cost
		print "Status:", self.status
		return self

product1 = Product(30, "Palette", "5lb", "Two Faced", 20, "new")
print product1.sell()
print product1.returnthis()
print product1.displayInfo()
