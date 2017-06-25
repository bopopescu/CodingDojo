from __future__ import unicode_literals

import re

from django.db import models

from django.contrib import messages

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
FIRSTNAME_REGEX = re.compile(r'^[a-zA-Z]')
LASTNAME_REGEX = re.compile(r'^[a-zA-Z]')

idofuser = -1


# Create your models here.
class UserManager(models.Manager):
    def validationforregister(self, post):
        first_name = post['first_name']
        last_name = post['last_name']
        email = post['emailforregister']
        password = post['passwordforregister']
        passwordconf = post['passwordconfforregister']
        errors = []

        if len(first_name) < 1:
            errors.append("First Name must not be empty!")
        if not FIRSTNAME_REGEX.match(first_name):
            errors.append("First Name should be in a correct format!")
        if len(last_name) < 1:
            errors.append("Last Name must not be empty!")
        if not LASTNAME_REGEX.match(last_name):
            errors.append("Last Name should be in a correct format!")
        if len(email) < 1:
            errors.append("Email must not be empty!")
        if not EMAIL_REGEX.match(email):
            errors.append("Email should be in a correct format!")

        if len(password) < 1:
            errors.append("Password must not be empty!")
        if len(passwordconf) < 1:
            errors.append("Password confirmation must not be empty!")

        if password != passwordconf:
            errors.append("Password should be same as Password Confirmation")

        exists = User.objects.filter(email = email).exists()
        if exists:
            errors.append("Already exists! Log in!")

        if not errors:
            user = User.objects.create(first_name = first_name, last_name = last_name, email = email, password = password)
            global idforuser
            idforuser = 
            return {"status": True, "data": user}
        else:
            return {"status": False, "data": errors}

    def validationforlogin(self, post):
        emailforlogin = post['emailforlogin']
        passwordforlogin = post['passwordforlogin']
        errorsforlogin = []
        successforemail = True
        successforpassword = True

        if len(emailforlogin) < 1:
            errorsforlogin.append("Type your email please!")
        if len(passwordforlogin) < 1:
            errorsforlogin.append("Type your password please!")

        if not errorsforlogin:
            try:
                user = User.objects.get(email = emailforloginforlogin)
                if user.password != passwordforlogin:
                    errorsforlogin.append("Wrong password!")
                else:
                    return {"status": True, "data": user}
            except:
                errorsforlogin.append("Not in database! Please register!")
                return {"status": False, "data": errorsforlogin}
        return {"status": False, "data": errorsforlogin}




class SecretManager(models.Manager):
    def validationforsecret(self, post):
        secret = post['secret']
        errors = []
        if len(secret) < 1:
            errors.append("You must type your secret!")
        if not errors:
            secret = Secret.objects.create(postsecret = secret, )
            return {"status": True, "data": secret}
        else:
            return {"status": False, "data": errors}








class User(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    email = models.CharField(max_length=100)
    password = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    objects = UserManager()

class Secret(models.Model):
    postsecret = models.TextField()
    User = models.ForeignKey(User, related_name="secretowner")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = SecretManager()
    

