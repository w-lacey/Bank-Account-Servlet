<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
		<script>
		$(function($) {
			  let url = window.location.href;
			  $('li a').each(function() {
			    if (this.href === url) {
			      $(this).closest('li').addClass('active');
			    }
			  });
			});
		</script>	
		<ul class="nav">
			<li style="display:inline" class="navLink"><a href="Profile.jsp">Home</a></li>
			<li style="display:inline" class="navLink" ><a href="Deposit.jsp">Deposit Money</a></li>
			<li style="display:inline" class="navLink" ><a href="SearchUser.jsp">Transfer Money</a></li>
			<li style="display:inline" class="navLink" ><a href="AllTransactionsListServlet">Transaction History</a></li>
		</ul>
</body>
</html>