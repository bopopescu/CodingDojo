from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^login$', views.login),
    url(r'^toregister$', views.toregister),
    url(r'^pokes$', views.pokes),
    url(r'^pokesomeone/(?P<id>\d+)$', views.pokesomeone),
    url(r'^logout$', views.logout)
]
