from django.conf.urls import url, include # Notice we added include
from django.contrib import admin

from . import views
from django.conf.urls import url, include


urlpatterns = [
    url(r'^$', views.index),
    url(r'^(?P<id>\d+)$', views.image)
]
