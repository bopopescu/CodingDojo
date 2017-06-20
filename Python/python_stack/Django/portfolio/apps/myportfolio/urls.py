from django.conf.urls import url, include # Notice we added include
from django.contrib import admin
from . import views

urlpatterns = [
    url(r'^$', views.index),     # This line has changed!
    url(r'^testimonials$', views.testimonials),
    url(r'^about$', views.about),
    url(r'^projects$', views.projects)
]
