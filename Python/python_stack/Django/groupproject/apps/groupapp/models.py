from __future__ import unicode_literals

from django.db import models

# Create your models here.


class UserManager(models.Manager):
    def makeUser(self, post):
        name = post['name']

        try:
            user = User.objects.get(name = name)
        except:
            user = User.objects.create(name=name)
        return user

class InterestManager(models.Manager):
    def makeInterest(self, post):
        interest = post['interest']

        try:
            thisinterest = Interest.objects.get(interest = interest)
        except:
            thisinterest = Interest.objects.create(interest=interest)
        return thisinterest

class Interest(models.Model):
    interest = models.CharField(max_length=100) #name
    objects = InterestManager()


class User(models.Model):
    name = models.CharField(max_length=100)
    interest = models.ManyToManyField(Interest, related_name="interests") #likeBy
    created_at = models.DateTimeField(auto_now_add=True)
    objects = UserManager()
