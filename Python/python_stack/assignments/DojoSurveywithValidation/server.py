from flask import Flask, render_template, request, redirect, flash

app = Flask(__name__)

app.secret_key = 'ThisIsSecretOnes'

@app.route('/', methods=['GET'])

def hi():
    return render_template("index.html")

@app.route('/result', methods=['POST'])
def result():
	if len(request.form['name']) < 1:
		flash("Name cannot be empty!")
		return redirect('/')
	else:
	 	name = request.form['name']

	if len(request.form['comment']) < 1:
		flash("Comment cannot be empty!")
		return redirect('/')
	elif len(request.form['comment']) > 121:
		flash("Comment field is no longer than 120 characters!")
		return redirect('/')
	else:
		comment = request.form['comment']

	location = request.form['location']
	language = request.form['language']

	return render_template('result.html', name = name, location = location, language = language, comment=comment)

app.run(debug=True)