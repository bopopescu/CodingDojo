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
	<h1>${event.name }</h1>
	<h2>Host: ${event.getUser().firstName } ${event.getUser().lastName }</h2>
	<h2>Date: ${event.datehosting }</h2>
	<h2>Location: ${event.cities }, ${event.state }</h2>
	<h2>People who are attending this event: ${event.getUsersattending().size() }</h2>
		<table>
	<tr>
		<th>Name</th>
		<th>Location</th>
	</tr>
	
	<c:forEach items="${attendees}" var="people">
		 <tr>
		 	<td>${people.firstName } ${people.lastName }</td>
		 	<td>${people.cities }</td>
		 </tr>  
	</c:forEach>
	</table>
	<p>${currentUserid}</p>
	<h1>Message Wall</h1>
	
	<c:forEach items="${allmessages}" var="message">
		 	<p>${message.getUser().firstName } ${message.getUser().lastName } says: ${message.text }</p>
	</c:forEach>
	
	
	 	<form:form method="POST" action="/message/${event.id}" modelAttribute="message">
	 	
			<form:hidden path="id"/>
			<form:hidden path="user" value="${currentUserid}"/>
			
			<form:hidden path="event" value="${event.id}"/>
<%--   			<form:hidden name="userid" value="${currentUser.id}"/>
			<form:hidden name="eventid" value="${event.id}"/>		
			
 --%>			<form:label path="text">Add Comment:
			<form:errors path="text"/>
			<form:input path="text"/></form:label>
		<br>		
		<input type="submit" value="Create"/>
	</form:form>
	
</body>
</html>

