<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Deposit</h1>
	<jsp:include page="NavBar.jsp" /><br>
	<h3>Current Balance: $<c:out value="${account.balance}" /></h3>
	<br>
	<form action="DepositServlet" method="post">
		<input type="number" step="0.01" name="depositAmount" placeholder="Deposit Amount"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>