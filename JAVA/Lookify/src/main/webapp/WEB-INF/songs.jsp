<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lookify!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<a href="/songs/new">Add New</a>
	<a href="/topten">Top Songs</a>
	<form method="GET" action="/search">
		<input type="text" name="search" value="${search}">
		<input type="submit" value="New Search"/>
	</form>
<%-- 	<form:form method="POST" action="/search/${artist}" modelAttribute="music">
		<form:label path="artist">Search
		<form:errors path="artist"/>
		<form:input type = "text" path="artist"/></form:label>
		<br>
		<input type="submit" value="New Search"/>
	</form:form> --%>
	<table>
	<c:forEach items="${allsongs}" var="song" varStatus="loop">
	    <tr>    
	    <td><a href="/songs/${song.id }"><c:out value="${song.title}"/></a></td>
	    <td><c:out value="${song.artist}"/></td>
	    <td><c:out value="${song.rating}"/></td>
	    <td><a href="/songs/delete/${song.id}">Delete</a></td>
	    </tr>
	</c:forEach>
	</table>
</body>
</html>