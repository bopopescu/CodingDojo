from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^addclient$', views.addaclient),
    url(r'^client/add$', views.clientform),
    url(r'^client/(?P<id>\d+)$', views.showclient), #all
    url(r'^(?P<id>\d+)/addproject$', views.projectform),
    url(r'^addingproject/(?P<id>\d+)$', views.addingproject),
    url(r'^show/projects/(?P<id>\d+)', views.showproject),
]
