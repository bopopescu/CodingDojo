from django.conf.urls import url, include # Notice we added include
from django.contrib import admin
from . import  views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^users$', views.show),
    url(r'^new_user$', views.create)
]
