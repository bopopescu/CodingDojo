from django.shortcuts import render, redirect

from .models import Course


# some_id = 0

def index(request):
    context = {
        "courses" : Course.objects.all()
    }
    return render(request, "thiscourse/index.html", context)

def addcourses(request):
    #using ORM
    Course.objects.create(course_name=request.POST['course_name'], description=request.POST['description'])
    return redirect('/')

def deletecoursepage(request, id):
    # global some_id
    # some_id = id
    # course1 = Course.objects.get(id=id)
    context = {
        "course" : Course.objects.get(id=id)
    }
    return render(request, "thiscourse/destroy.html", context)


def deletecourse(request):
    id = request.POST['course_id']
    course = Course.objects.get(id=id)
    print course
    course.delete()
    return redirect('/')