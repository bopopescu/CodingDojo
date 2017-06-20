def checking(whatever):
	if(type(whatever) == int):
		if whatever >= 100:
			print "That's a big number!"
		elif whatever < 100:
			print "That's a small number"
	elif(isinstance(whatever, str)):
		if(len(whatever) >= 50):
			print "Long sentence"
		else:
			print "Short sentence"
	elif(type(whatever) == list):
		if(len(whatever) >= 10):
			print "Big list!"
		else:
			print "Short list"

'''
Integer
If the integer is greater than or equal to 100, print "That's a big number!" If the integer is less than 100, print "That's a small number"

'''

sI = 45
mI = 100
bI = 455
eI = 0
spI = -23

checking(sI)
checking(mI)
checking(bI)
checking(eI)
checking(spI)

'''
String
If the string is greater than or equal to 50 characters print "Long sentence." If the string is shorter than 50 characters print "Short sentence."
'''

sS = "Rubber baby buggy bumpers"
mS = "Experience is simply the name we give our mistakes"
bS = "Tell me and I forget. Teach me and I remember. Involve me and I learn."
eS = ""
checking(sS)
checking(mS)
checking(bS)
checking(eS)

'''
List
If the length of the list is greater than or equal to 10 print "Big list!" If the list has fewer than 10 values print "Short list."

'''

aL = [1,7,4,21]
mL = [3,5,7,34,3,2,113,65,8,89]
lL = [4,34,22,68,9,13,3,5,7,9,2,12,45,923]
eL = []
spL = ['name','address','phone number','social security number']

checking(aL)
checking(mL)
checking(lL)
checking(eL)
checking(spL)