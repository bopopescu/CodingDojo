from __future__ import unicode_literals

from django.db import models

import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
NAME_REGEX = re.compile(r'^[a-zA-Z]')

# Create your models here.
class UserManager(models.Manager):
    def validreg(self, first_name, last_name, email, password, passwordconf):
        errors = []
        if len(first_name) < 1:
            errors.append("Type in your first name!")
        if len(last_name) < 1:
            errors.append("Type in your last name!")
        if len(email) < 1:
            errors.append("Type in your email!")
        if len(password) < 1:
            errors.append("Type in your password!")
        
        if len(password) < 8:
            errors.append("Password must be longer than 7 characters!")

        if len(passwordconf) < 1:
            errors.append("Type in your password confirmation!")

        if not NAME_REGEX.match(first_name):
            errors.append("First name must be in a good format!")
        
        if not NAME_REGEX.match(last_name):
            errors.append("Last name must be in a good format!")

        if not EMAIL_REGEX.match(email):
            errors.append("Email must be in a good format!")
        
        if password != passwordconf:
            errors.append("Password and Confirmation Password must be matching!")

        if not errors:
            userdata = User.objects.create(first_name = first_name, last_name = last_name, email = email, password = password)
            return {"status": True, "data": userdata}
        else:
            return {"status": False, "data": errors}

        def login(self, email, password):
            errors = []
            if len(email) < 1:
                errors.append("Type in your email!")
            if len(password) < 1:
                errors.append("Type in your password!")
            if not errors:
                user = User.objects.filter(email = email)
                if user:
                    getuser = user[0]
                    if getuser.password == password:
                        user = User.objects.get(email = email, password = password)
                        return {"status": True, "data": user}
                    else:
                        errors.append("Password is wrong!")
                else:
                    errors.append("Invalid email or password!")
            return {"status": False, "data": errors}


class SecretManager(models.Manager):
    def checksecret(self, content, userId):
        errors = []
        if len(content) < 1:
            errors.append("Please submit a secret!")

        if not errors:
            user = User.objects.get(id = userId)
            secretdata = Secret.objects.create(content = content, creator = user)
            return {"secretstatus": True, "secretdata": secretdata}
        else:
            return {"secretstatus": False, "secretdata": errors}

    def newLike(self, secretId, userId):
        if User.objects.filter(id = userId).exists():
            user = User.objects.filter(id = userId)
            secret = Secret.objects.get(id = secretId)
            secret.likes.add(user[0].id)
            return True
        else:
            return False
        # try:
        #     user = User.objects.get(id = userId)
        #     secret = Secret.objects.get(id = secretId)
        #     secret.likes.add(user)
        #     return True
        # except:
        #     return False
        



class User(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    email = models.CharField(max_length=100)
    password = models.CharField(max_length=100)
    createdAt = models.DateTimeField(auto_now_add=True)
    objects = UserManager()

class Secret(models.Model):
    content = models.TextField()
    creator = models.ForeignKey(User, related_name="thiscreator")
    likes = models.ManyToManyField(User, related_name="secrets_liked") #we are using ManyToMany because many users can like secrets and secrets have many likes
    createdAt = models.DateTimeField(auto_now_add=True)
    objects = SecretManager()

