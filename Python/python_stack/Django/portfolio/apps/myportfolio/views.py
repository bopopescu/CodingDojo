from django.shortcuts import render

# Create your views here.
def index(request):
    print "index"
    return render(request, 'myportfolio/index.html')

def testimonials(request):
    print "test work"
    return render(request, 'myportfolio/testimonials.html')

def projects(request):
    print "projects work"
    return render(request, 'myportfolio/projects.html')

def about(request):
    print "about work"
    return render(request, 'myportfolio/about.html')