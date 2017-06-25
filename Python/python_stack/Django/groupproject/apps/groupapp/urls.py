from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^login$', views.login),
    url(r'^addandregister$', views.addandregister), #all
    url(r'^secrets$', views.secrets),
    url(r'^likesecret', views.likesecret),
    url(r'^deletesecret', views.deletesecret)
    # url(r'^viewinterest/(?P<id>\d+)$', views.interest) #used show
]
