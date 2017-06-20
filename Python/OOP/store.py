class Store(object):
	"""docstring for Store"""
	def __init__(self, products, location, owner):
		self.products = products
		self.location = location
		self.owner = owner
	def add_product(self, new_product):
		self.products.append(new_product)
		print self.products
		return self.products
	def remove_products(self, product):
		for i in range(0, len(self.products)-1):
			if(self.products[i] == product):
				self.products.pop(i)
		return self.products
	def inventory(self):
		print "Products", self.products
		for i in self.products:
			print "Product:", i
		return self

store1 = Store(["balloon", "cat", "hay", "horse"], "San Jose", "Sushma")
print store1.add_product("dog")
print store1.inventory()
print store1.remove_products("cat")
print store1.location

		