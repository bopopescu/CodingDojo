# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2017-06-21 21:26
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('username', '0002_auto_20170621_2122'),
    ]

    operations = [
        migrations.AlterField(
            model_name='username',
            name='created_at',
            field=models.DateTimeField(auto_now=True),
        ),
        migrations.AlterField(
            model_name='username',
            name='updated_at',
            field=models.DateTimeField(auto_now=True),
        ),
    ]
