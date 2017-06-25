from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^addinterestandname$', views.adduserinterest),
    url(r'^login$', views.login),
    url(r'^secrets/(?P<id>\d+)$', views.secrets), #all
    url(r'^postsecrets$', views.postsecrets) #used show
]
