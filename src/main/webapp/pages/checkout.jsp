<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Check Out</title>

    <!--css link-->
    <link rel="stylesheet" href="<%=contextPath%>/stylesheets/checkout.css">
</head>
<body>
    <div class="heading">
        <h3>checkout</h3>
        <p><a href="index.jsp">home</a>/checkout</p>
    </div>

    <section class="display-order">
    <%
        if (cart != null && !cart.getItems().isEmpty()) { // Check if cart is not null and has items
            List<CartModel> cartModel = cart.getItems();
            for (CartModel cartItem : cartModel) {
                ProductModel product = cartItem.getProduct();
                
        
        %>
        <p><%=product.getProduct_name() %><span>(Rs <%=product.getUnit_price() %> x <%=cartItem.getProduct_quantity() %>)</span></p>
    <%
            }
        }
     %>
    <c:set var="grandTotal" value="${cart.getTotalPrice()}" />
     <div class="grand-total">grand total : <span>Rs ${grandTotal} /-</span></div>
    </section>

    <section class="checkout">
        <form action="/TimeKeepers/OrderServlet" method="post">
            <h3>place your order</h3>
            <div class="flex">
                <div class="input-box">
                    <span>Name:</span>
                    <input type="text" id="customerName" name="customerName" placeholder="enter your name">
                </div>
                <div class="input-box">
		            <label for="orderDate">Order Date:</label>
		            <input type="date" id="orderDate" name="orderDate" required />
                </div>
                <div class="input-box">
                    <span>Your address:</span>
                    <input type="text" id="customerAddress"  name="customerAddress" placeholder="enter your address">
                </div>
                <div class="input-box">
                    <span>Your phone number:</span>
                    <input type="number" id="phone"  name="phone" placeholder="enter your phone">
                </div>
                <div class="input-box">
                    <label for="delivery">Delivery Status:</label>
		            <select id="deliveryStatus" name="deliveryStatus" required>
		              <option value="pending">Pending</option>
		              <option value="Delivered">Delivered</option>
		            </select>
                </div>
                <div class="input-box">
                    <span>Paid Amount:</span>
                    <input type="number" id="payableAmount" name="payableAmount" placeholder="Eg :- 10000">
                </div>
                <div class="input-box">
                    <span>payment method:</span>
                    <select name="paymentMethod">
                        <option value="cash on delivery">cash on delivery</option>
                        <option value="credit card">credit card</option>
                        <option value="paypal">paypal</option>
                    </select>
                </div>
            </div>
            <a href="/TimeKeepers/pages/cart.jsp" class="option-btn">go back</a>
            <input type="submit" value="order now" class="btn" name="order-btn">
        </form>
    </section>
</body>
</html>
