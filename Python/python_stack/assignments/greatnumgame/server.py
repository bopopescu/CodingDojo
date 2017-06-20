from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)

app.secret_key = 'ThisIsSecret'

import random

#session['counter'] = 0
def getrandomNum():
    return random.randrange(0, 101)


@app.route('/')

def index():
    #get = session_count()
    session['rightnumber'] = getrandomNum()
    print "Guess",
    print session['rightnumber']
    return render_template("index.html")

@app.route('/guess', methods=['POST'])

def guess():
    #get = session_count()
    if(type(int(request.form['getcount'])) == int):
        print
        if (int(request.form['getcount']) > session['rightnumber']):
            say = "Too High!"
        elif (int(request.form['getcount']) < session['rightnumber']):
            say = "Too Low!"
        else:
            say = str(session['rightnumber']) + " was a number!"
    else:
        say = "Not a number!"


    return render_template("index.html", say = say)

@app.route('/playagain')

def playagain():
    #get = session_count()
    #session['rightnumber'] = getrandomNum()
    #print session['rightnumber']
    return redirect('/')





app.run(debug=True) #run our server