<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="Random">Generate</a>
	<p>You have click this button <%=  session.getAttribute("count") %> times</p>
	<h1><%=  session.getAttribute("thatstring") %> </h1>
	<p>The last time you generate a word was: <%=  session.getAttribute("date") %></p>

</body>
</html>