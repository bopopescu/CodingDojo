from __future__ import unicode_literals

from django.db import models

# Create your models here.

class UserManager(models.Manager):
    def checkuser(self, name):
        print name
        if User.objects.filter(name = name).exists():
            user = User.objects.get(name = name)
        else:
            user = User.objects.create(name = name)
        return user

class InterestManager(models.Manager):
    def makeInterest(self, interest):
        if Interest.objects.filter(text = interest).exists():
            thisinterest = Interest.objects.get(text = interest)
        else:
            thisinterest = Interest.objects.create(text = interest)
        return thisinterest

class Interest(models.Model):
    text = models.CharField(max_length = 100)
    created_At = models.DateField(auto_now_add = True)
    objects = InterestManager()

class User(models.Model):
    name = models.CharField(max_length=100)
    interest = models.ManyToManyField(Interest, related_name = "theinterest")
    objects = UserManager()