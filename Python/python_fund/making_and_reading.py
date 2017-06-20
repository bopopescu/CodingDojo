
questions = {"name": "Sushma", "age":21, "location": "San Jose", "language": "JavaScript"}

def making(dicti):
	for key, data in dicti.iteritems():
		print "My", key, "is", data

making(questions)