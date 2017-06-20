#PART I
class MathDojo(object):
    def __init__(self):
        self.results = 0
    def add(self, *args):
        for i in args:
            self.results += i
        return self
    def subtract(self, *args):
        for j in args:
            self.results -= j
        return self
    def result(self):
        print self.results
        return self.results

md = MathDojo().add(2).add(2, 5).subtract(3, 2).result()

#PART II
class MathDojoII(object):
    def __init__(self):
        self.results = 0
    def add(self, *args):
        print args
        for i in args:
            print i
            if(type(i) == list):
                print i
                for k in i:
                    print k
                    self.results += k
            else:
                self.results += i
        return self
    def subtract(self, *args):
        print args
        for j in args:
            print j
            if(type(j) == list):
                print j
                for m in j:
                    self.results -= m
            else:
                self.results -= j
        return self
    def result(self):
        print self.results
        return self.results

jd = MathDojoII().add([1],3,4).add([3, 5, 7, 8], [2, 4.3, 1.25]).subtract(2, [2,3], [1.1, 2.3]).result()
