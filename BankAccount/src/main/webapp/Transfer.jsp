<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer</title>
</head>
<body>
	<h1>Transfer</h1>
	<jsp:include page="NavBar.jsp" /><br>
	<h3>Enter email of user</h3>
	<form action="TransferServlet" method="post">
		<input type="email" name="customerSearchEmail" placeholder="email">
		<input type="submit">
	</form>
</body>
</html>