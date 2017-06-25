from django.shortcuts import render

from django.contrib import messages

from .models import User, Secret

# Create your views here.

def index(request):
    return render(request,"secrets/index.html")

def adduserinterest(request):
    pass

def secrets(request, id):
    pass

def postsecrets(request):
    pass     

def login(request):
    pass    