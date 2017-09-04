<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
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
	<form method="POST" id="logoutForm" action="/logout">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		<input type="submit" value="Logout!"/>
	</form>	

	<h1>Admin Dashboard</h1>
	<h1>Welcome, ${currentUser.firstName } ${currentUser.lastName } ${currentUser.username }</h1>
	<h1>Customers</h1>
    <table>
    		<tr>
    			<th>Name</th>
    			<th>Email</th>
    			<th>Next Due Date</th>
    			<th>Amount Due</th>
    			<th>Package Due</th>
    			<th>Package Type</th>
    		</tr>
	<c:forEach items="${allusers}" var="user">
		<c:if test="${roleadmin.toString() !=  user.roles.toString()}">
		    <tr>    
			    <td><c:out value="${user.firstName} ${user.lastName}"/></td>
			    <td><c:out value="${user.username}"/></td>
			    <td><c:out value="${user.getGetpackage().cost}"/></td>
			    <td><c:out value="${user.getCreatedAt()}"/></td>
			    	<td><c:out value="${user.yepgetsomedueDay}"/></td>
			    <td><c:out value="${user.getGetpackage().name}"/></td>
		    </tr>
	    </c:if>
	</c:forEach>
    		
    </table>
	
<h1>Packages</h1>
    <table>
    		<tr>
    			<th>Package Name</th>
    			<th>Package Cost</th>
    			<th>Available</th>
    			<th>Users</th>
    			<th>Action</th>
    		</tr>
	<c:forEach items="${allpackages}" var="pack">
	    <tr>    
	    <td><c:out value="${pack.name}"/></td>
	    	<td><c:out value="${pack.cost}"/></td>
	    <td><c:out value="${pack.available}"/></td> 	    
	    <td><c:out value="${pack.getGetusers().size()}"/></td>
	    <td><c:if test="${pack.available ==  'Available'}">
	    		<a href="/deactivate/${pack.id}">deactivate</a>
	    </c:if>
	    <c:if test="${pack.available !=  'Available'}">
	    
	    		<a href="/activate/${pack.id}">activate</a>
	    </c:if>
	    <c:if test="${pack.getGetusers().size() == 0}">
			<a href="/delete/${ pack.id }">Delete</a>
	    </c:if>
	    </td>
	 
	    </tr>
	</c:forEach>
    		
    </table>
   
 	<form:form method="POST" action="/package/new" modelAttribute="getpackage">
		<form:hidden path="id"/>
<%-- 		<form:hidden path="user" value="${currentUser.id }"/>
 --%>		
		<form:label path="name">Name
		<form:errors path="name"/>
		<form:input path="name"/></form:label>
		<br>
		<form:label path="cost">Package Cost
		<form:errors path="cost"/>
		<form:input path="cost"/></form:label>
		<br>
		<form:hidden path="available" value="Available"/>
		<br>		
		<input type="submit" value="Create new Package"/>
	</form:form>
</body>
</html>
