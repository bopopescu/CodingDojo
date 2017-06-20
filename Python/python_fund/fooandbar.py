count = 2
for i in range(100, 100001):
	for j in range(1,i):
		if(j*j == i):
			print "Bar"
		elif(i%count == 0):
			count +=1

	'''
	if(i%count == 0): 
		count += 1
		if(type(sqrt(i)) == int):
			print("Bar")
	else:
		print("Foo")
	'''

