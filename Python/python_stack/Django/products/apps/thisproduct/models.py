from __future__ import unicode_literals

from django.db import models

# Create your models here.
from django.db import models
class Product(models.Model):
    name = models.CharField(max_length=50)
    description = models.TextField(max_length=1000)
    weight = models.IntegerField()
    price = models.IntegerField()
    cost_to_seller = models.IntegerField()
    category = models.CharField(max_length=50)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
