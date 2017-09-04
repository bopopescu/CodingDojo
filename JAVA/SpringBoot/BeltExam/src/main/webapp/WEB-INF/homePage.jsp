<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<h1>Welcome to Dojoscriptions, ${currentUser.firstName}! </h1>
	
	<h3>Please choose a subscroption and start date</h3>
 	
	<form method="POST" action="/updateuser/${currentUser.id}">
		<p>
			<label for="dueDay">Due Day</label>
			<input type="number" id="dueDay" min="1" max="31" name="dueDay"/>
		</p>
		<select name="getpackage">
    			<c:forEach var="product" items="${gettingallpackages}">
					<option value="${ product.id }">${product.name}</option>
    			</c:forEach>
		</select>
		<p>
		
			
		</p>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<input type="submit" value="Sign Up"/>
	</form>
	
<%--  	<form:form method="POST" action="/updateuser/${currentUser.id}" modelAttribute="getuser">
		<form:hidden path="id"/>
		<p>
			<label for="dueDay">Due Day</label>
			<input type="number" id="dueDay" min="1" max="31" name="dueDay"/>
		</p>
		<form:label path="somedueDay">Due Day
		<form:errors path="somedueDay"/>
		<form:input path="somedueDay" type="number" min="1" max="31"/></form:label>
 	
 	<br>
		<p>Package</p>
		 <form:select path="packages" items="${gettingallpackages}" />
		
		<input type="submit" value="Sign Up!"/>
	</form:form>
 --%>	
			

</body>
</html>