<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top Ten</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Top Ten Songs</h1>
	<a href="/dashboard">Dashboard</a>
	<table>
	<c:forEach items="${topsongs}" var="song" varStatus="loop">
	    <tr>    
	    <td><a href="/songs/${song.id }"><c:out value="${song.title}"/></a></td>
	    <td><c:out value="${song.artist}"/></td>
	    <td><c:out value="${song.rating}"/></td>
	    </tr>
	</c:forEach>
	</table>
	
</body>
</html>