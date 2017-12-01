<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Product</title>
</head>
<body>
	<form action="updateproduct" method="post">
		<input type="hidden" name="id" value="${productID}"> 
			ItemName: 	
			<input type="text" name="itemName" required> <br> 
			Description: 
			<input type="text" name="description" required> <br> 
			Quantity: 
			<input type="text" name="quantitiy"> <br> 
			Item Price: 
			<input type="text" name="itemPrice"> <br> 
			
			<input type="submit" value="Update Product">

	</form>
</body>
</html>