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
		<label>
			<input type="text" name="firstNameInput">
		</label>
		<label>
			<input type="text" name="lastNameInput">
		</label>
		<label>
			<input type="email" name="emailInput">
		</label>
		<label>
			<input type="password" name="passwordInput">
		</label>
		<input type="submit" value="submit">
	</form>
</body>
</html>