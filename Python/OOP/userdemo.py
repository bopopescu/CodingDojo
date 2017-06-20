'''
class User(object):
	#the __init__ method is called every time a new object is created
	def __init__(self, name, email):
		#set some instance variables. just like any variable we can call these anything
		self.name = name
		self.email = email
		self.logged = False
	#this is a method we created to help a user login
	def login(self):
		self.logged = True
		print self.name + " is logged in."
		return self

new_user = User("Sushma", "sushma.m812@gmail.com")
print new_user.name
print new_user.email
'''
class User(object):
	def __init__(self, name, email):
		self.name = name
		self.email = email
		self.logged = False
	def login(self):
		self.logged = True
		print self.name + " is logged in"
		return self
	def loggout(self):
		self.logged = False
		print self.name + " is not logged in"
		return self
	def show(self):
		print "My name is {}. You can email me at {}.".format(self.name, self.email)
		return self
	
user1 = User("Sushma", "sushma.m12@gmail.com")
print user1.name
print user1.logged
print user1.email
print user1.login().show().loggout()
