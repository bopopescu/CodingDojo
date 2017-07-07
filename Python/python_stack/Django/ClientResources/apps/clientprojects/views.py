from django.shortcuts import render, redirect

# Create your views here.

from django.contrib import messages

from .models import Client, Project

def index(request):
    context = {
        "allclients": Client.objects.all()
    }

    return render(request, 'clientprojects/index.html', context)

def addaclient(request):
    get = Client.objects.validateClient(request.POST['business_name'], request.POST['email'], request.POST['phone'], request.POST['notes'])
    if get['status']:
        yay = get['data']
        return redirect(showclient, id = yay.id)
    else:
        for err in get['data']:
            messages.error(request, err)
    return redirect(clientform)

def clientform(request):
    return render(request, 'clientprojects/clientform.html')

def showclient(request, id):
    getclient = Client.objects.get(id = id)
    getspecificproject = Project.objects.filter(thisclient_id = getclient.id)
    context = {
        "getclient": getclient,
        "getspecificproject": getspecificproject
    }
    return render(request, 'clientprojects/showclientinfo.html', context)

def projectform(request, id):
    getclient = Client.objects.get(id = id)
    print getclient.business_name
    context = {
        "getclient": getclient
    }
    return render(request, 'clientprojects/projectform.html', context)

def addingproject(request, id):
    getclient = Client.objects.get(id = id)
    print getclient.business_name
    getproject = Project.objects.validateandmakeProject(request.POST['project_name'], request.POST['notes'], getclient.id)
    if getproject['status']:
        projectsuccess = getproject['data']
        return redirect(showproject, id = projectsuccess.id)
    else:
        for err in getproject['data']:
            messages.error(request, err)
    return redirect(showclient, id = getproject.thisclient.id)


def showproject(request, id):
    getspecificproject = Project.objects.get(id = id)
    context = {
        "getspecificproject": getspecificproject
    }
    return render(request, 'clientprojects/showprojectinfo.html', context)
    

