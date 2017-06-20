class Patients(object):
    def __init__(self, id, name, allergies):
        self.id = id
        self.name = name
        self.allergies = allergies
        self.bed_number = None

class Hospital(object):
    def __init__(self, hospital_name, capacity):
        self.patients = []
        self.hospital_name = hospital_name
        self.capacity = capacity
        #self.count = len(self.patients)
    def admit(self, morepatients):
        if(len(self.patients) >= self.capacity):
            print "I'm sorry. Hospital is full"
        else:
            print "Length:", len(self.patients)
            self.patients.append(morepatients)
            morepatients.bed_number = morepatients.id
            print morepatients.bed_number
            print "Admission is completed!"
        return self
    def discharge(self, id):
        for i in range(0, len(self.patients)-1):
            if(self.patients[i].id == id):
                self.patients.remove(self.patients[i])
                self.patients[i].bed_number = 0
        return self
    def display(self):
        for j in range(0, len(self.patients)-1):
            print "ID:", str(self.patients[j].id)
            print "Name:", str(self.patients[j].name)
            print "Allergies:", str(self.patients[j].allergies)
            print "Bed #:", str(self.patients[j].bed_number)
        return self






hosp = Hospital("Kaiser", 4)
hosp.display()

patient1 = Patients("123", "Khalid", "Peanut Butter")
patient2 = Patients("223", "Beth", "Seafood")
patient3 = Patients("323", "Stephanie", "Seafood")
patient4 = Patients("423", "Samantha", "Seafood")
patient6 = Patients("3432", "Shia", "Cheese")
hosp.admit(patient1)
hosp.admit(patient2)
hosp.admit(patient3)
hosp.admit(patient4)
hosp.admit(patient6)

print "List of people"
hosp.display()


hosp.discharge("323")
print "List of people, where we no longer see Stephanie"
hosp.display()

patient7 = Patients("9432", "Blair", "Walnuts")
print "dsds"
hosp.admit(patient7)
hosp.display()
