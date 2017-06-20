import random
import time
from flask import Flask, render_template, request, redirect, session


app = Flask(__name__)

app.secret_key = 'ThisIsSecretOnes'


@app.route('/')
def index():
    if 'activities' not in session:
        session['activities'] = []
    if 'gold' not in session:
        session['gold'] = 0


    return render_template("index.html")

@app.route('/process_money', methods=['POST'])
def gainmoney():
    thisisdate = time.asctime( time.localtime(time.time()) )
    thislist = []
    color = "green"
    if request.form['building'] == 'farm':
        send = random.randint(10,20)
        session['gold'] += send
        info = "Earned " + str(send) + " golds from the farm! " + thisisdate
        thislist = [info, color]
    elif request.form['building'] == 'cave':
        send = random.randint(5, 10)
        session['gold'] += send
        info = "Earned " + str(send) + " golds from the cave! " + thisisdate
        thislist = [info, color]
    elif request.form['building'] == 'house':
        send = random.randint(2, 5)
        session['gold'] += send
        info = "Earned " + str(send) + " golds from the house! " + thisisdate
        thislist = [info, color]
    elif request.form['building'] == 'casino':
        send = random.randint(0, 50)
        
        get = random.randint(0, 1)
        if(get == 1):
            info = "Earned " + str(send) + " golds from the casino! " + thisisdate
            thislist = [info, color]
            session['gold'] += send
        else:
            color = "red"
            info = "Entered casino and lost " + str(send) + " golds... Ouch " + thisisdate
            thislist = [info, color]
            session['gold'] -= send

    #session['activities'][thisisdate] = [str(info), color]
    #sorted(session['activities'].keys())

    session['activities'].append(thislist)
    print session['activities'][0][1]

    return render_template("index.html", results = session['activities'], gold = session['gold'], forcolor =  color)


@app.route('/reset')
def reset():
    session['activities'] = []
    session['gold'] = 0
    return render_template("index.html", results = session['activities'], gold = session['gold'])



app.run(debug=True) #run our server