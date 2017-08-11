<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Team</title>
</head>
<body>
	<h1>Create a new Team</h1>
	<label>Team Name:</label>
	<form action="NewTeam" method="POST">
		<input type="text" name="teamname">
		<input type="submit" value="Create" name="submit">
	</form>
</body>
</html>