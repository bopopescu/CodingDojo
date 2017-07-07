from __future__ import unicode_literals

from django.db import models

# Create your models here.

class ClientManager(models.Manager):
    def validateClient(self, business_name, email, phone, notes):
        errors = []
        if len(business_name) < 1:
            errors.append("Add business name!")
        if len(email) < 1:
            errors.append("Add email name!")
        if len(phone) < 1:
            errors.append("Add phone number!")
        if len(notes) < 1:
            errors.append("Add notes!")

        if not errors:
            newclient = Client.objects.create(business_name = business_name, email = email, phone = phone, notes = notes)
            return {"status": True, "data": newclient}
        else:
            return {"status": False, "data": errors}

class ProjectManager(models.Manager):
    def validateandmakeProject(self, project_name, notes, client_id):
        errors = []
        if len(project_name) < 1:
            errors.append("Add project name!")
        if len(notes) < 1:
            errors.append("Add notes!")

        if not errors:
            client = Client.objects.get(id = client_id)
            newproject = Project.objects.create(project_name = project_name, notes = notes, thisclient = client)
            return {"status": True, "data": newproject}
        else:
            return {"status": True, "data": errors}




class Client(models.Model):
    business_name = models.CharField(max_length = 100)
    email = models.CharField(max_length = 100)
    phone = models.CharField(max_length = 100)
    notes = models.TextField()
    created_at = models.DateField(auto_now_add = True)
    objects = ClientManager()

class Project(models.Model):
    project_name = models.CharField(max_length = 100)
    notes = models.TextField()
    thisclient = models.ForeignKey(Client, related_name="clients")
    created_at = models.DateField(auto_now_add = True)
    objects = ProjectManager()
