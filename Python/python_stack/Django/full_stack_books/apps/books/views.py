from django.shortcuts import render, redirect

# Create your views here.

from .models import Book

def index(request):
    context = {
        "books" : Book.objects.all()
    }
    return render(request, "books/index.html", context)

def addbooks(request):
    #using ORM
    Book.objects.create(title=request.POST['title'], category=request.POST['category'], author = request.POST['author'])
    return redirect('/')