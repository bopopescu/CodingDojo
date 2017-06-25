from django.shortcuts import render, redirect

# Create your views here.

from django.contrib import messages

from .models import User, Secret

def index(request):
    return render(request, 'secrets/index.html')

def adduserinterest(request):
    if request.method == "POST":
        res = User.objects.validationforregister(request.POST)
        print res
        if res['status']:
            first_name = res['data'].first_name
            idforuser = res['data'].id
            print idforuser
            messages.success(request, "Hello, {}".format(first_name))
            return redirect('/secrets/{{idforuser}}')
        else:
            for err in res['data']:
                messages.error(request, err)
            print(res['data'])
            return redirect('/')
    return redirect('/')

def login(request):
    if request.method == "POST":
        res = User.objects.validationforlogin(request.POST)
        print "it's going here", res
        if res['status']:
            idforuser = res['data'].id
            first_name = res['data'].first_name
            messages.success(request, "Hello, {}".format(first_name))
            print idforuser
            return redirect('/secrets/{{idforuser}}')
        else:
            for err in res['data']:
                messages.error(request, err)
                print err
            return redirect('/')
    return redirect('/')


def secrets(request, id):

    return render(request, 'secrets/secrets.html')

def postsecrets(request):
    pass    

