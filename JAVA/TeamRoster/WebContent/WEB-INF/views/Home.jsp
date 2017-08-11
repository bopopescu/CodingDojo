<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="com.team.models.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.lang.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roster</title>
  <link rel="stylesheet" type="text/css" href="../../static/style.css">
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
</head>
<body>
	<h1>Prototype Roster</h1>
	<a href="/TeamRoster/NewTeam">New Team</a>
	<table>
  	  <tr>
	    <th>Team</th>
	    <th>Players</th>
	    <th>Action</th>
	  </tr>
	<c:forEach items="${getteamlist}" var="team" varStatus="myIndex">
    <tr>      
        <td>${team.team_name}</td>
        <td>${fn:length(team.players)}</td>
        <td>
            <form action="Teams" method="GET">
        			<input type="hidden" name="id" value=${ myIndex.index }>
        			<input type="submit" value="Details">
    			</form>
            <form action="DeleteTeam" method="POST">
        			<input type="hidden" name="delete"  value="${ myIndex.index }">
        			<input type="submit"  value="Delete">
    			</form>


<!--         		<a href="/TeamRoster/Teams">Details</a> <a href="/TeamRoster/DeleteTeam">Delete</a>
 -->        
 		</td>
    </tr>
</c:forEach>  
</table>
</body>
</html>