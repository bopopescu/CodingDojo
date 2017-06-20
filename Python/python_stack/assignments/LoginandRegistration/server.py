from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector

import re

import md5

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
FIRSTNAME_REGEX = re.compile(r'^([^0-9]*)$')
LASTNAME_REGEX = re.compile(r'^([^0-9]*)$')
PASSWORD_REGEX = re.compile(r'^[a-zA-Z0-9]')
app = Flask(__name__)
app.secret_key = 'ThisIsSecretOnes'
mysql = MySQLConnector(app,'email_validation')


@app.route('/')
def index():
    query = "SELECT * FROM users_database"

    users = mysql.query_db(query)
    print len(users)
    print users

    return render_template('index.html', all_users=users) # pass data to our template


@app.route('/login', methods=['POST'])
def login():
    if len(request.form['emailforlogin']) > 1 and len(request.form['passwordforlogin']) > 1:
        print "what"
        print request.form['emailforlogin']
        print request.form['passwordforlogin']
        password = md5.new(request.form['passwordforlogin']).hexdigest()
        query = "SELECT * FROM users_database where email = :email and password = :password"
        data = {
            'email': request.form['emailforlogin'],
            'password': password,
        }

        if not mysql.query_db(query, data):
            print "oh"
            flash("Error!")
            return redirect('/')
        else:
            users = mysql.query_db(query, data)
            print "oky"
            print users
            print users[0]['id']
            id = users[0]['id']
            session['id'] = id
            return redirect('/success')
    else:
        flash("Error!")
        return redirect('/')




@app.route('/toregister', methods=['POST'])
def toregister():
    if (len(request.form['email']) > 1 and EMAIL_REGEX.match(request.form['email'])
    and len(request.form['first_name']) > 2 and FIRSTNAME_REGEX.match(request.form['first_name'])
    and len(request.form['last_name']) > 2 and LASTNAME_REGEX.match(request.form['last_name'])
    and len(request.form['password']) > 8 and len(request.form['passwordconfirm']) > 1
    and PASSWORD_REGEX.match(request.form['password'])
    and request.form['password'] == request.form['passwordconfirm']):
        print("why")
        password = md5.new(request.form['password']).hexdigest();
        query = "insert into users_database (first_name, last_name, email, password, created_at, updated_at) values (:first_name, :last_name, :email, :password, now(), now());"
        data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'email': request.form['email'],
            'password': password
        }
        mysql.query_db(query, data)
        return redirect('/success')
    else:
        flash("Error!")
        return redirect('/')


@app.route('/success')
def getregister():
    if 'id' in session:
        flash("Yay, you're logged in!")

    return render_template('success.html')

app.run(debug=True)