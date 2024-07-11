<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Login | TimeKeepers</title>
   		<!-- This is a link to view favicon in browsers tab  -->
  		<link href="../resources/icons/favicon.png" rel="icon">		
		<link rel="stylesheet" type="text/css" href="/TimeKeepers/stylesheets/login.css" />
	</head>
	
	<body>
		<section class="main">
			<div class="main-div">
				<div class="login-img">
					<img src="<%=contextPath%>/resources/images/adminLogo/background.jpg" alt="" height="400px" width="450px" style="border-radius: 10px;">
				</div>
	
				<div class="login-div">
					<!-- login box starts -->
					<div class="login-box">
						<h2>Enter your details to Login.</h2>
						<form action="../LoginServlet" method="post">
							<div class="row">
								<div class="col">
									<label for="username">Username:</label>
									<input type="text" id="username" name="username" required>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<label for="password">Password:</label>
									<input type="password" id="password" name="password" required>
								</div>
							</div>
							<button type="submit" class="login-button">Login</button>
						</form>
					</div>
					<!-- login box ends -->
				</div>
			</div>
		</section>
	</body>

</html>
