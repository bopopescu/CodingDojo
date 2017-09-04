<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${getpool.address }</title>
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

	<h1>Review of ${getpool.address }</h1>
	 <form:form method="POST" action="/review/${getpool.id}" modelAttribute="review">
	 	${currentUserid.id } and ${getpool.id}
			<form:hidden path="id"/>
			<form:hidden path="reviewer" value="${currentUserid.id}"/>
			<form:hidden path="pool" value="${getpool.id}"/>
<%--   			<form:hidden name="userid" value="${currentUser.id}"/>
			<form:hidden name="eventid" value="${event.id}"/>		
			
 --%>			<form:label path="text">Review:
			<form:errors path="text"/>
			<form:input path="text"/></form:label>
		<br>		
				 <form:select path="rating" items="${rating}"/>
		
		<input type="submit" value="Submit Review"/>
	</form:form>
</body>
</html>

