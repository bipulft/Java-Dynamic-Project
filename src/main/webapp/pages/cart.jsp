<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ProductModel" %>
<%@ page import="model.CartModel. *" %>
<%@ page import="model.CartModel" %>
<%@ page import="model.Cart" %>
<%@ page import="controller.database.DatabaseController" %>
<%@ page import="controller.servlets.*" %>

<%
if(session.getAttribute("current_user") != null){
    int isAdmin = (int) session.getAttribute("current_user");
    if (isAdmin == 1){
        session.setAttribute("credential", "You are Admin!! No access to this page");
        response.sendRedirect("admin.jsp");
        return;
    }
}

Cart cart = (Cart) session.getAttribute("cart"); // Retrieve the cart object from the session
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>

  <!-- Font awesome link-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!--css link-->
    <link rel="stylesheet" href="../stylesheets/cart.css">
    

</head>
<body>
<%-- 	<%@include file= "head.jsp" %>  --%>
    <section class="shopping-cart">
    
        <div class="heading">
            <h3>shopping cart</h3>
            <p><a href="index.jsp">home</a>/cart</p>
        </div>
        
        
        <div class="box-container">
        <c:if test="${empty cart or empty cart.items}">    
            <div class="btn" style="text-align: center; pointer-events: none;">Your Cart is Empty.</div>
        </c:if>
        <%
        if (cart != null && !cart.getItems().isEmpty()) { // Check if cart is not null and has items
            List<CartModel> cartModel = cart.getItems();
            for (CartModel cartItem : cartModel) {
                ProductModel product = cartItem.getProduct();
                
        
        %>
        
            <div class="box">
                <a href=""></a>
                <img src="resources/images/product/${product.imageUrlFromPart}"
                             class="card-img-top" alt="product image">
                <div class="name">${product.product_name}</div>
                <div class="price">Rs${ product.getUnit_price()} /-</div>
                <form method="post" action="../UpdateCartServlet">
                    <input type="hidden" name="cart_id" value="<%= product.getProduct_id()%>">
                    <input type="number" min="1" name="quantity" value="<%= cartItem.getProduct_quantity()%>"> 
                    <input type="submit" name="update_cart" value="update" class="option-btn">
                </form>
                <form action="../RemoveCartProductServlet" method="get">
                    <input type="hidden" name="cart_id" value="<%= product.getProduct_id() %>">
                    <input type="submit" name="delete_cart" value="remove" class="delete-btn">
                </form>
                <div class="sub-total">sub total : <span>Rs<%= Double.parseDouble(product.getUnit_price()) * Integer.parseInt(cartItem.getProduct_quantity()) %> /-</span></div>
            </div>
        <%
            }
        }
        %>    
        </div>
        
        
        <div class="cart-total">
        <c:set var="grandTotal" value="${cart.getTotalPrice()}" /> 
            <p>grand total : <span>Rs ${grandTotal} /-</span></p>
            <div class="flex">
                <a href="../ProductServlet" class="option-btn">continue shopping</a>
                <a href="checkout.jsp" class="btn">proceed to checkout</a>
            </div>
        </div>
    </section>
    
</body>
</html>
