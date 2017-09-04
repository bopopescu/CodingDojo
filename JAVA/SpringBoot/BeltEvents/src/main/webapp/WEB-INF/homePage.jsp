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
	<h1>Welcome Page <c:out value="${ currentUser.username }"></c:out></h1>
	<form method="POST" id="logoutForm" action="/logout">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<input type="submit" value="Logout!"/>
	</form>	
	
	
	
	<c:out value="${ currentUser.firstName }"></c:out>
	<c:out value="${ currentUser.lastName }"></c:out>
	<c:out value="${ currentUser.createdAt }"></c:out>
	<c:out value="${ currentUser.cities }"></c:out>
	<c:out value="${ currentUser.state }"></c:out>
	
	<c:out value="${ date }"></c:out>
	<p>Here are some of the events in your state:</p>
		<table>
	<tr>
		<th>Name</th>
		<th>Date</th>
		<th>Location</th>
		<th>Host</th>
		<th>Action/Status</th>
	</tr>
	
	<c:forEach items="${allEventsNearBy}" var="event">
	    <tr>    
	    <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
	    <td><c:out value="${event.datehosting}"/></td>
	    <td><c:out value="${event.cities}"/></td>
	    <td><c:out value="${event.getUser().firstName}"/></td>
	     <td>
		    <c:if test="${event.getUser().id ==  currentUser.id}">
		    		<a href="/events/${ event.id }/edit/">Edit</a>
				<a href="/delete/${ event.id }">Delete</a>
		    </c:if>
		    <c:if test="${event.getUser().id !=  currentUser.id && !event.getUsersattending().contains(currentUser)}">
				<form method="POST" action="/join">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<input type="hidden" name="eventid" value="${event.id}"/>
					<input type="hidden" name="userid" value="${currentUser.id}"/>
					<input type="submit" value="Join"/>
				</form>
					<c:forEach items="${event.getUsersattending()}" var="user">
						<p>${currentUser.id}</p>
						<p>${user.id}</p>
						
					</c:forEach>	
		    </c:if>
		    <c:if test="${event.getUser().id !=  currentUser.id && event.getUsersattending().contains(currentUser)}">
		    		<p>Joining</p>
				<form method="POST" action="/cancel">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<input type="hidden" name="eventid" value="${event.id}"/>
					<input type="hidden" name="userid" value="${currentUser.id}"/>
					<input type="submit" value="Cancel"/>
				</form>	

		    </c:if>	     
		</td>
	    </tr>
	</c:forEach>
	</table>
	<br>
	<p>Here are some of the events in other states:</p>
	<table>
	<tr>
		<th>Name</th>
		<th>Date</th>
		<th>Location</th>
		<th>State</th>
		<th>Host</th>
		<th>Action/Status</th>
	</tr>
	
	<c:forEach items="${allEvents}" var="event">
	    <tr>    
	    <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
	    <td><c:out value="${event.datehosting}"/></td>
	    <td><c:out value="${event.cities}"/></td>
	    <td><c:out value="${event.state}"/></td>
	    <td><c:out value="${event.getUser().firstName}"/></td>
	     <td>
	     	<c:if test="${event.getUser().id ==  currentUser.id}">
		    		<a href="/events/${ event.id }/edit/">Edit</a>
				<a href="/delete/${ event.id }">Delete</a>
		    </c:if>
		    <c:if test="${event.getUser().id !=  currentUser.id && !event.getUsersattending().contains(currentUser)}">
				<form method="POST" action="/join">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<input type="hidden" name="eventid" value="${event.id}"/>
					<input type="hidden" name="userid" value="${currentUser.id}"/>
					<input type="submit" value="Join"/>
				</form>	

		    </c:if>
		    <c:if test="${event.getUser().id !=  currentUser.id && event.getUsersattending().contains(currentUser)}">
		    		<p>Joining</p>
				<form method="POST" action="/cancel">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
					<input type="hidden" name="eventid" value="${event.id}"/>
					<input type="hidden" name="userid" value="${currentUser.id}"/>
					<input type="submit" value="Cancel"/>
				</form>	

		    </c:if>	     
		    </td>
	    </tr>
	</c:forEach>
	</table>
	
	<h1>Create an Event</h1>
 	<form:form method="POST" action="/event/new" modelAttribute="event">
		<form:hidden path="id"/>
		<form:hidden path="user" value="${ currentUser.id }"/>
		
		<form:label path="name">Name
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
		<br>
		<form:label path="datehosting">Date
		<form:errors path="datehosting"/>
		<form:input path="datehosting" type="date"/></form:label>
		<br>
		<p>Location</p>
		 <form:input path="cities"/>
		 <form:select path="state" items="${USAstates}"/>
		
		<input type="submit" value="Create"/>
	</form:form>
	
</body>
</html>