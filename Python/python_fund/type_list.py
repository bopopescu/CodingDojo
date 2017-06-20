def checktypelist(arr):
	sum1 = 0
	boolsum = False
	boolstr = False
	string = ""
	for i in arr:
		print type(i)
		if(type(i) == int or type(i) == float):
			sum1 += i
			boolsum = True
		elif(isinstance(i, str)):
			string = string + " " + i
			boolatr = True
	if(boolsum == True and boolstr == True):
		print "The array you entered is of mixed type"
		print "Sum: ", sum1
		print "String: ", string
	elif(boolsum == True and boolstr == False):
		print "The array you entered is of integer type"
		print "Sum: ", sum1
	elif(boolsum == False and boolstr == True):
		print "The array you entered is of string type"
		print "String: ", string

l = ['magical unicorns',19,'hello',98.98,-20,'world']
checktypelist(l)
l = [2,3,1,7,4,12]
checktypelist(l)
l = ['magical','unicorns']
checktypelist(l)


