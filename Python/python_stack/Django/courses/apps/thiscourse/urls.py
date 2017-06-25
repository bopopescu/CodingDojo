from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^addcourses$', views.addcourses),
    url(r'^deletecourse$', views.deletecourse),
    url(r'^courses/destroy(?P<id>\d+)$', views.deletecoursepage)
]