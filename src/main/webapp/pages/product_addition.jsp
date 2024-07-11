<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>

	<head>
	  <meta charset="ISO-8859-1" />
	  <title>Add Product | TimeKeepers</title>
   	  <!-- This is a link to view favicon in browsers tab  -->
  	  <link href="../resources/icons/favicon.png" rel="icon">		
	  <link rel="stylesheet" type="text/css" href="/TimeKeepers/stylesheets/product_addition.css" />
	</head>
	
	<body>
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
	    
		<form action="/TimeKeepers/AddProductServlet" method="post" enctype="multipart/form-data">
	      <div class="form">
	        <div class="row">
	          <div class="col">
	            <label for="product_id">Product ID:</label>
	            <input type="text" id="product_id" name="product_id" required />
	          </div>
	          <div class="col">
	            <label for="product_name">Product Name:</label>
	            <input type="text" id="product_name" name="product_name" required />
	          </div>
	        </div>
	
	        <div class="row">
	          <div class="col">
	            <label for="unit_price">Unit Price:</label>
	            <input type="text" id="unit_price" name="unit_price" required />
	          </div>
	          <div class="col">
	            <label for="product_quantity">Product Quantity:</label>
	            <input type="text" id="product_quantity" name="product_quantity" required />
	          </div>
	        </div>
	          
	        <div class="row">
	          <div class="col">
	            <label for="product_availability">Availability:</label>
	            <select id="product_availability" name="product_availability" required>
	              <option value="in-stock">In-Stock</option>
	              <option value="out-stock">Out-of-Stock</option>
	            </select>
	          </div>
	          <div class="col">
	            <label for="vendor_id">Vendor ID:</label>
	            <input type="text" id="vendor_id" name="vendor_id" required />
	          </div>
	          <!--added by bipul  -->
	          <div class="row">
				<div class="col">
					<label for="image">Profile Picture</label> <input type="file"
						id="image" name="image">
				</div>
			</div>
	        </div>
	        <button type="submit">Add</button>
	      </div>
	
	      <div>
	        <img src="<%=contextPath%>/resources/images/adminLogo/Wristwatch-bro.png" alt="" height="200px" width="250px" style="padding-left:50px;" />
	      </div>
	
	      </form>
	    </div>
	  </section>
	
	  <!-- /// -->
	</body>

</html>