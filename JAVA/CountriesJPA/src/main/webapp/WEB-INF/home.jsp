<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<h1>home</h1>
	<p>1. What query would you run to get all the countries that speak Slovene?</p>
	<table>
		<tr>
			<th>Country</th>
			<th>Language</th>
			<th>Percentage</th>
		</tr>
		<c:forEach items="${countries}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    <td><c:out value="${country[2]}"/></td>
		    </tr>
		</c:forEach>
	</table>
	
	<p>2. What query would you run to display the total number of cities for each country?</p>
	<table>
		<tr>
			<th>Country</th>
			<th>Number</th>
		</tr>
		<c:forEach items="${totalnumcitiescountry}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    </tr>
		</c:forEach>
	</table>
	
	<p>3. What query would you run to get all the cities in Mexico with a population of greater than 500,000?</p>
	<table>
		<tr>
			<th>Country</th>
			<th>City</th>
			<th>Population</th>
		</tr>
		<c:forEach items="${mexicocities}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    <td><c:out value="${country[2]}"/></td>
		    </tr>
		</c:forEach>
	</table>
	<p>4. What query would you run to get all languages in each country with a percentage greater than 89%?</p>
	
	<table>
		<tr>
			<th>Language</th>
			<th>Country</th>
			<th>Language Percentage</th>
		</tr>
		<c:forEach items="${percentagegreaterthan89}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    <td><c:out value="${country[2]}"/></td>
		    </tr>
		</c:forEach>
	</table>
	<p>5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?</p>
	
	<table>
		<tr>
			<th>Country</th>
			<th>Surface Area</th>
			<th>Population</th>
		</tr>
		<c:forEach items="${SAandGreaterPop}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    <td><c:out value="${country[2]}"/></td>
		    </tr>
		</c:forEach>
	</table>
	
	<p>6. What query would you run to get countries with only Constitutional Monarchy with a capital greater than 200 and a life expectancy greater than 75 years?</p>
	
	<table>
		<tr>
			<th>Country</th>
			<th>Government Form</th>
			<th>Capital</th>
			<th>Life Expectancy</th>
		</tr>
		<c:forEach items="${findCMlife}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    <td><c:out value="${country[2]}"/></td>
		    <td><c:out value="${country[3]}"/></td>
		    </tr>
		</c:forEach>
	</table>
	
	<p>7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? </p>

	<table>
		<tr>
			<th>Country</th>
			<th>City</th>
			<th>District</th>
			<th>Population</th>
		</tr>
		<c:forEach items="${findArgentina}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    <td><c:out value="${country[2]}"/></td>
		    <td><c:out value="${country[3]}"/></td>
		    </tr>
		</c:forEach>
	</table>
	
	<p>8. What query would you run to summarize the number of countries in each region?</p>

	<table>
		<tr>
			<th>Region</th>
			<th>Number</th>
		</tr>
		<c:forEach items="${summarizeNumberCountries}" var="country">
		<tr>
		    <td><c:out value="${country[0]}"/></td>
		    <td><c:out value="${country[1]}"/></td>
		    </tr>
		</c:forEach>
	</table>

</body>
</html>