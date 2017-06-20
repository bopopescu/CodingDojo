def odd_even():
	for i in range(1,2001):
		print "Number is ", i,
		if(i%2 == 0):
			print "This is an even number."
		else:
			print "This is an odd number."

odd_even()

def multiply(arr, num):
	new_arr = []
	for i in range(0, len(arr)):
		#print(arr[i])
		new_arr.append(arr[i]*num)

	#print new_arr
	return new_arr

a = [2,4,10,16]
b = multiply(a, 5)
print b

print "layered_multiples"

def layered_multiples(arr):
	new_array = []
	print arr
	for i in range(0, len(arr)):
		diff_arr = []
		print arr[i]
		count = 0
		while count < arr[i]:
			diff_arr.append(1)
			count += 1
		new_array.append(diff_arr)
	return new_array

x = layered_multiples(multiply([2,4,5],3))
	#layered_multiples([6,12,15])
print x
# output
#[[1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]]