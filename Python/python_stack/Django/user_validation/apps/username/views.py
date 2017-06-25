from django.shortcuts import render, redirect

from django.contrib import messages

# Create your views here.

from .models import Username

thisemail = ""



def index(request):
    context = {
        "users": Username.objects.all()
    }
    return render(request, 'username/index.html',context)

def addusers(request):
    # email = request.POST['email']
    if request.method == "POST":
        res = Username.objects.validUser(request.POST)
        print res
        if res['status']:
            email  = res['data'].email
            messages.success(request, "The username {} is valid!".format(email))
            return redirect('/success')
        else:
            for err in res['data']:
                messages.error(request, err)
            print(res['data'])
            return redirect('/')
    return redirect('/')




def success(request):
    context = {
        "users": Username.objects.all(),
        "email": thisemail
    }
    return render(request, 'username/success.html', context)

def delete(request, id):
    Username.objects.filter(id=id).delete()
    user = Username.objects.filter(id=id)
    return redirect('/success')

