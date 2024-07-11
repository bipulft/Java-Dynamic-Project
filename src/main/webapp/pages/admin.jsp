<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentAdmin = (String) userSession.getAttribute("username");
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <!-- This is a link to view favicon in browsers tab  -->
  	<link href="../resources/icons/favicon.png" rel="icon">		
    <link rel="stylesheet" href="/TimeKeepers/stylesheets/admin.css">
    <!-- <link rel="stylesheet" href="/TimeKeepers/stylesheets/product.css"> -->
</head>
<body>
    <nav>
        <ul>
            <li>
                <a href="#" class="logo">
                    <img src="<%=contextPath%>/resources/images/adminLogo\logo.png" alt="logo-image" height="100px" width="100%">
                    <span style="margin-top: 16px; margin-left: 0px;"> Time Keepers </span>
                </a>
            </li>
            <li><a href="#">
                <span class="nav-item">Home</span>
            </a></li>
            <li><a href="/TimeKeepers/ProductListServlet">
                <span class="nav-item">Products</span>
            </a></li>
            <li><a href="#">
                <span class="nav-item">Category</span>
            </a></li>
            <li><a href="#">
                <span class="nav-item">Order List</span>
            </a></li>
            <li><a href="#">
                <span class="nav-item">Admin Profile</span>
            </a></li>
            <li>
             <form style="margin-left: 20px;" action="<%
                    // Conditionally set the action URL based on user session
                    if (currentAdmin != null) {
                        out.print(contextPath + "/LogoutServlet");
                    } else {
                        out.print(contextPath + "/pages/login.jsp");
                    }
                %>" method="post">
                    <input type="submit" value="<%
                        // Conditionally set the button label based on user session
                        if (currentAdmin != null) {
                            out.print("LogIn");
                        } else {
                            out.print("LogOut");
                        }
                    %>"/>
                </form>
            </li>
        </ul>
    </nav>

    <div class="main">
        <div class="header">
            <div class="header-title">
            <h2 class="main-title">Admin Dashboard</h2>
            </div>
            <div class="admin-info">
                <div class="search-bar">
                    <input type="text" placeholder="Search" />                
                </div>
                <img src="<%=contextPath%>/resources/images/adminLogo/admin.svg" alt="Admin Profile" />
            </div>
        </div>
        <div class="box-container">
            <h2 class="main-title">Website Data</h2>
            <div class="box-wrapper">
                <div class="data-box">
                    <div class="data-header">
                        <div class="data">
                            <a href="${pageContext.request.contextPath}/UserListServlet">
                            <span class="title">Total Users</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="data-box">
                    <div class="data-header">
                        <div class="data">
                        	<a href = "${pageContext.request.contextPath}/ProductListServlet">
                            	<span class="title">Total Products</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="data-box">
                    <div class="data-header">
                        <div class="data">
                        <a href = "${pageContext.request.contextPath}/OrderListServlet">
                            <span class="title">Total Orders</span>   
                            </a>         
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="products-wrapper">
            <h3 class="main-title" id="productList"> Product List</h3>
          	<a href="product_addition.jsp" ><button type="submit" >Add Product</button></a>
            <br>
            <br>
            <div class="table-container">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Product Name</th>
                            <th>Vendors</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Availability</th>
                            <th>Image</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
		           <tbody>
					    <c:forEach var="product" items="${productList}">
					        <tr>
					            <td>${product.product_id}</td>
					            <td>${product.product_name}</td>
					            <td>${product.vendor_id}</td>
					            <td>${product.unit_price}</td>
					            <td>${product.product_quantity}</td>
					            <td>${product.product_availability}</td>
					            <td>

                                  <img class="product-image" src="<%=contextPath%>/resources/images/product/${product.getImageUrlFromPart()}" alt="Product Image">

                                </td>
					            
					            <td class="action-buttons">
					                <form method="post" action="${pageContext.request.contextPath}/ModifyServlet">
					                    <input type="hidden" name="updateId" value="${product.product_id}" />
					                    <button type="submit">Update</button>
					                </form>
					                <form style="margin-left: 20px;" id="deleteForm-${product.product_id}" method="post"
                                        action="${pageContext.request.contextPath}/DeleteProductServlet">
                                        <input type="hidden" name="deleteId" value="${product.product_id}" />
                                        <button type="button" onclick="confirmDelete('${product.product_id}')">Delete</button>
                                    </form>					                
					            </td>
					        </tr>
					    </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="products-wrapper">
            <h3 class="main-title" id="userList"> User List</h3>
          	<!-- <a href="product_addition.jsp" ><button type="submit" >Add Product</button></a> -->
            <br>
            <br>
            <div class="table-container">
                <table border="1">
                    <thead>
                        <tr>
                           <!--  <th>User Id</th> -->
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Address</th>
                            <th>User Name</th>
                            <th>gender</th>
                            <th>Date Of Birth</th>
            
                        </tr>
                    </thead>
		           <tbody>
					    <c:forEach var="user" items="${userList}">
					        <tr>
					            <%-- <td>${user.user_id}</td> --%>
					            <td>${user.firstName}</td>
					            <td>${user.lastName}</td>
					            <td>${user.address}</td>
					            <td>${user.username}</td>
					            <td>${user.gender}</td>
					            <td>${user.dob}</td>
					        </tr>
					    </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="products-wrapper">
            <h3 class="main-title" id="orderList"> Order List</h3>
          	<!-- <a href="product_addition.jsp" ><button type="submit" >Add Product</button></a> -->
            <br>
            <br>
            <div class="table-container">
                <table border="1">
                    <thead>
                        <tr>
                           <!--  <th>User Id</th> -->
                           
                            <th>Customer Name</th>
                            <th>Order Date</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Status</th>
                            <th>Paid Amount</th>
                            <th>Payment Method</th>
                           
                                     
                        </tr>
                    </thead>
		           <tbody>
					    <c:forEach var="order" items="${orderList}">
					        <tr>
					            <%-- <td>${user.user_id}</td> --%>
					            
					            <td>${order.customerName}</td>
					            <td>${order.orderDate}</td>
					            <td>${order.customerAddress}</td>
					            <td>${order.phone}</td>
					            <td>${order.deliveryStatus}</td>
					            <td>${order.payableAmount}</td>
					            <td>${order.paymentMethod}</td>
					        </tr>
					    </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>	
</body>

<script>
    function confirmDelete(productName) {
        if (confirm("Are you sure you want to delete this product: " + productName
                + "?")) {
            document.getElementById("deleteForm-" + productName).submit();
        }
    }
</script>
</html>