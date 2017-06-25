from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^login$', views.login),
    url(r'^registerandadd$', views.toregister),
    url(r'^books$', views.books),
    url(r'^books/add$', views.addbook),
    url(r'^addbooksandreviews$', views.toadd),
    url(r'^books/(?P<id>\d+)/$', views.seebook, name = 'my_view_book'),
    url(r'^users/(?P<id>\d+)/$', views.seeusers, name = "my_view_user"),
    url(r'^logout$', views.logout),
    url(r'^addindreview$', views.addreview),
    url(r'^deletereview/(?P<id>\d+)/$', views.delete)
]
