from django.shortcuts import render, HttpResponse, redirect
from .models import User
def index(request):
    print("Running index method, calling out to User.")
    getuser = User.objects.login("sushma@scu.edu","Sushma")
# DO NOT PASS THE WHOLE REQUEST OBJECT TO THE MODEL!!!
    print (type(getuser))
    if 'error' in getuser:
        pass
    if 'theuser' in getuser:
        pass
    return HttpResponse("Done running userManager method. Check your terminal console.")
