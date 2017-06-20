'''
Part I
Create a function called draw_stars() that takes a list of numbers and prints out *.

'''
def draw_stars(arr):
	for i in arr:
		for j in range(0,i):
			print "*",
		print "\n"

x = [4, 6, 1, 3, 5, 7, 25]
#draw_stars(x)

'''
Part II
Modify the function above. 
Allow a list containing integers and strings to be passed to the draw_stars() function. 
When a string is passed, instead of displaying *, display the first letter of the string according 
to the example below. You may use the .lower() string method for this part.
'''

def draw_stars_modified(arr):
	for i in arr:
		if(type(i) == str):
			#print i 
			#print i[0].lower()
			#print len(i)
			for k in range(0,len(i)):
				print i[0].lower(),
		else:
			for j in range(0,i):
				print "*",
		print "\n"

x = [4, "Tom", 1, "Michael", 5, 7, "Jimmy Smith"]
draw_stars_modified(x)