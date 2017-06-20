print "x   1  2  3  4  5  6  7  8   9  10  11  12"

def multiplcation_table(num):
	for i in range(1, num+1):
		#print str(i) + " "
		for j in range(1,num+1):
			print str(i*j)+" ",
			if(j == num):
				print "\n"

multiplcation_table(12)