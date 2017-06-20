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
mysql = MySQLConnector(app,'thewall')


@app.route('/')
def index():
    query = "SELECT * FROM users"

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
        query = "SELECT * FROM users where email = :email and password = :password"
        data = {
            'email': request.form['emailforlogin'],
            'password': password,
        }

        if not mysql.query_db(query, data):
            print "oh"
            flash("Error!")
            return redirect('/')
        else:
            theseusers = mysql.query_db(query, data)
            print "oky"
            print theseusers
            print theseusers[0]['id']
            id = theseusers[0]['id']
            session['id'] = id
            return redirect('/wall')
    else:
        flash("Error!")
        return redirect('/')

@app.route('/toregister', methods=['POST'])
def toregister():
    session.clear()
    if (len(request.form['email']) > 1 and EMAIL_REGEX.match(request.form['email'])
    and len(request.form['first_name']) > 2 and FIRSTNAME_REGEX.match(request.form['first_name'])
    and len(request.form['last_name']) > 2 and LASTNAME_REGEX.match(request.form['last_name'])
    and len(request.form['password']) > 8 and len(request.form['passwordconfirm']) > 1
    and PASSWORD_REGEX.match(request.form['password'])
    and request.form['password'] == request.form['passwordconfirm']):
        print("why")
        password = md5.new(request.form['password']).hexdigest();
        query = "insert into users (first_name, last_name, email, password, created_at, updated_at) values (:first_name, :last_name, :email, :password, now(), now());"
        data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'email': request.form['email'],
            'password': password
        }
        mysql.query_db(query, data)
        return redirect('/wall')
    else:
        flash("Error!")
        return redirect('/')





@app.route('/wall')
def getregister():
    if 'id' in session:
        query = "SELECT * FROM users where id = :id"
        data = { 'id': session['id']}
        users = mysql.query_db(query,data)
        # print "firstname", users[0]['first_name']
        flash("Yay, you're logged in!")
        userquery = "SELECT * FROM users"
        userqueryinfo = mysql.query_db(userquery)
        # print "usersss"
        thisquery1 = "SELECT * FROM messages"
        allmessages = mysql.query_db(thisquery1)
        thiscomment = "SELECT * FROM comments"
        allcomments = mysql.query_db(thiscomment)
        first_name_comments = "";
        first_name_message = "";
        for userinquery in userqueryinfo:
            # print userinquery
            # print userinquery['first_name']
            for comment in allcomments:
                if userinquery['id'] == comment['users_id']:
                    first_name_comments = userinquery['first_name'];
                    print first_name_comments
                    last_name_comments = userinquery['last_name'];
                    pass;
        for userinthisquery in userqueryinfo:
            for message in allmessages:
                if userinthisquery['id'] == message['users_id']:
                    first_name_message = userinthisquery['first_name']
                    print "fnm", first_name_message
                    last_name_message = userinthisquery['last_name']
                    pass;
        print first_name_message
        print first_name_comments

    return render_template('wall.html', first_name = users[0]['first_name'],last_name =  users[0]['last_name'], allmessages = allmessages, allcomments=allcomments)

@app.route('/postmessage', methods = ["POST"])
def postmessage():
    if 'id' in session:
        query = "SELECT * FROM users where id = :id"
        data = { 'id': session['id']}
        users = mysql.query_db(query,data)
        print users[0]['id']
        thisquery1 = "SELECT * FROM messages"
        whatwork = mysql.query_db(thisquery1)
        print whatwork
        data = {'id': session['id']}
        users = mysql.query_db(query, data)
        print users
        thisquery = "INSERT INTO messages (message, created_at, updated_at, users_id) values (:message, now(), now(), :users_id)";
        # # We'll then create a dictionary of data from the POST data received.
        print users[0]['id']
        user_id = users[0]['id']
        print user_id
        print "hjhdjsdh"

        print request.form['formessage']
        print thisquery
        thisdata = {
            'message': request.form['formessage'],
            'users_id': user_id
        }
        print user_id
        print thisdata
        # Run query, with dictionary values injected into the query.
        mysql.query_db(thisquery, thisdata)
        return redirect("/wall")
    else:
        flash('Log In!')

@app.route('/postcomment', methods = ["POST"])
def postcomment():
    if 'id' in session:
        query = "SELECT * FROM users where id = :id"
        data = { 'id': session['id']}
        comment_users = mysql.query_db(query, data)
        print comment_users[0]['id']
        print comment_users[0]['first_name']
        commentquery = "SELECT * FROM comments"
        whatcomment = mysql.query_db(commentquery)
        print whatcomment

        thisiscommentquery = "INSERT INTO comments (comment, created_at, updated_at, messages_id, users_id) values (:comment, now(), now(), :messages_id, :users_id)";
        print request.form['forcomment']
        thiscommentdata = {
            'comment': request.form['forcomment'],
            'messages_id': request.form['messageid'],
            'users_id': comment_users[0]['id']
        }
        mysql.query_db(thisiscommentquery, thiscommentdata)

        return redirect("/wall")
    else:
        flash('Log In!')

@app.route('/logoff')
def logoff():
    session.clear();
    return redirect('/')


app.run(debug=True)