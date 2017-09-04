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
	<h1>dashboard</h1>
	<form method="POST" id="logoutForm" action="/logout">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<input type="submit" value="Logout!"/>
	</form>	

	<h2>Current Listings</h2>
	<table>
		<tr>
			<th>Address</th>
			<th>Pool Size</th>
			<th>Cost per Night</th>
			<th>Details</th>
		</tr>
	<c:forEach items="${allHostpool}" var="pool">
		 <tr>
		 	<td>${pool.address }</td>
		 	<td>${pool.pool_size }</td>
		 	<td>$ ${pool.cost }</td>
		 	<td><a href="/host/pools/${pool.id}">/5 edit</a></td>
		 </tr>  
	</c:forEach>
	</table>
	<h3>Hi ${currentUser.firstName }</h3>
	<h3>New Listing</h3>
	 	<form:form method="POST" action="/listing/new" modelAttribute="pool">
		<form:hidden path="id"/>
		<form:hidden path="host" value="${currentUser.id}"/>
		<br>
		<form:label path="address">Address
		<form:errors path="address"/>
		<form:input path="address"/></form:label>
		<br>
		<form:label path="description">Description
		<form:errors path="description"/>
		<form:input path="description"/></form:label>
		<br>
		<form:label path="cost">Cost per Night
		<form:errors path="cost"/>
		<form:input path="cost" type="number"/></form:label>
		<br>
		<p>Pool size</p>
		 <form:select path="pool_size" items="${pool_size}"/>
		
		<input type="submit" value="Add Listing"/>
	</form:form>
	
</body>
</html>

