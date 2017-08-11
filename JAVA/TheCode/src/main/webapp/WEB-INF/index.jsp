<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Secret</title>
<style type="text/css">
	.red{
		color: red;
	}
</style>
</head>
<body>
	<span class="red"><c:out value="${thaterror}"/></span>
	<h1>What is the code?</h1>
	<form action="/code" method="POST">
		<input type="text" name="thatcode">
		<input type="submit" value="Try Code">
	</form>
</body>
</html>