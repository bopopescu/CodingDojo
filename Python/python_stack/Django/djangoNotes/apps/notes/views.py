from django.shortcuts import render, redirect

from .models import Post

# Create your views here.
def index(request):
    
    context = {
        "allpost": Post.objects.all(),
        'new_post_form': PostForm()
    }
    return render(request, 'notes/index.html', context)

def addnotes(request):
    if request.method == "POST":
        bound_form = PostForm(request.POST)
        if bound_form.is_valid():
            Post.objects.create(content = request.POST['content'])
    context = {
        "allpost": Post.objects.all()
    }

    return render(request, 'notes/posts_index.html', context)
