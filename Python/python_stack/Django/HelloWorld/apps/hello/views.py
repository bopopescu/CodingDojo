from django.shortcuts import render

# Create your views here.
def index(request):
    print "*"*50
    return render(request, 'hello/index.html')