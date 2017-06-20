var HTMLstring = "";
  for(var i = 1; i <= 151; i++){
      HTMLstring += '<img src="http://pokeapi.co/media/img/'+i+'.png" >';
  }

   $(document).ready(function(){
     $(".content").append(HTMLstring);
 })