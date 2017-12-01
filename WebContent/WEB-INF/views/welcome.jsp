<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link href="resources/test.css" rel="stylesheet" />
</head>
<body>

	<!-- <a href="getnewprod">Add Product</a>

	<form action="searchbyproduct" method="get">
		<input type="text" name="product"> <input type="submit"
			value="Search">
	</form> -->

	<!--  Adding form -->
	<form action="registerform" method="post">
		First Name <input type="text" name="firstName"> <br>
		Last Name <input type="text" name="lastName"> <br> 
		Email <input type="text" name="email"> <br> 
		Phone Number <input	type="number" name="phoneNum"> <br>
		Password <input type="password" name="password"> <br>
	 <input	type="submit" value="Register">
		<!-- <a href="SummaryPage.html"><input type="submit" value="Register"></a> -->
		<!-- <input type="submit" value="Register"> -->
	</form>

	<%-- <table border="1">
		<c:forEach var="myVar" items="${cList}">
			<tr>
				<td>${myVar.productID}</td>
				<td>${myVar.code}</td>
				<td>${myVar.description}</td>
				<td>${myVar.listPrice}</td>
				<td><a href="delete?id=${myVar.productID}"> Delete </a></td>
				<td><a href="update?id=${myVar.productID}"> Update </a></td>

			</tr>

		</c:forEach>

	</table> --%>
	<script>
		var myInput = document.getElementById("psw");
		var letter = document.getElementById("letter");
		var capital = document.getElementById("capital");
		var number = document.getElementById("number");
		var length = document.getElementById("length");

		// When the user clicks on the password field, show the message box
		myInput.onfocus = function() {
			document.getElementById("message").style.display = "block";
		}

		// When the user clicks outside of the password field, hide the message box
		myInput.onblur = function() {
			document.getElementById("message").style.display = "none";
		}

		// When the user starts to type something inside the password field
		myInput.onkeyup = function() {
			// Validate lowercase letters
			var lowerCaseLetters = /[a-z]/g;
			if (myInput.value.match(lowerCaseLetters)) {
				letter.classList.remove("invalid");
				letter.classList.add("valid");
			} else {
				letter.classList.remove("valid");
				letter.classList.add("invalid");
			}

			// Validate capital letters
			var upperCaseLetters = /[A-Z]/g;
			if (myInput.value.match(upperCaseLetters)) {
				capital.classList.remove("invalid");
				capital.classList.add("valid");
			} else {
				capital.classList.remove("valid");
				capital.classList.add("invalid");
			}

			// Validate numbers
			var numbers = /[0-9]/g;
			if (myInput.value.match(numbers)) {
				number.classList.remove("invalid");
				number.classList.add("valid");
			} else {
				number.classList.remove("valid");
				number.classList.add("invalid");
			}

			// Validate length
			if (myInput.value.length >= 8) {
				length.classList.remove("invalid");
				length.classList.add("valid");
			} else {
				length.classList.remove("valid");
				length.classList.add("invalid");
			}
		}
	</script>
</body>
</html>