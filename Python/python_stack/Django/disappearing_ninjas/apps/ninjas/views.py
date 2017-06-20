from django.shortcuts import render

# Create your views here.
from django.shortcuts import render, HttpResponse, redirect

def index(request):
    return render(request, "ninjas/index.html")

def result(request):
    return render(request, 'ninjas/ninjas.html')

def showninjas(request, ninja_color):
    print ninja_color
    colors = {
        "blue": "leonardo",
        "orange": "michelangelo",
        "red": "raphael",
        "purple": "donatello"
    }
    if ninja_color in colors:
        color_image = colors[ninja_color]
    else:
        color_image = "notapril"

    context = {
        "ninja_color": color_image
    }
    # if(ninja_color == "blue"):
    #     ninja_color = "images/leonardo.jpg"
    # elif(ninja_color == "orange"):
    #     ninja_color = "images/michelangelo.jpg"
    # elif(ninja_color == "red"):
    #     ninja_color = "images/raphael.jpg"
    # elif(ninja_color == "purple"):
    #     ninja_color = "images/donatello.jpg"
    # else:
    #     ninja_color = "images/notapril.jpg"
    # context = {
    #     "ninja_color": ninja_color
    # }

    print ninja_color
    return render(request, 'ninjas/different_ninjas.html', context)