$(document).ready(function(){

     		$("img").on("click", function(){
     				$('.modal').css('display', 'block');
     				var id = $(this).attr("id");
     				console.log(id);
     				$.get("https://anapioficeandfire.com/api/houses/"+id+"/", function(res) {
                            console.log(res.name);
                            console.log(res.region);
                            
                            var html_str = "";
                            html_str +=  "<h1>House Details</h1>";
                            html_str += "<h3>Name: "+res.name+"</h3>";
                            html_str += "<h3>Words: "+res.words+"</h3>";
                            html_str += "<h3>Titles: "+res.titles+"</h3>";
                            $("#content").html(html_str);
            		 }, "json");

     		});

     		$('span.close, .modal').on('click', function(){
				$('.modal').css('display', 'none');
			});
 		})