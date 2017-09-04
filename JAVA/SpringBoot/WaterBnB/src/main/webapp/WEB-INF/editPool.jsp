<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form:form method="POST" action="/pool/${getpool.id}/edit" modelAttribute="pool">
		<form:hidden path="id"/>
		<form:hidden path="host"/>
		
		<form:label path="address">Address
		<form:errors path="address"/>
		<form:input path="address" value="${getpool.address}"/></form:label>
		<br>
		<form:label path="description">Description
		<form:errors path="description"/>
		<form:input path="description"  value="${getpool.description}"/></form:label>
		<br>
		<p>Email</p>
		<p>${getpool.getHost().username}</p>
		<p>Name</p>
		<p>${getpool.getHost().firstName} ${getpool.getHost().lastName}</p>
		<form:label path="cost">Cost per Night
		<form:errors path="cost"/>
		<form:input path="cost" type="number" value="${getpool.cost}"/></form:label>
		<br>
		<p>Pool size</p>
		 <form:select path="pool_size" items="${pool_size}"/>
		
		<input type="submit" value="Save changes"/>
	</form:form>

</body>
</html>