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
		<input type="text" name="firstNameInput">
		<input type="text" name="lastNameInput">
		<input type="email" name="emailInput">
		<input type="password" name="passwordInput">
		<input type="submit" value="submit">
	</form>
</body>
</html>