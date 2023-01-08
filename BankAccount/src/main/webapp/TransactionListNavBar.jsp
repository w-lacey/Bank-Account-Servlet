<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="NavBarButtonBehavior.js"></script>
</head>
<body>
	<ul class="nav">
			<li style="display:inline" class="navLink active" onclick="activeButton()"><a href="AllTransactionsListServlet">All Transactions</a></li>
			<li style="display:inline" class="navLink" onclick="activeButton()"><a href="DepositTransactionListServlet">Deposit history</a></li>
			<li style="display:inline" class="navLink" onclick="activeButton()"><a href="TransferTransactionListServlet">Transfer history</a></li>
		</ul>
</body>
</html>