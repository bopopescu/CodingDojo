<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo JSP</title>
</head>
<body>
	<h3>Hi! ${name} I'm in makepets.jsp</h3>
<form action="/Pets/ShowtheDogs" method="get">
	<h1>Make a Dog</h1>
	<p>Name</p>
	<input type="text" name="dogname">
	<p>Breed</p>
	<input type="text" name="dogbreed">
	<p>Weight (lb)</p>
	<input type="text" name="dogweight">
	<input type="submit" value = "Add Dog">
</form>
<form  action="/Pets/ShowCat">	
	<h1>Make a Cat</h1>
	<p>Name</p>
	<input type="text" name="catname">
	<p>Breed</p>
	<input type="text" name="catbreed">
	<p>Weight </p>
	<input type="text" name="catweight">
	<input type="submit" value = "Add Cat">	
</form>
 </body>
</html>