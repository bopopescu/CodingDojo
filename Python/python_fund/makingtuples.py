my_dict = {
  "Speros": "(555) 555-5555",
  "Michael": "(999) 999-9999",
  "Jay": "(777) 777-7777"
}


def makingtuples(dicti):
	arr = []
	for key, data in my_dict.items():
		arr.append((key, data))
	print arr

makingtuples(my_dict)