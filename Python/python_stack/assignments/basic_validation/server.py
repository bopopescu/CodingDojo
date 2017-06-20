from flask import Flask, render_template, redirect, request, session, flash

import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

app = Flask(__name__)

app.secret_key = 'ThisIsSecretOnes'

@app.route('/', methods=['GET'])

def index():
	return render_template("index.html")

@app.route('/process', methods=['POST'])
def submit():
  if len(request.form['email']) < 1:
    flash("Email cannot be empty!") # just pass a string to the flash function
  elif not EMAIL_REGEX.match(request.form['email']):
  	flash("Invalid Email Address!")
  else:
    flash("Success!") # just pass a string to the flash function
  return redirect('/') # either way the application should return to the index and display the message


app.run(debug=True)