<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<h1>Product List</h1>
	<table border="1">
		<tr>
			<th>ID</th><th>Name</th><th>Price</th>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="index.html">Home</a>
</body>
</html>