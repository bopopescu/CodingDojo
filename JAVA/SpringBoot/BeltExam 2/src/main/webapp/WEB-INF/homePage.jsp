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
	<h1>Welcome, ${currentUser.username } ${currentUser.createdAt}</h1>
	<p>This is your student sign-up portal. Check your class schedule and 
	find courses for your next term.</p>
	
	<h3>My Schedule</h3>
     			<c:forEach var="course" items="${currentUser.getCourseslisted()}">
    			
 			</c:forEach>
 			
 			<a href="/courses">Find Courses</a>
 			
 				<h1>Create a Course</h1>
 	<form:form method="POST" action="/course/new" modelAttribute="course">
		<form:hidden path="id"/>
<%-- 		<form:hidden path="user" value="${currentUser.id }"/>
 --%>		
		<form:label path="name">Name
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
		<br>
		<form:label path="day">Day
		<form:errors path="day"/>
		<form:input path="day"/></form:label>
		<br>
		<form:label path="time">Time
		<form:errors path="time"/>
		<form:input path="time"/></form:label>
		<br>
		<form:label path="capacity">Capacity
		<form:errors path="capacity"/>
		<form:input path="capacity" type="number"/></form:label>
		<br>		
		<input type="submit" value="Create a course"/>
	</form:form>
 			

</body>
</html>