from django.shortcuts import render, redirect

# Create your views here.

from .models import User, Interest

def index(request):
    return render(request, 'groupapp/index.html')

def adduserinterest(request):
    if request.method == "POST":
        user = User.objects.makeUser(request.POST)
        newinterest = Interest.objects.makeInterest(request.POST)
        user.interest.add(newinterest)
        return redirect('/show')
    #     getuser = User.objects.filter(name = name).exists()
    #     if not getuser:
    #         user = User.objects.create(name = name)
    #         print user.name
    #     getinterest = Interest.objects.filter(interest = interest).exists()
    #     if not getinterest:
    #         interest = Interest.objects.create(interest = interest)
    #         print interest.interest
    #
    #     thisinterest = Interest.objects.get(interest = request.POST["interest"])
    #     print thisinterest.interest
    #     thisuser = User.objects.get(name = request.POST["name"])
    #     thisuser.interest.add(thisinterest)
    #     print User.objects.all()
    #     return redirect('/show')
    # else:
    #     return redirect('/')

def show(request):
    context = {
        "users": User.objects.all()
    }
    return render(request, 'groupapp/users.html', context)

def interest(request, id):
    context = {
        "intanduser": User.objects.get(id=id)
    }

    return render(request, 'groupapp/interest.html', context)

