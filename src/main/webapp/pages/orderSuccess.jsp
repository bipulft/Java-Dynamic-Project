<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="../stylesheets/checkout.css">
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.order-pg {
    text-align: center;
    margin-top: 50px;
}

.order-pg h1 {
    font-size: 36px;
    color: #333;
}

.option-btn {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    margin-top: 20px;
    transition: background-color 0.3s ease;
}

.option-btn:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>
<div class="order-pg">
 	<h1>Your Order has been Confirmed!!!</h1>
 	<div style="margin-top: 30px;">
	<a href="/TimeKeepers/pages/index.jsp" class="option-btn">go back</a>
	</div>
</div>
</body>
</html>