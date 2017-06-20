from django.conf.urls import url
from . import views           # So we can call functions from our routes!
urlpatterns = [
	url(r'^$', views.index),       # 'home' route.
    url(r'^ninjas$', views.result),
    url(r'^ninjas/(?P<ninja_color>\w+)$', views.showninjas)

]