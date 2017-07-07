from django.shortcuts import render, redirect

# Create your views here.

from django.urls import reverse

from .models import User, Author, Book, BookReview

from django.contrib import messages

from django.db.models import Count

def index(request):
    book = Book.objects.all()
    review = BookReview.objects.all()
    for m in review:
        print m.content
    for i in book:
        print i.title
    return render(request, 'bookreviews/index.html')

def toregister(request):
    if request.method == "POST":
        validate_for_login = User.objects.validateuser(request.POST['name'], request.POST['alias'], request.POST['email'], request.POST['password'], request.POST['passwordconfirmation'])
        if validate_for_login['status']:
            request.session["userId"] = validate_for_login['data'].id
            return redirect('/books')
        else:
            for err in validate_for_login['data']:
                messages.error(request, err)
    return redirect('/')

def login(request):
    if request.method == "POST":
        validate_for_reg = User.objects.validlogin(request.POST['email'], request.POST['password'])
        if validate_for_reg['status']:
            request.session["userId"] = validate_for_reg['data'].id
            return redirect('/books')
        else:
            for err in validate_for_reg['data']:
                messages.error(request, err)

    return redirect('/')

def books(request):
    if 'userId' in request.session:
        userId = request.session['userId']
        user = User.objects.get(id = userId)
        bookreview = BookReview.objects.all().order_by('-created_at')[:3]
        book = Book.objects.all()
        context = {
            "user": user,
            "bookreview": bookreview,
            "book": book
        }
        return render(request, 'bookreviews/books.html', context)
    return redirect('/')

def addbook(request): #books/add
    return render(request, 'bookreviews/viewbook.html')

def toadd(request): #addbooksandreviews
    if request.method == "POST":
        if 'userId' in request.session:
            validatebook = Book.objects.validBook(request.POST['book_title'], request.POST['book_author'], request.POST['book_review'], request.POST['book_rating'])
            if validatebook['bookstatus']:
                request.session['getbook'] = validatebook['bookdata'].id
                user = User.objects.get(id = request.session['userId'])
                thisreview = BookReview.objects.create(content = request.POST['book_review'], rating = request.POST['book_rating'], thisbook = validatebook['bookdata'], thisuser = user)
                thisid = request.session['getbook']
                return redirect(seebook, id = thisid)
            else:
                for err in validatebook['bookdata']:
                    messages.error(request, err)
                return redirect('books/add')
    return redirect('/')

    

def seebook(request, id):
        book = Book.objects.get(id = id)
        user = User.objects.get(id = request.session['userId'])
        request.session['getbook'] = book.id
        bookreviewforthis = BookReview.objects.filter(thisbook = book)
        print "user id", user.id
        for i in bookreviewforthis:
            print i.thisuser.id
        context = {
            "book": book,
            "bookreview": bookreviewforthis,
            "user": user,
        }
        return render(request, 'bookreviews/viewbooks.html', context)


def seeusers(request, id):
    user = User.objects.get(id = id)
    book =  BookReview.objects.filter(thisuser_id = user.id)
    getbook = Book.objects.all()
    getcount = BookReview.objects.filter(thisuser_id = user.id).annotate(countid =Count('thisbook')).count()
    print BookReview.objects.filter(thisuser_id = user.id)
    # bookslist = []
    # for i in getbook:
    #     if BookReview.objects.filter(thisbook_id=i.id).exists():
    #         bookslist.append(BookReview.objects.filter(thisuser_id = user.id).order_by('thisbook'))
    # print bookslist
    dat = BookReview.objects.filter(thisuser = id)
    bookslist = Book.objects.filter(id__in = dat.values('thisbook_id'))
    context = {
        "user": user,
        "count": getcount,
        "book": book,
        "booklist": bookslist
    }
    return render(request, 'bookreviews/users.html', context)

def logout(request):
    if 'userId' in request.session:
        request.session.clear()
    return redirect('/')

def addreview(request):
    if 'getbook' in request.session:
        print request.session['getbook']
        if request.method == "POST":
            book = Book.objects.get(id = request.session['getbook'])
            user = User.objects.get(id = request.session['userId'])
            print book.title
            print user.name
            bookreview = BookReview.objects.create(content = request.POST['book_review'], rating = request.POST['book_rating'], thisbook = book, thisuser = user)
    return redirect(seebook, id = request.session['getbook'])

def delete(request, id):
    bookreviewforthis = BookReview.objects.filter(thisbook_id = id)
    print bookreviewforthis
    print "delete!"
    print bookreviewforthis.delete()
    return redirect(seebook, id = request.session['getbook'])

