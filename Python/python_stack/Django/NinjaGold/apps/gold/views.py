from django.shortcuts import render, HttpResponse, redirect
import random
import time
# Create your views here.
def index(request):
    if 'activities' not in request.session:
        request.session['activities'] = []
    if 'gold' not in request.session:
        request.session['gold'] = 0

    return render(request, 'gold/index.html')

def processingmoney(request):
    if request.method == "POST":
        thisisdate = time.asctime(time.localtime(time.time()))
        thislist = []
        color = "green"
        if request.POST['building'] == 'farm':
            send = random.randint(10, 20)
            request.session['gold'] += send
            info = "Earned " + str(send) + " golds from the farm! " + thisisdate
            thislist = [info, color]
        elif request.POST['building'] == 'cave':
            send = random.randint(5, 10)
            request.session['gold'] += send
            info = "Earned " + str(send) + " golds from the cave! " + thisisdate
            thislist = [info, color]
        elif request.POST['building'] == 'house':
            send = random.randint(2, 5)
            request.session['gold'] += send
            info = "Earned " + str(send) + " golds from the house! " + thisisdate
            thislist = [info, color]
        elif request.POST['building'] == 'casino':
            send = random.randint(0, 50)

            get = random.randint(0, 1)
            if (get == 1):
                info = "Earned " + str(send) + " golds from the casino! " + thisisdate
                thislist = [info, color]
                request.session['gold'] += send
            else:
                color = "red"
                info = "Entered casino and lost " + str(send) + " golds... Ouch " + thisisdate
                thislist = [info, color]
                request.session['gold'] -= send

        # session['activities'][thisisdate] = [str(info), color]
        # sorted(session['activities'].keys())


        request.session['activities'].append(thislist)
        print request.session['activities']
        return redirect('/')
    else:
        return redirect('/')
