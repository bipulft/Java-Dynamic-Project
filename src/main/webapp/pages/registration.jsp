<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>

	<head>
	  <meta charset="ISO-8859-1" />
	  <title>Sign Up | TimeKeepers</title>
   	  <!-- This is a link to view favicon in browsers tab  -->
  	  <link href="../resources/icons/favicon.png" rel="icon">		
	  <link rel="stylesheet" type="text/css" href="/TimeKeepers/stylesheets/registration.css" />
	</head>
	
	<body>
	  <main id="main">
	
	  <section class="register">
	    <div class="container">
	    
	    <%-- Display error message if it exists --%>
		<%
		String errorMessage = (String) request.getAttribute("StringUtils.ERROR_MESSAGE");// why StringUtils.ERROR_MESSAGE didn't worked
		if (errorMessage != null && !errorMessage.isEmpty()) {
		%>
		<p class="error-message"><%=errorMessage%></p>
		<%
		}
		%>
	    
		<form action="../RegisterServlet" method="post" enctype="multipart/form-data">
	      <div class="form">
	        <div class="row">
	          <div class="col">
	            <label for="firstName">First Name:</label>
	            <input type="text" id="firstName" name="firstName" required />
	          </div>
	          <div class="col">
	            <label for="lastName">Last Name:</label>
	            <input type="text" id="lastName" name="lastName" required />
	          </div>
	        </div>
	
	        <div class="row">
	          <div class="col">
	            <label for="username">Username:</label>
	            <input type="text" id="username" name="username" required />
	          </div>
	          <div class="col">
	            <label for="birthday">Birthday:</label>
	            <input type="date" id="birthday" name="birthday" required />
	          </div>
	        </div>
	
	        <div class="row">
	          <div class="col">
	            <label for="gender">Gender:</label>
	            <select id="gender" name="gender" required>
	              <option value="male">Male</option>
	              <option value="female">Female</option>
	            </select>
	          </div>
	          <div class="col">
	            <label for="phoneNumber">Phone Number:</label>
	            <input type="tel" id="phoneNumber" name="phoneNumber" required />
	          </div>
	        </div>
	
	        <div class="row">
	          <div class="col">
	            <label for="email">Email:</label>
	            <input type="email" id="email" name="email" required />
	          </div>
	          <div class="col">
	            <label for="address">Address:</label>
	            <input type="text" id="address" name="address" required />
	          </div>
	        </div>
		
	        <div class="row">
	          <div class="col">
	            <label for="password">Password:</label>
	            <input type="password" id="password" name="password" required />
	          </div>
	          <div class="col">
	            <label for="retypePassword">Retype Password:</label>
	            <input type="password" id="retypePassword" name="retypePassword" required />
	          </div>
	        </div>
			
			<div class="row">
				<div class="col">
	            <label for="image">Profile Picture:</label>
	            <input type="file" id="image" name="image" required />
	          </div>
			</div>		
	        <button type="submit">Sign Up</button>
	      </div>
	
	      <div class="#">
	        <img src="<%=contextPath%>/resources/images/adminLogo/Smartwatch-bro.png" alt="register photo" height="200px" width="250px" style="padding-left:50px;" />
	      </div>
	
	      </form>
	    </div>
	  </section>
	  </main>
	  <!-- /// -->
	</body>

</html>
