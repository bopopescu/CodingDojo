<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="thisisform">
        <h3>Submitted Info</h3>
        <p>Name: ${ yourname }</p>
        <br>
        <p>Dojo Location: ${location}</p>
        <p>Favorite Language: ${language}</p>
        <br>
        <p>Comment: ${comment}</p>
        <br>
        <a id="goback" href="/">Go Back</a>
    </div>
</body>
</html>