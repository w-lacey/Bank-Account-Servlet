<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Login</h1>
	<jsp:include page="/NavBar/NavBar.jsp" /><br>	
	<form action="LoginServlet" method="post">
		<label for="emailInput">Email:</label>
		<div>
			<input type="email" name="emailInput">
		</div>
		<label for="passwordInput">Password:</label>
		<div>
			<input type="password" name="passwordInput">
		</div>
		<div>
			<input type="submit" name="passwordInput">
		</div>
		<a href="CreateAccount.jsp">Create Account</a>
	</form>
</body>
</html>