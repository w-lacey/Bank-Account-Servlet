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
		<label for="firstNameInput">First Name</label>
		<div>
			<input type="text" name="firstNameInput">
		</div>
		<label for="lastNameInput">Last Name</label>
		<div>
			<input type="text" name="lastNameInput">
		</div>
		<label for="emailInput">Email</label>
		<div>
			<input type="email" name="emailInput">
		</div>
		<label for="passwordInput">Password</label>
		<div>
			<input type="password" name="passwordInput">
		</div>
		<div>
			<input type="submit" value="submit">
		</div>
	</form>
</body>
</html>