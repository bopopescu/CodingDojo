from django.shortcuts import render

# Create your views here.
from .models import User
def index(request):
    print User.objects.all()
    #a list of objects (or an empty list)
    User.objects.create(first_name="Sushma", last_name="Mangalapally", password="123idk123")
    #created a user object
    print User.objects.all()
    # a list of objects (or an empty list)
    u = User.objects.get(id=1)
    print u.first_name
    u.first_name = "Nikitha"
    u.save()
    j = User.object.get(id=1)
    #gets the user with an id of 1, changes name and saves to DB, then retrieves again...
    print User.objects.get(first_name="Sushma")
    #gets the user with a first_name of "sushma" -> change
    users = User.object.raw("SELECT * from {{appname}}_user")
    #uses raw SQL query to grab all users (equivalent to User.object.all()), which we will iterate through below
    for user in users:
        print user.first_name
    return HttpResponse("ok")