<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<h1>${category.name }</h1>
	<h2>Products</h2>
 	<c:forEach items="${category.products}" var="prod">
	    <p><c:out value="${prod.name}"/></p>
	</c:forEach>

 <form method="POST" action="/categories/${id}/new">
 	<select name="product1">
 	
 		<p>Add Product:</p>
    			<c:forEach var="product" items="${allproduct}">
				<c:if test="${!category.products.contains(product) }">
					<option value="${ product.id }">${product.name}</option>
				</c:if>
    			</c:forEach>
 	</select>
 	<input type="submit" value="Add"/>
 </form>

</body>
</html>