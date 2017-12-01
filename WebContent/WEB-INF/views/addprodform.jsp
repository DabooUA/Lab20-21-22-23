<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Product</title>
</head>
<body>
<form action="addnewproduct" method="post">
    Item Name: <input type="text" name="itemName" required> <br>
    Description: <input type="text" name="description" required> <br>
    <!--  these additional attributes for min and step allow us to take in a double variable -->
    Quantity: <input type="number" min="1" step="any" name="quantity"> <br>
    Item Price: <input type="number" min="1" step="any" name="itemPrice"> <br>
    <input type="submit" value="Add Product">

</form>
</body>
</html>