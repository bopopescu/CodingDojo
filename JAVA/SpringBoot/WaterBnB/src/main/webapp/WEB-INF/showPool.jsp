<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${event.name }</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<body>
	<h1>${getpool.address }</h1>
	<h2>${getpool.description }</h2>
	<h2>Email: ${getpool.getHost().username }</h2>
	<h2>Name: ${getpool.getHost().firstName } ${getpool.getHost().lastName }</h2>
	<h2>Size: ${getpool.pool_size }</h2>
	<h2>Cost: $ ${getpool.cost }</h2>

	<h1>Reviews (${totalavgrating}/5)</h1>
	<a href="/pools/${getpool.id}/review">Leave a review</a>
 	<c:forEach items="${allreviews}" var="review">
		 	<p>${review.getReviewer().firstName } ${review.getReviewer().lastName }: </p>
		 	<p>Rating: ${review.rating}/5</p>
		 	<p>${review.text}</p>
		 	<hr>
	</c:forEach>
	
	

</body>
</html>

