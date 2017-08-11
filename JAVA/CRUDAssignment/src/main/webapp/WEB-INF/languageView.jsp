<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${language.name}</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<p>${language.name }</p>
	<p> ${language.creator } </p>
	<p>${language.currentVersion } </p>
	<a href="/languages/edit/${ index }">Edit</a>
	<a href="/languages/delete/${ index }">Delete</a>
	
</body>
</html>