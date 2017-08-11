<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add a player to team</h1>
	<form action="AddPlayer" method="POST">
		<label>First Name: </label>
		<input type="text" name="first_name">
		<label>Last Name: </label>
		<input type="text" name="last_name">
		<label>Age: </label>
		<input type="text" name="age">
		<input type="hidden" name="id" value="${ id }">
		<input type="submit" name=Add>
	</form>
</body>
</html>