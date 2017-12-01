<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<link href="resources/test.css" rel="stylesheet" />
</head>
<body>
<div style="text-align: center">
<h1>
	Welcome to GC Coffee Shop
</h1>
</div>

<div style="text-align: center">
	<a href="welcome">Click to Register</a><br><br>
	
	</div>
	
	
	<table style= "table-align: center">
		<c:forEach var="myVar" items="${cList}">
			<tr>
				<td>${myVar.itemName}</td>
				<td>${myVar.description}</td>
				<td>${myVar.quantity}</td>
				<td>$${myVar.itemPrice}</td>
				<!-- <td><a href="addItem"> Add </a></td> -->
				<td><a href="update?itemName=${myVar.itemName}"> Update </a></td>
				<td><a href="delete?itemName=${myVar.itemName}"> Delete </a></td>

			</tr>

		</c:forEach>

	</table>
	<br><br>
	<table>
	<tr>
	<td><a href="addItem"> Add new item</a></td>
	</tr>
	
	</table>
	
</body>
</html>