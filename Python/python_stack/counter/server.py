from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)

app.secret_key = 'ThisIsSecret'



#session['counter'] = 0
# def session_count():
#     try:
#         session['count'] += 1
#     except KeyError:
#         session['count'] = 1
#     return session['count']


@app.route('/')

def index():
    #get = session_count()
    if 'count' in session:
        session['count'] += 1
    else:
        session['count'] = 0
    return render_template("index.html", counter = session['count'])

@app.route('/incrementbyTwo')
def incrementbyTwo():
    session['count'] += 1
    return redirect('/')



@app.route('/reset')
def reset():
    session['count'] = 0
    return redirect('/')


app.run(debug=True) #run our server