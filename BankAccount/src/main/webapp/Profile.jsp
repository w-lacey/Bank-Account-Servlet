<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Account Dashboard</h1>
	<jsp:include page="/Login/NavBar.jsp"  /><br>
	<table>
		<tr>
			<th>Account Number</th>
			<th>Balance</th>
			
		</tr>
		<tr>
			<td><c:out value="${account.accountNumber}" /></td>
			<td><c:out value="${account.balance}" /></td>
		</tr>
	</table>
</body>
</html>