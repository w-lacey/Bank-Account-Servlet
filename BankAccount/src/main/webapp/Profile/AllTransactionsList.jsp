<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Deposit History</h1>
	<jsp:include page="/NavBar/NavBar.jsp" /><br>
	<jsp:include page="TransactionListNavBar.jsp" /><br>
	<table>
		<tr>
			<th>Account Number</th>
			<th>Balance</th>
			<th>Transaction Type</th>
		</tr>
		<c:forEach items="${transactionList}" var="transaction">
	     	<tr>
		        <td>${transaction.transactionDate}</td>
				<td>$${transaction.transactionAmount}</td>
				<td>${transaction.transactionType}</td>
	        </tr>
	    </c:forEach>
	</table>
</body>
</html>