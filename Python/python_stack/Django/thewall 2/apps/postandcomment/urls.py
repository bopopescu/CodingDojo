from django.conf.urls import url, include # Notice we added include
from django.contrib import admin

from . import views
from django.conf.urls import url, include


urlpatterns = [
    url(r'^$', views.index),
    # url(r'^/login$', views.login),
    # url(r'^/toregister$', views.toregister),
    # url(r'^/wall$', views.getregister),
    # url(r'^/postmessage$', views.postmessage),
    # url(r'^/postcomment$', views.postcomment),
    # url(r'^/logoff$', views.logoff),



]
