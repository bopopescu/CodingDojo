from flask import Flask, render_template, request, redirect

app = Flask(__name__)

@app.route('/')

def hi():
    return render_template("index.html")

@app.route('/ninjas')
def ninjas():
    return render_template("ninjas.html")

@app.route('/dojos')

def create_ninjas():

    return render_template('dojos.html')


@app.route('/dojos/new', methods=['POST'])

def create_ninjas2():
    name = request.form['name']
    email = request.form['email']
    return redirect('/')

app.run(debug=True)