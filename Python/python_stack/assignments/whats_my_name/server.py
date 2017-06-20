from flask import Flask, render_template, request, redirect

app = Flask(__name__)

@app.route('/')

def hi():
    return render_template("index.html")

@app.route('/process', methods=['POST'])
def process():
    name = request.form['name']
    print name
    return render_template('index.html', name = name)

app.run(debug=True)