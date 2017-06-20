from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector

import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = 'ThisIsSecretOnes'
mysql = MySQLConnector(app,'email_validation')
@app.route('/')
def index():
    query = "SELECT * FROM email_list"
    emaillist = mysql.query_db(query)
    print len(emaillist)

    return render_template('index.html', all_email_list=emaillist) # pass data to our template



@app.route('/email_address', methods=['POST'])
def create():
    if len(request.form['email_address']) < 1:
        flash("Email cannot be empty!")
        return redirect('/')
    elif not EMAIL_REGEX.match(request.form['email_address']):
        flash("Email is not valid!")
        return redirect('/')
    else:
        flash("Success!")
        query = "insert into email_list (email_address, created_at) values (:email_address, now());"
        data = {
            'email_address': request.form['email_address']
        }
        mysql.query_db(query, data)
        return redirect('/success')

    return redirect('/success')

@app.route('/success')
def success():
    query = "SELECT * FROM email_list"                           # define your query
    email_list = mysql.query_db(query)                           # run query with query_db()
    thisistheemail =  email_list[len(email_list) - 1]['email_address']
    return render_template('success.html', all_email_list=email_list, one_email=thisistheemail) # pass data to our template





app.run(debug=True)