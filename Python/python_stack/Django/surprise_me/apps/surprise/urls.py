from django.conf.urls import url, include # Notice we added include
from django.contrib import admin

from . import views


urlpatterns = [
    url(r'^$', views.index),
    url(r'^processing$', views.processing),
    url(r'^results$', views.getsurprise)
]
