import random


def coin_tosses():
	head = 0
	tail = 0
	print "Starting the program..."
	for i in range(0,5001):
		random_num = random.random()
		get_num = round(random_num)
		print "Attempt #", i, ": Throwing a coin",
		if( get_num == 0.0):
			print "... It's a head! ...",
			head += 1
		else:
			print "...It's a tail!",
			tail += 1
		print "...Got", head, "head(s) so far and", tail, "tail(s) so far"

coin_tosses()