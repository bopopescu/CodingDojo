<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dojo Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
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
	<h1>${ thatdojo.name } Ninjas</h1>
		
	<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
	</tr>
	<c:forEach items="${allninjasforthisdojo}" var="ninja">
	    <tr>    
	    <td><c:out value="${ninja.firstName}"/></td>
	    <td><c:out value="${ninja.lastName}"/></td>
	    <td><c:out value="${ninja.age}"/></td>
	    </tr>
	</c:forEach>
	</table>
	
</body>
</html>