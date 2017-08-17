<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Person</title>
</head>
<body>
 
 	<form:form method="POST" action="/persons/new" modelAttribute="person">
		<form:hidden path="id"/>
		<form:label path="firstName">First Name
		<form:errors path="firstName"/>
		<form:input path="firstName"/></form:label>
		<br>
		<form:label path="lastName">Last Name
		<form:errors path="lastName"/>
		<form:input path="lastName"/></form:label>
		<br>
		<input type="submit" value="Create"/>
	</form:form>

</body>
</html>