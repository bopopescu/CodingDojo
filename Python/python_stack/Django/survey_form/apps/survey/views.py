from django.shortcuts import render, HttpResponse, redirect


# Create your views here.

def index(request):
    return render(request, 'survey/index.html')

def process(request):
    if(request.method == "POST"):
        if 'number' in request.session:
            request.session['number'] += 1
        else:
            request.session['number'] = 0
        request.session['name'] = request.POST['name']
        request.session['location'] = request.POST['location']
        request.session['language'] = request.POST['language']
        request.session['comment'] = request.POST['comment']
        return redirect('/result')
    else:
        return redirect('/')



def getresults(request):
    return render(request, 'survey/result.html')