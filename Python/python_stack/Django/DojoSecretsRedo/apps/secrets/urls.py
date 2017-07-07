from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^register$', views.register),
    url(r'^login$', views.login),
    url(r'^secrets$', views.secrets), #all #(?P<id>\d+)$
    url(r'^like/(?P<id>\d+)$', views.like),
    url(r'^postsecret$', views.postsecret), #used show
    url(r'^logout$', views.logout),
    url(r'^popular$', views.popular),
    url(r'^delete/(?P<id>\d+)$', views.delete)
]
