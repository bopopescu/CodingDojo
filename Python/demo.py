def say_hello(name):
	if name:
		print "Hello, " + name + " from inside the functions"
	else:
		print 'no name!'


print say_hello("Sue")

ninjas = ["Rozen", "KB", "Oliver"]
my_list = ['4', ['list', 'in', 'a', 'list'], 987]
empty_list = []
print ninjas
print my_list

fruits = ['apple', 'banana', 'orange', 'strawberry']
vegetables = ['lettuce', 'cucumber', 'carrots']

fruits_and_vegetables = fruits + vegetables
print fruits_and_vegetables

salad = 3*vegetables
print salad

drawer = ['documents', 'envelopes', 'pens']
print drawer[0]
print drawer[1]
print drawer[2]

x = [1,2,3,4,5]
x.append(99)
print x

x = [99, 4,2,5,-3]
#print x[:]
#print x[1:]
#print x[:4]
print x[2:4]

for count in range(0,5):
	print "looping -", count

my_list = [4, 'lol', 239, ['ddds','fsfs','fsfs'], "dsdddjhrllo"]
for element in my_list:
	print element

count = 0
while count < 5:
	print 'looping = ', count
	count += 1

for val in "string":
	if val == "i":
		break
	print val

for val in "string":
	if val == "i":
		continue
	print val

x=3
y=x
while y > 0:
	print y
	y = y-1
else:
	print "Final else statement"

dog = ("Lora", "Nyko", "Will")
print dog[0]
dog[0] = "Panda"
print dog