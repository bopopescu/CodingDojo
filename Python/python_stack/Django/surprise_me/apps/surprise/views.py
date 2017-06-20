from django.shortcuts import render

# Create your views here.
from django.shortcuts import render

# Create your views here.
from django.shortcuts import render, HttpResponse, redirect

import random

some_number = 0
VALUES = ["Item One", "Item Two", "Item Three", "Item Four", "Item Five",
                      "Item Six", "Item Seven", "Item Eight", "Item Nine",
                      "Item Ten", "Item Eleven", "Item Twelve", "Item Thirteen",
                      "Item Fourteen", "Item Fifteen", "Item Sixteen"]

def index(request):
    return render(request, "surprise/index.html")

def processing(request):
    if(request.method == "POST"):
        print request.POST['number']
        global some_number
        some_number = request.POST['number']

    return redirect('/results', some_number)


def getsurprise(request):

    print "some numberrrr"
    print some_number
    if some_number < 0 and some_number > 17:
        return redirect('/')
    else:
        random.shuffle(VALUES)
        get = VALUES[0:int(some_number)]
        context = {
            "some_number": some_number,
            "list_of_number": VALUES,
            "get": get
        }
        print VALUES
        print "values and somenumber"

        print get
        return render(request, 'surprise/results.html', context)