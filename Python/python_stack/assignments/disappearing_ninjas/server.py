from flask import Flask, render_template, request, redirect

app = Flask(__name__)

@app.route('/')

def hi():
    return render_template("index.html")

@app.route('/ninjas')
def result():
    return render_template('ninjas.html')

@app.route('/ninjas/<ninja_color>')
def showninjas(ninja_color):
    print ninja_color
    if(ninja_color == "blue"):
        ninja_color = "images/leonardo.jpg"
    elif(ninja_color == "orange"):
        ninja_color = "images/michelangelo.jpg"
    elif(ninja_color == "red"):˜
        ninja_color = "images/raphael.jpg"
    elif(ninja_color == "purple"):
        ninja_color = "images/donatello.jpg"
    else:
        ninja_color = "images/notapril.jpg"

    print ninja_color
    return render_template('different_ninjas.html', ninja_color=ninja_color)


app.run(debug=True)