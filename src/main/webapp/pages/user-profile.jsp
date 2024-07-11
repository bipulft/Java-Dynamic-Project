<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//Get the context path of the application
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TimeKeepers</title>
    <!-- This is a link to view favicon in browsers tab  -->
    <link href="${pageContext.request.contextPath}/resources/icons/favicon.png" rel="icon">
    <!-- Link external css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/user-profile.css" />
	<!-- Internal CSS for message display -->
	<style>
        .message {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #f4f4f4;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            z-index: 1000;
        }
    </style> 
</head>
<body>
	<main id="main">
		<section class="update">
			<div class="container">
			
				<!-- Profile update form -->
				<div class="form">
				<!-- link to index page -->
				<a href="pages/index.jsp" style="text-decoration:none; color: #41817F;">Back</a>
					<!-- User profile image -->
					<div class="" style="text-align:center; padding-bottom:24px;">
					    <img src="<%=contextPath%>/resources/images/user/${user.image}" alt="User Image" width="200px" height="200px">  
					</div>
				
				    <form id="profileForm" action="/TimeKeepers/UpdateProfileServlet" method="post">
					    <div class="row">
						    <div class="col">
						        <input type="text" name="firstName" value="${user.firstName}" placeholder="First Name">
						    </div>
						    <div class="col">
						        <input type="text" name="lastName" value="${user.lastName}" placeholder="Last Name">
						    </div>
					    </div>
					        <input type="text" name="username" value="${user.username}" placeholder="Username" readonly><br>
					    <div class="row">
						    <div class="col">
						        <input type="text" name="dob" value="${user.dob}" placeholder="Date of Birth"><br>
						    </div>
						    <div class="col">
						        <input type="text" name="gender" value="${user.gender}" placeholder="Gender"><br>
						    </div>
					    </div>
					    <input type="text" name="phoneNumber" value="${user.phoneNumber}" placeholder="Phone Number"><br>
					    <input type="email" name="email" value="${user.email}" placeholder="Email"><br>
					    <input type="text" name="address" value="${user.address}" placeholder="Address"><br>
					    <input type="submit" value="Update Profile">
				    </form>
				</div>
			</div>
		</section>
	</main>
	
	<!-- Success message display -->
	<div id="successMessage" class="message" style="font-family:sans-serif">
        Profile Updated Successfully!
    </div>
    
	<!-- JavaScript to display success message and submit form after a delay -->    
	<script>
        document.getElementById('profileForm').addEventListener('submit', function(event) {
            event.preventDefault();
            document.getElementById('successMessage').style.display = 'block';
            setTimeout(function() {
                document.getElementById('successMessage').style.display = 'none';
                document.getElementById('profileForm').submit();
            }, 1000); 
        });
    </script>
</body>
</html>