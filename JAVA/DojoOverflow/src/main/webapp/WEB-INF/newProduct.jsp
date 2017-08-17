<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
 	<form:form method="POST" action="/products/new" modelAttribute="product">
		<form:hidden path="id"/>
<%-- 		<form:label path="dojo">Dojo
		<form:select path="dojo">
    			
    			<c:forEach var="doj" items="${alldojos}">
    				<form:option value="${ doj.id }"  label="${doj.name}"/>
    			</c:forEach>
		</form:select>
		
		</form:label>
 --%>		
		<br>
		<form:label path="name">Name
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
		<br>
		<form:label path="description">Description
		<form:errors path="description"/>
		<form:input path="description"/></form:label>
		<br>
		<form:label path="price">Price
		<form:errors path="price"/>
		<form:input path="price"/></form:label>
		<br>
		<input type="submit" value="Create"/>
	</form:form>

</body>
</html>