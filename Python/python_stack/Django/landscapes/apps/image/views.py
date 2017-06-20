from django.shortcuts import render, HttpResponse, redirect


# Create your views here.

def index(request):
    return render(request, 'image/index.html')

def image(request, id):
    id = int(id)
    if id in range(1, 10+1):
        thisimage = "snow"
    elif id in range(11,20+1):
        thisimage = "desert"
    elif id in range(21,30+1):
        thisimage = "forest"
    elif id in range(31,40+1):
        thisimage = "vineward"
    elif id in range(41,50+1):
        thisimage = "tropical"
    else:
        return redirect('/')
    context = {
        "id": id,
        "thisimage": thisimage
    }


    return render(request, "image/image.html", context)

