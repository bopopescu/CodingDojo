from django.shortcuts import render, redirect

# Create your views here.

import re

from django.contrib import messages

from .models import User, Poke

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
FIRSTNAME_REGEX = re.compile(r'^[a-zA-Z]')
LASTNAME_REGEX = re.compile(r'^[a-zA-Z]')


def index(request):
    return render(request, 'loginreg/index.html')

def login(request):
    if request.method == "POST":
        validations_for_login = User.userManager.login(request.POST['emailforlogin'], request.POST['passwordforlogin'])
        if validations_for_login['status']:
            request.session["userId"] = validations_for_login['data'][0].id
            return redirect('/success')
        else:
            messages.error(request, "Invalid email or password")
    return redirect('/')


def toregister(request):
    values_of_validations = User.userManager.register(request.POST['email'], request.POST['first_name'],request.POST['last_name'], request.POST['password'], request.POST['passwordconfirm'])
    if values_of_validations['status']:
        request.session["userId"] = values_of_validations['data'].id
        return redirect('/pokes')
    else:
        for err in values_of_validations['data']:
            messages.error(request, err)
        return redirect('/')

def pokes(request):
    if 'userId' in request.session:
        userId = request.session["userId"]
        user = User.userManager.get(id = userId)
        poking = Poke.objects.newPoke(user)
            
        context = {
            "user": user,
            "poking": poking
        }
        return render(request, 'loginreg/success.html', context)

    return redirect('/')

def pokesomeone(request, id):
    if 'userId' in request.session:
        userId = request.session['userId']
        poking_id = id
        if Poke.objects.getPoke(userId, poking_id):
            return redirect('/pokes')
    return redirect('/')







