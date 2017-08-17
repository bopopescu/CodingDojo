<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<h1>${product.name }</h1>
	<h2>Categories</h2>
 	<c:forEach items="${product.categories}" var="cat">
	    <p><c:out value="${cat.name}"/></p>
	</c:forEach>

 <form method="POST" action="/products/${product.id}/new">
 	<select name="category1">
 	
 		<p>Add Category:</p>
    			<c:forEach var="category" items="${allcategories}">
				<c:if test="${!product.categories.contains(category) }">
					<option value="${ category.id }">${category.name}</option>
				</c:if>
    			</c:forEach>
 	</select>
 	<input type="submit" value="Add"/>
 </form>
 </body>
</html>