# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2017-06-20 21:30
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('book', '0003_remove_book_in_print'),
    ]

    operations = [
        migrations.AddField(
            model_name='book',
            name='in_print',
            field=models.BooleanField(default=True),
            preserve_default=False,
        ),
    ]
