<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="static/style.css">
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
  <title>Team</title>
</head>
<body>
	<h1>${ nameofteam }</h1>
	<form action="AddPlayer" method="get">
		<input type="hidden" name="id" value="${ id }">
		<input type="submit" value="New Player">
	</form>
<!-- 	<a href="/TeamRoster/AddPlayer">New Player</a>
 -->	<table>
 
  	  <tr>
	    <th>First Name</th>
	    <th>Last Name</th>
	    <th>Age</th>
	    <th>Actions</th>
	  </tr>
	<c:forEach items="${listofplayers}" var="player" varStatus="myIndex">
    <tr>      
        <td>${player.first_name}</td>
        <td>${player.last_name}</td>
        <td>${player.age}</td>
        <td>
            <form action="DeletePlayer" method="POST">
        			<input type="hidden" name="delete"  value="${ myIndex.index }">
        			<input type="hidden" name="teamnumber"  value="${ id }">
        			<input type="submit"  value="Delete">
    			</form>

 		</td>
    </tr>
</c:forEach>  
  </table>

</body>
</html>