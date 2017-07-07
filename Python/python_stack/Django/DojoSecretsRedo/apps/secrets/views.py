from django.shortcuts import render, redirect

from django.contrib import messages

from .models import User, Secret

from django.db.models import Count

# Create your views here.

def index(request):
    return render(request,"secrets/index.html")


def login(request):
    if request.method == "POST":
        validations_for_login = User.objects.login(request.POST['emailforlogin'], request.POST['passwordforlogin'])
        if validations_for_login['status']:
            request.session["userId"] = validations_for_login['data'][0].id
            return redirect('/secrets')
        else:
            messages.error(request, "Invalid email or password")
    return redirect('/')

def register(request):
    values_of_validations = User.objects.validreg(request.POST['first_name'],request.POST['last_name'], request.POST['emailforregister'], request.POST['passwordforregister'], request.POST['passwordconfforregister'])
    if values_of_validations['status']:
        request.session["userId"] = values_of_validations['data'].id
        return redirect('/secrets')
    else:
        for err in values_of_validations['data']:
            messages.error(request, err)
    return redirect('/')

def secrets(request):
    if 'userId' in request.session:
        allsecrets = Secret.objects.all()
        thisuserId = request.session['userId']
        context = {
            "allsecrets": allsecrets,
            "thisuserId": thisuserId
        }
        return render(request, 'secrets/home.html', context)

def postsecret(request):
    if request.method == "POST"  and 'userId' in request.session:
        postsecret = Secret.objects.checksecret(request.POST['secret'], request.session['userId'])
        if postsecret['secretstatus']:
            get = postsecret['secretdata']
        else:
            messages.error(request, postsecret['secretdata'][0]) ##so it displays one error at a time
    return redirect('/secrets')


def like(request, id):
    if 'userId' in request.session:
        #id is secret.id
        userId = request.session['userId']
        secretId = id
        if Secret.objects.newLike(secretId, userId):
            return redirect('/secrets')
        else:
            messages.error(request, "Try again!")

def logout(request):
    if 'userId' in request.session:
        request.session.clear()
    return redirect('/')

def popular(request):
    if 'userId' in request.session:
        secret = Secret.objects.annotate(getcount = Count('likes')).order_by('-getcount')
        thisuserId = request.session['userId']
        context = {
            "allsecrets": secret,
            'thisuserId': thisuserId
        }
        return render(request, 'secrets/popular.html', context)

def delete(request, id):
    if 'userId' in request.session:
        delsecret = Secret.objects.get(id = id).delete()
    return redirect('/secrets')

