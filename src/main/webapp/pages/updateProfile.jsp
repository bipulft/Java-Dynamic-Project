<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/TimeKeepers/UpdateProfileServlet" method="post" enctype="multipart/form-data">
		<label> First Name: </label>
		<input type="text" id="update-first-name" name="update-first-name" value="${user.firstName}"/> 
		
		<label> Last Name: </label>
		<input type="text" id="update-last-name" name="update-last-name" value="${user.lastName}"/> 
		
<%-- 		<label> Username: </label>
		<input type="text" id="update-username" name="update-username" value="${user.username}"/> 
 --%>		
		<label> Date of Birth: </label>
		<input type="text" id="update-dob" name="update-dob" value="${user.dob}"/> 
		
        <label for="gender">Gender:</label>
        <select id="update-gender" name="update-gender">
            <option value="male" ${user.gender == 'male' ? 'selected' : ''}>Male</option>
            <option value="female" ${user.gender == 'female' ? 'selected' : ''}>Female</option>
        </select>
		
		<label> Phone Number: </label>
		<input type="text" id="update-phone-number" name="update-phone-number" value="${user.phoneNumber}"/> 
		
		
		<label> Email: </label>
		<input type="text" id="update-email" name="update-email" value="${user.email}"/>
		
		<label> Address: </label>
		<input type="text" id="update-address" name="update-address" value="${user.address}"/>
		
		<button type="submit">Update Profile</button> 
	</form>

</body>
</html>