<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/TimeKeepers/stylesheets/productUpdate.css">
</head>
<body>
	<form action="/TimeKeepers/UpdateProductServlet" method="post" enctype="multipart/form-data">
		<label> Product Id: </label>
		<input type="text" id="update-product-id" name="update-product-id" value="${product.product_id}"/> 
		
		<label> Product Name: </label>
		<input type="text" id="update-product-name" name="update-product-name" value="${product.product_name}"/> 
		
		<label> Unit Price: </label>
		<input type="text" id="update-product-price" name="update-product-price" value="${product.unit_price}"/> 
		
		<label> Product Quantity: </label>
		<input type="text" id="update-product-quantity" name="update-product-quantity" value="${product.product_quantity}"/> 
		
		<label for="availability">Availability:</label>
	            <select id="update-product-availability" name="update-product-availability" required>
	              <option value="in-stock">In-Stock</option>
	              <option value="out-stock">Out-of-Stock</option>
	            </select> 
		
		<label> Vendor Id: </label>
		<input type="text" id="update-product-vendor" name="update-product-vendor" value="${product.vendor_id}"/>
		
		<!-- <label for="image">Product Image:</label>
		<input type="file" id="product-image" name="product-image" value="" /> -->

		
		<button type="submit">Update</button> 
	</form>

</body>
</html>