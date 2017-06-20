import random
random_num = random.randint(60,100)

print random_num

def scoresandgrades(score):
	grade = ""
	print "Score: ", score,
	if(score >= 60 and score <=69):
		grade = "D"
	elif(score >= 70 and score <=79):
		grade = "C"
	elif(score >= 80 and score <=89):
		grade = "B"
	elif(score >= 90 and score <=100):
		grade = "A"
	print "Your grade is ", grade

for i in range(0, 10):
	scoresandgrades(random.randint(60,100))