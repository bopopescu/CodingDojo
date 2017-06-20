from django.shortcuts import render

# Create your views here.
from .models import Product
def index(request):
    Product.objects.create(name="Wallet", description="Emerald Green Kate Spade", weight=4, price=32, cost_to_seller=90,
                    category="Accessories")
    product = Product.objects.all()
    for i in product:
        print i.name, i.description

    print product
    return render(request, "thisproduct/index.html")
