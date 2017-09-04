<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${event.name }</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<body> 
	<form method="POST" id="logoutForm" action="/logout">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<input type="submit" value="Logout!"/>
	</form>	

 	<h1>Welcome, ${currentUser.firstName}!</h1>
	<h2>Current Package: ${currentUser.getGetpackage().name}</h2>
	<h2>Next Due Date: ${currentUser.yepgetsomedueDay}</h2>
	<h2>Amount Due: $ ${currentUser.getGetpackage().cost}</h2>
	<h2>User Since: ${currentUser.createdAt}</h2>

 </body>
</html>

