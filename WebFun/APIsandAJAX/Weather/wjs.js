		$(document).ready(function() {

    		$('button').on("click", function() {
	        // your code here (build up your url)
	        var HTMLstring = "";
	        var city = $("#weather_city").val();
	        //HTMLstring = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=56d04b44687f1ebdb10d724cdc52fd05";
	        console.log(HTMLstring)
  			
  			//return false;

	        $.get("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=56d04b44687f1ebdb10d724cdc52fd05", function(res) {
	            var temp_in_fahrenheit = Math.round((9/5)*(res.main.temp-273)+32);
	            HTMLstring += "<h1>"+res.name+"</h1>";
	            HTMLstring += "<p>Temperature: "+temp_in_fahrenheit+"</p>";
	            $(".content").append(HTMLstring);

	        }, 'json');
	        // don't forget to return false so the page doesn't refresh
	        return false;
    });
});