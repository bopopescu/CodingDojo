def find_char(list1, char1):
	new_list = []
	for i in word_list:
		#print i
		#print i.find('o')
		if(i.find('o') != -1):
			new_list.append(i)
	return new_list



word_list = ['hello','world','my','name','is','Anna']
char = 'o'
print find_char(word_list, char)