from django.shortcuts import render, redirect

from .models import User, Interest
# Create your views here.
def index(request):
    return render(request, 'theinterest/index.html')

def showuser(request):
    context = {
        "allusers": User.objects.all()
    }
    return render(request, 'theinterest/user.html', context)

def adduserinterest(request):
    if request.method == "POST":
        getuser = User.objects.checkuser(request.POST['name'])
        newinterest = Interest.objects.makeInterest(request.POST['interest'])
        getuser.interest.add(newinterest)
        return redirect('/users')
    else:
        return redirect('/')

def showinterest(request, id):
    context = {
        "intanduser": User.objects.get(id=id)
    }

    return render(request, 'theinterest/interest.html', context)