from __future__ import unicode_literals

from django.db import models

import re

import bcrypt

from django.contrib import messages

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
FIRSTNAME_REGEX = re.compile(r'^[a-zA-Z]')
LASTNAME_REGEX = re.compile(r'^[a-zA-Z]')

# Create your models here.

class UserManager(models.Manager):
    def register(self, email,  first_name, last_name, password, passwordconfirmation, dob):
        errorsforreg = []
        # no_same_email = True
        if len(email) < 1 and not EMAIL_REGEX.match(email):
            errorsforreg.append("Email must not be empty or must be in good format -> asdf@mail.com!")
        
        # try:
        #     checkforsameemail = User.userManager.get(email=email)
        #     errorsforreg.append("Opps! Looks like this email already exists in our database!")
        #     no_same_email = False
        # except:
        #     no_same_email = True

        if len(first_name) < 2 and not FIRSTNAME_REGEX.match(first_name):
            errorsforreg.append("Firstname must not be empty or must only have letters!")
        if len(last_name) < 2 and not LASTNAME_REGEX.match(last_name):
            errorsforreg.append("Last Name must not be empty or must only have letters!")
        if len(password) < 8 and len(passwordconfirmation) < 1:
            errorsforreg.append("Password and password confirmation must not be empty!")
        if password != passwordconfirmation:
            errorsforreg.append("Password and password confirmation must match!")

        if len(dob) < 1:
            errorsforreg.append("Submit your birthday!")

        if not errorsforreg:
            # password = password.encode()
            # hashed = bcrypt.hashpw(password, bcrypt.gensalt())
            user = User.objects.create(first_name = first_name, last_name = last_name, email = email, password = password, birthday = dob)
            print User.objects.all()
            return {"status": True, "data": user}
        else:
            return {"status": False, "data": errorsforreg}

    def login(self, emailforlogin, passwordforlogin):
        errors = []

        if len(emailforlogin) < 1:
            errors.append("Email must not be empty or must have more than 2 characters")
        if not EMAIL_REGEX.match(emailforlogin): # email regex
            errors.append("Email must not be empty or must be in good format -> asdf@mail.com!")
        
        
        if len(passwordforlogin) < 1:
            errors.append("Password must not be empty or must have more than 2 characters!")

        if not errors:
            print User.objects.all()
            for i in User.objects.all():
                print i.email
            user_list = User.objects.filter(email = emailforlogin)
            if user_list:
                getuser = user_list[0]
                print getuser.password
                if getuser.password == passwordforlogin:
                    user = User.objects.filter(email = emailforlogin, password = passwordforlogin)
                    print "yayyy"
                    return {"status": True, "data": user}
                else:
                    errors.append("Password is wrong!")
            else:
                errors.append("Opps! Not in our database! Register! Please!")

        return {"status": False, "data": errors}     

# class PokeManager(models.Manager):
#     def getPoke(self, user_id, poker_id):
#         if User.objects.filter(id = user_id).exists():
#             user = User.objects.get(id = user_id)
#             pokie = User.objects.get(id = poker_id)
#             poke = Poke.objects.create(user_id = user,poker_id  = pokie)

#             # poke.poker_id.add(user[0].id)
#             # print poke.poker_id.all
#             # for i in poke.poker_id.all():
#             #     print i.id
#             return True
#         else:
#             return False


class User(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    email = models.CharField(max_length=200)
    password = models.CharField(max_length=100)
    birthday = models.DateField()
    created_at = models.DateField(auto_now_add=True)
    updated_at = models.DateField(auto_now_add=True)
    objects = UserManager()

class Poke(models.Model):
    user_id = models.ForeignKey(User, related_name="poker") #Poking someone
    poker_id = models.ForeignKey(User, related_name="gettingpoked") #someone is getting poked
    created_at = models.DateField(auto_now_add=True)


