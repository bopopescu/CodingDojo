<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${language.name}</title>
</head>
<body>
	<a href="/languages/delete/${id}">Delete</a>
	<a href="/languages">Dashboard</a>
	<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
		<form:label path="name">Name
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
		<br>
		<form:label path="creator">Creator
		<form:errors path="creator"/>
		<form:input path="creator"/></form:label>
		<br>
		<form:label path="currentVersion">Current Version
		<form:errors path="currentVersion"/>
		<form:input path="currentVersion"/></form:label>
		<br>
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>