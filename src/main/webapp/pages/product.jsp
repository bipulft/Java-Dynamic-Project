<%@page import="model.ProductModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.StringUtils"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String contextPath = request.getContextPath();
%>

<%
if(session.getAttribute("current_user") != null){
	int isAdmin = (int) session.getAttribute("current_user");
	if (isAdmin == 1){
		
		session.setAttribute("credential", "You are Admin!! No access to this page");
		response.sendRedirect("admin.jsp");
		return;
	}
}
%>


<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<!-- <link rel="stylesheet" type="text/css"
		href="/TimeKeepers/stylesheets/header.css" /> -->
	<!-- <link rel="stylesheet" type="text/css"
		href="/TimeKeepers/stylesheets/footer.css" /> -->
	<link rel="stylesheet" type="text/css"
		href="/TimeKeepers/stylesheets/product.css" />
</head>
<body>
 
 
 	<%
		ProductModel productModel = new ProductModel();
		List<ProductModel> productList;
   		
	%>
 <div class="nav__menu" id="nav-menu">
    <ul class="nav__list">
       <li class="nav__item">
          <a href="<%=contextPath%>/pages/index.jsp" class="nav__link">Home</a>
       </li>

       <li class="nav__item">
          <a href="/TimeKeepers/ProductServlet" class="nav__link">Products</a>
       </li>

       <li class="nav__item">
          <a href="<%=contextPath%>/pages/cart.jsp" class="nav__link">Cart</a>
       </li>

       <li class="nav__item">
          <a href="<%=contextPath%>/pages/aboutUs.jsp" class="nav__link">About Us</a>
       </li>
    </ul>
  </div>
 
 
 
 <div class="search" id="search">
    <form action="./findProductServlet" class="search__form" method = "post">
       <i class="ri-search-line search__icon"></i>
       <input type="text" name = "search" placeholder="How can i help you?" class="search__input">
       <input type="submit" name="submit" value="search" class="btn">
    </form>

    <i class="ri-close-line search__close" id="search-close"></i>
 </div>	
<!-- 	//for showing product in the productListServlet -->
<div class="product-info">
<form method="post" action="./AddToCartServlet">
    <div class="prod">
        <c:if test="${empty productList}">
            <p>No products found.</p>
        </c:if>

        <c:if test="${not empty productList}">
            <c:forEach var="product" items="${productList}">
                <div class="card">
                    <img src="resources/images/product/${product.imageUrlFromPart}" class="card-img-top" alt="product image">
                    <div class="card-body">
                        <h1 class="card-title">${product.product_name}</h1>
                        <h4 class="availability"><span style="font-size: 16px;">Availability:</span> ${product.product_availability}</h4>
                        <h5 class="price"><span class="card-text">Price: Rs</span> ${product.unit_price}</h5>
                        <input type="number" min="1" name="quantity" value="1" max="${product.product_quantity}" class="qty">
                        <input type="hidden" name="product_id" value="${product.product_id}"> <!-- Add hidden input for product_id -->
                        <button type="submit" value="Add to cart">Add to Cart</button>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</form>

</div>

		   	 
		   	 <script src="../stylesheets/main.js"></script>		

</body>
</html>