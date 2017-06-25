from __future__ import unicode_literals

import re

from django.db import models

from django.contrib import messages

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
NAME_REGEX = re.compile(r'^[a-zA-Z]')
ALIAS_REGEX = re.compile(r'^[a-zA-Z0-9]')



# Create your models here.

class UserManager(models.Manager):
    def validateuser(self, name, alias, email, password, confirmpw):
        errors = []
        if len(name) < 1:
            errors.append("Please type in name text!")
        if len(alias) < 1:
            errors.append("Please type in alias text")
        if len(email) < 1:
            errors.append("Please type in email text")
        if len(password) < 1:
            errors.append("Please type in password text")
        if len(confirmpw) < 1:
            errors.append("Please type in confirmation password")
        if not NAME_REGEX.match(name):
            errors.append("Name must be in a good format!")
        
        if not ALIAS_REGEX.match(alias):
            errors.append("Alias may not contain other than letters and numbers!")

        if not EMAIL_REGEX.match(email):
            errors.append("Email must be in a good format!")

        if len(password) < 8:
            errors.append("Password is too short!")
        if password != confirmpw:
            errors.append("Both password and confirm password should be correct!")

        if not errors:
            data = User.objects.create(name = name, alias = alias, email = email, password = password)
            return {"status": True, "data": data}
        else:
            return {"status": False, "data": errors}

    def validlogin(self, emaillog, passlog):
        errors = []
        if len(emaillog) < 1 or len(passlog) < 1 or not EMAIL_REGEX.match(emaillog):
            errors.append("Invalid email or password!")
        
        if not errors:
            user_list = User.objects.filter(email = emaillog)
            if user_list:
                getuser = user_list[0]
                print getuser
                if getuser.password == passlog:
                    user = User.objects.get(email = emaillog, password = passlog)
                    return {"status": True, "data": user}
                else:
                    errors.append("Password is wrong!")
            else:
                errors.append("Invalid email or password!")

        return {"status": False, "data": errors}


class BookManager(models.Manager):
    def validBook(self, title, author, review, rating):
        errors = []
        if len(title) < 1:
            errors.append("Type title name!")
        if len(author) < 1:
            errors.append("Type in author's name!")        
        if len(review) < 1:
            errors.append("Type in review name")
        if len(rating) < 1:
            errors.append("Select ratings!")
        if not errors:
            if Book.objects.filter(title = title, author__name = author).exists():
                bookdata = Book.objects.get(title = title)
                print bookdata.id
                print "what"
            else:
                thisauthor = Author.objects.create(name = author)
                bookdata = Book.objects.create(title = title, author = thisauthor)
            return {"bookstatus": True, "bookdata": bookdata}
        else:
            return {"bookstatus": False, "bookdata": errors}

class User(models.Model):
    name = models.CharField(max_length=100)
    alias = models.CharField(max_length=100)
    email = models.CharField(max_length=100)
    password = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    objects = UserManager()

class Author(models.Model):
    name = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)


class Book(models.Model):
    title = models.CharField(max_length=100)
    author = models.ForeignKey(Author, related_name="books")
    created_at = models.DateTimeField(auto_now_add=True)
    objects = BookManager()


class BookReview(models.Model):
    content = models.TextField()
    rating = models.IntegerField()
    thisbook = models.ForeignKey(Book, related_name="thebook")
    thisuser = models.ForeignKey(User, related_name="bookreviewer")
    created_at = models.DateTimeField(auto_now_add=True)
