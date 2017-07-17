from django.shortcuts import render, HttpResponse


# the index function is called when root is visited
def index(request):
    response = "Hello, I am your first request!"
    return render(request, 'facebook_app/index.html')

def success(request):
    return render(request, 'facebook_app/success.html')
