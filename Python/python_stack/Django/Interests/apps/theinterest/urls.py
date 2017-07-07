from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^adduserinterest$', views.adduserinterest),
    url(r'^users$', views.showuser),
    url(r'^show/(?P<id>\d+)$', views.showinterest)
]