from django.shortcuts import render

# Create your views here.
from django.shortcuts import render, HttpResponse, redirect

def index(request):
    context = {
        "email": "sushma.m812@gmail.com",
        "name": "Sushma",

    }
    return render(request, "second_app/index.html", context)

def show(request, id):
    context = {
        "id": id
    }
    return render(request, "second_app/show.html", context)