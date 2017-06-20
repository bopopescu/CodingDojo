def compareArray(arr1, arr2):
	print arr1
	print arr2
	if(len(arr1) != len(arr2)):
		print "The lists are not the same"
	else:
		for i in range(0, len(arr1)):
			if(arr1[i] != arr2[i]):
				print "The lists are not the same"
				break
			else:
				if(arr1[len(arr1)-1] == arr2[len(arr1)-1]):
					print "The lists are the same"
					break
			

	
list_one = [1,2,5,6,2]
list_two = [1,2,5,6,2]
compareArray(list_one, list_two)

list_one = [1,2,5,6,5,16]
list_two = [1,2,5,6,5]
compareArray(list_one, list_two)

list_one = ['celery','carrots','bread','milk']
list_two = ['celery','carrots','bread','cream']
compareArray(list_one, list_two)

