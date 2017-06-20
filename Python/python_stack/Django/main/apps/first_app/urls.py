from django.conf.urls import url # Notice we added include
from . import views

urlpatterns = [
    url(r'^$', views.index)
]
