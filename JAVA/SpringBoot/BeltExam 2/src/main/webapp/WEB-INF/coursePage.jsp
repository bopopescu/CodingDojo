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
	<h1>Course Dashboard</h1>
		<table>
	<tr>
		<th>Name</th>
		<th>Day</th>
		<th>Time</th>
		<th>Capacity</th>
	</tr>
	
	<c:forEach items="${allcourses}" var="course">
		 <tr>
		 	<td>${course.name }</td>
		 	<td>${course.day }</td>
		 	<td>${course.time }</td>
		 	<td>${course.capacity }</td>
		 </tr>  
	</c:forEach>
	</table>
	
</body>
</html>

