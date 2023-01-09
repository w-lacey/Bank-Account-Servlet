<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="NavBarButtonBehavior.js"></script>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<ul class="transactionListNav">
			<li style="display:inline"><a href="${pageContext.request.contextPath}/AllTransactionsListServlet">All Transactions</a></li>
			<li style="display:inline"><a href="${pageContext.request.contextPath}/DepositTransactionListServlet">Deposit history</a></li>
			<li style="display:inline"><a href="${pageContext.request.contextPath}/TransferTransactionListServlet">Transfer history</a></li>
		</ul>
</body>
</html>