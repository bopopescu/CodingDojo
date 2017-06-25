from __future__ import unicode_literals

from django.db import models

# Create your models here.

class UserManager(models.Manager):
    def validUser(self, post):
        email = post["email"]
        errors = []

        if len(email) < 1:
            errors.append("Too short!")

        if len(email) > 15:
            errors.append("Too long!")

        exists = Username.objects.filter(email = email).exists()
        if exists:
            errors.append("Already exists!")

        if not errors:
            user = Username.objects.create(email = email)
            return {"status": True, "data": user}
        else:
            return {"status": False, "data": errors}


class Username(models.Model):
    email = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now_add=True)

    objects = UserManager()
