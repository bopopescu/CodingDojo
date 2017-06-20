class Call(object):
    def __init__(self, id, name, phonenum, time, why):
        self.id = id
        self.name = name
        self.phonenum = phonenum
        self.time = time
        self.why = why
    def display(self):
        print "ID: ", self.id
        print "Name:", self.name
        print "Phone Number", self.phonenum
        print "Time of Call", self.time
        print "Reason for Call", self.why

class CallCenter(object):
    def __init__(self, calls):
        self.calls = calls
        self.queue_size = len(calls)
    def add(self, caller):
        self.calls.append(caller)
        self.queue_size += 1
        return self
    def remove(self):
        self.calls = self.calls[1: len(self.calls)-1]
        self.queue_size -= 1
        return self
    def info(self):
        # print self.calls
        # for i in self.calls:
        #     print i.display()
        for j in range(0, len(self.calls)):
            print "Name:", str(self.calls[j].name)
            print "Phone Number:", str(self.calls[j].phonenum)
        print "Number of Calls Waiting...", self.queue_size




call1 = Call("19384","Sushma","9593847263", "2:10pm", "wants to talk")
call2 = Call("29384","Nikitha","8593847263", "2:30pm", "wants to complain")
call3 = Call("39384","Stephanie","6593847263", "2:40pm", "wants to talk")
call4 = Call("49384","Beth","7593847263", "2:50pm", "wants to talk")

listofcallers = [call1, call2, call3, call4]

call5 = Call("59384","Sue","9593847263", "5:00pm", "wants to say goodbye")

center = CallCenter(listofcallers).add(call5)
center.info()








