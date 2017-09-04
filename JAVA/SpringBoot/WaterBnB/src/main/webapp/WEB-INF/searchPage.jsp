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
	<h1>Find your pool!</h1>
	<a href="/">Home</a>
	<c:if test="${getuser != null}">
		<form method="POST" id="logoutForm" action="/logout">
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
			<input type="submit" value="Logout!"/>
		</form>	
	</c:if>
	<form method="GET" action="/search">
		<p>
			<label for="location">Location</label>
			<input type="text" id="location" name="location"/>
		</p>
<%-- 		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}"/>
 --%>		
 	<input type="submit" value="New Search"/>
	</form>	
	<p>List of pools</p>

	<table>
		<tr>
			<th>Address</th>
			<th>Pool Size</th>
			<th>Cost per Night</th>
			<th>Details</th>
		</tr>
	<c:forEach items="${allpool}" var="pool">
		 <tr>
		 	<td>${pool.address }</td>
		 	<td>${pool.pool_size }</td>
		 	<td>$ ${pool.cost }</td>
		 	<td><a href="/pools/${pool.id}">/5 See More</a></td>
		 </tr>  
	</c:forEach>
	</table>

	
</body>
</html>

