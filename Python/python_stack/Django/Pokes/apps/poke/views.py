from django.shortcuts import render, redirect

# Create your views here.

import re

from django.db.models import Count

from django.contrib import messages

from .models import User, Poke

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
FIRSTNAME_REGEX = re.compile(r'^[a-zA-Z]')
LASTNAME_REGEX = re.compile(r'^[a-zA-Z]')


def index(request):
    for i in User.objects.all():
        print i.first_name
    return render(request, 'poke/index.html')

def login(request):
    if request.method == "POST":
        validations_for_login = User.objects.login(request.POST['emailforlogin'], request.POST['passwordforlogin'])
        if validations_for_login['status']:
            request.session["userId"] = validations_for_login['data'][0].id
            return redirect('/pokes')
        else:
            messages.error(request, "Invalid email or password")
    print User.objects.all()
    return redirect('/')


def toregister(request):
    values_of_validations = User.objects.register(request.POST['email'], request.POST['first_name'],request.POST['last_name'], request.POST['password'], request.POST['passwordconfirm'], request.POST['bday'])
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
        user = User.objects.get(id = userId)
        print user.gettingpoked.all().values("user_id__first_name").annotate(Count('user_id__first_name')).order_by("id")
        print User.objects.get(id = 5).first_name
        poking = Poke.objects.all()
        for i in poking:
            print i.user_id.first_name
        userofpoker = Poke.objects.filter(poker_id__id = userId)
        print userofpoker.query
        # getuserofpoke = Poke.objects.filter(user_id__id = userId).order_by('created_at')
        print userofpoker, "Dsd"
        for i in userofpoker:
            print i.user_id.first_name, "pop"
        allusers = User.objects.all()
        yes = Poke.objects.filter(poker_id__id = userId)
        # if yes[0].user_id.id == 7:
        #     print yes.filter(user_id__id = "7").annotate(Count('user_id')).count()

        print "dsd"
        print yes.annotate(Count('user_id')).count()
        for i in yes:
            print i.user_id.first_name
        print "jk"
        print user.gettingpoked.all()
        for i in user.gettingpoked.all():
            print i.user_id.first_name
        print user.gettingpoked.all().values("poker_id__id")

        usersofpoke = user.gettingpoked.all()
        print usersofpoke.count()

        pokingtheusers =  user.poker.all()
        for i in user.poker.all():
            print i.poker_id.first_name  

        

        
        

            
        context = {
            "user": user,
            "poking": poking,
            "allusers": allusers,
            "userofpoker": userofpoker,
            "yes": yes,
            "usersofpoke": usersofpoke,
            "pokingtheusers": pokingtheusers
        }
        return render(request, 'poke/success.html', context)

    return redirect('/')

def pokesomeone(request, id):
    if 'userId' in request.session:
        userId = request.session['userId']
        user = User.objects.get(id = userId)
        poking_id = id
        pokie = User.objects.get(id = poking_id)
        poke = Poke.objects.create(user_id = user, poker_id  = pokie)
        return redirect('/pokes')
    return redirect('/')

            

def logout(request):
    if 'userId' in request.session:
        request.session.clear()
    return redirect('/')




