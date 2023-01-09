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
	<jsp:include page="/NavBar/NavBar.jsp" /><br>
	<h3>Enter email of user</h3>
	<form action="${pageContext.request.contextPath}/SearchUserServlet" method="post">
		<input type="email" name="customerSearchEmail" placeholder="email">
		<input type="submit">
	</form>
	<c:out value="${error}"/>
</body>
</html>