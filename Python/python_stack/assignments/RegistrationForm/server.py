from flask import Flask, render_template, request, redirect, flash

import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
FIRSTNAME_REGEX = re.compile(r'^([^0-9]*)$')
LASTNAME_REGEX = re.compile(r'^([^0-9]*)$')
PASSWORD_REGEX = re.compile(r'^[a-zA-Z0-9]')
BIRTHDAY_REGEX = re.compile(r'^[0-1][0-9]+/[0-3][0-9]+/[1-2][0-9][0-9][0-9]')

app = Flask(__name__)

app.secret_key = 'ThisIsSecretOnes'

@app.route('/', methods=['GET'])

def hi():
    return render_template("index.html")

@app.route('/result', methods=['POST'])
def result():
	if len(request.form['email']) < 1:
		flash("Email cannot be empty!")
		return redirect('/')
	elif not EMAIL_REGEX.match(request.form['email']):
		flash("Invalid Email Address!")
		return redirect('/')
	else:
	 	email = request.form['email']

	if len(request.form['firstname']) < 1:
		flash("First Name cannot be empty!")
		return redirect('/')
	elif not FIRSTNAME_REGEX.match(request.form['firstname']):
		flash("Invalid First Name!")
		return redirect('/')		
	else:
	 	firstname = request.form['firstname']

	if len(request.form['lastname']) < 1:
		flash("Last Name cannot be empty!")
		return redirect('/')
	elif not LASTNAME_REGEX.match(request.form['lastname']):
		flash("Invalid First Name!")
		return redirect('/')				
	else:
	 	lastname = request.form['lastname']

	if len(request.form['birthday']) < 1:
	 	flash("Birthday cannot be empty!")
	 	return redirect('/')
	elif not BIRTHDAY_REGEX.match(request.form['birthday']):
	 	flash("Invalid Birthday Date!")
	 	return redirect('/')
	else:
	 	birthday = request.form['birthday']

	if len(request.form['password']) < 1:
		flash("Password cannot be empty!")
		return redirect('/')
	elif len(request.form['password']) > 9:
		flash("Password is too long!")
		return redirect('/')
	else:
	 	password = request.form['password']

	if len(request.form['confirm_password']) < 1:
		flash("Confirm Password cannot be empty!")
		return redirect('/')
	elif not PASSWORD_REGEX.match(request.form['password']):
		flash("Password must have at least 1 uppercase letter and 1 numerical value!")
		return redirect('/')
	else:
	 	confirm_password = request.form['confirm_password']

	if password != confirm_password:
		flash("Password and Confirm Password should match!")

	else:
		flash('Thanks for submitting your information!')

	return redirect('/')

app.run(debug=True)