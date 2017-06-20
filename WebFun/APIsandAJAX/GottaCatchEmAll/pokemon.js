var HTMLstring = "";
                for(var i = 1; i <= 151; i++){
                    HTMLstring += '<img id="'+i+'" src="http://pokeapi.co/media/img/'+i+'.png" >';
                }
            $(document).ready(function(){
                
                $(".content").append(HTMLstring);
                
                    $('img').on("click", function(){
                        $('#pokemon').css("display", "inline-block");
                         var id = $(this).attr("id");
                         console.log(id);
                        $.get("http://pokeapi.co/api/v1/pokemon/"+id, function(res) {
                            console.log(res);
                        var html_str = "";
                        html_str += "<h1>"+res.name+"</h1>";
                        html_str += '<img src="http://pokeapi.co/media/img/'+id+'.png" >';
                        html_str += "<h3>Types</h3>";
                        html_str += "<ul>"; 
                        for(var i = 0; i < res.types.length; i++) {
                            html_str += "<li>" + res.types[i].name + "</li>";
                        }
                        html_str += "</ul>";
                        html_str += "<h3>Height</h3>";
                        html_str += "<p>"+res.height+"</p>";
                        html_str += "<h3>Weight</h3>";
                        html_str += "<p>"+res.weight+"</p>";
                        $("#pokemon").html(html_str);
                    }, "json");
                })
            
            })