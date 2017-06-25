
from django.shortcuts import render, HttpResponse, redirect


import re
from .models import User, Message, Comment
import md5
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
FIRSTNAME_REGEX = re.compile(r'^([^0-9]*)$')
LASTNAME_REGEX = re.compile(r'^([^0-9]*)$')
PASSWORD_REGEX = re.compile(r'^[a-zA-Z0-9]')

# Create your views here.

def index(request):
    user = User.objects.all()
    print "printing usersss"
    for i in user:
        print i
    return render(request, 'postandcomment/index.html')

