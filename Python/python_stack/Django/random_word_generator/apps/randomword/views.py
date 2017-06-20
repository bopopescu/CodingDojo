from django.shortcuts import render, redirect
import random, string


# Create your views here.
def index(request):

    return render(request, 'randomword/index.html')

def getrandomword():
    return ''.join(random.choice(string.lowercase) for i in range(12))

def countpages(request):
    request.session['number'] = 0

def randomword(request):

    if(request.method == "POST"):
        if 'number' in request.session:
            request.session['number'] += 1
        else:
            countpages(request)
        request.session['wordrandom'] = getrandomword()
        return redirect('/')
    else:
        return redirect('/')

