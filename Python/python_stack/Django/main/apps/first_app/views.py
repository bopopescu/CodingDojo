from django.shortcuts import render

# Create your views here.

#the index function is called when root is visited

def index(request):
    print("*"*100)
    return render(request,  "first_app/index.html")
    #response = "Hello, I am your first request!"
    #return HttpResponse(response)