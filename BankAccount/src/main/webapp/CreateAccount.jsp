<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create account</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Create Account</h1>
	<form action="CreateAccountServlet" method="post">
		<label for="firstNameInput">First Name</label><br>
			<input type="text" name="firstNameInput"><br>
		<label for="lastNameInput">Last Name</label><br>
			<input type="text" name="lastNameInput"><br>
		<label for="emailInput">Email</label><br>
			<input type="email" name="emailInput"><br>
		<label for="passwordInput">Password</label><br>
			<input type="password" name="passwordInput"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>