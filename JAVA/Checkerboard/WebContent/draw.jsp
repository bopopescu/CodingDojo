<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Checkerboard</title>
  <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<%--    <% String width = (String) request.getAttribute("width"); %>
 --%>
    <% String width = request.getParameter("width"); %>
	
     <% String height = request.getParameter("height"); %>
	<h1>Checkerboard: <%= width %>w X <%= height %>h</h1>
	<% for(int index =0; index< Double.parseDouble(height); index++){ %>
		<% if(index%2 != 0){ %>
			<% for(int j =0; j< Double.parseDouble(width); j++){ %>
				<% if(j%2 != 0){ %>
					<div class="purple" ></div>
					
				<%  } else{ %>
					<div class="blue" ></div>	
				<% } %>
			<% } %>
			<br>
		<%  } else{ %>
			<% for(int j =0; j< Double.parseDouble(width); j++){ %>
				<% if(j%2 != 0){ %>
					<div class="blue" ></div>
					
				<%  } else{ %>
					<div class="purple" ></div>	
				<% } %>
			<% } %>
			<br>
		<% } %>
		
	<% } %>
	
</body>
</html>