<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
	<c:out value="${returnedUser}"/>
	<form action="TransferServlet" method="post">
		<input type="number" step="0.01" name="transferAmount" placeholder="transfer amount">
		<input type="submit" value="confirm">
	</form>
	$<c:out value="${error}" />
</body>
</html>