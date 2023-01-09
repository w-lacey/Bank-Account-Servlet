<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

		<ul class="nav">
			<li style="display:inline" class="navLink"><a href="${pageContext.request.contextPath}/Profile/Profile.jsp">Home</a></li>
			<li style="display:inline" class="navLink" ><a href="${pageContext.request.contextPath}/Profile/Deposit.jsp">Deposit Money</a></li>
			<li style="display:inline" class="navLink" ><a href="${pageContext.request.contextPath}/Profile/SearchUser.jsp">Transfer Money</a></li>
			<li style="display:inline" class="navLink" ><a href="${pageContext.request.contextPath}/Profile/AllTransactionsListServlet">Transaction History</a></li>
		</ul>
</body>
</html>