<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List, com.food.model.Cart, com.food.model.CartItem " %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="cart.css">
</head>
<body>
	<h1>Your Shopping Cart</h1>
	<div class="cart-items">
		<%
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart != null && !cart.getItems().isEmpty()) {
			for (CartItem item : cart.getItems().values()) {
		%>
		<div class="cart-item">
			<h3><%=item.getCartItemName()%></h3>
			<p>
				&#x20B9;
				<%=item.getPrice()%></p>
			<form action="Cart" method="post">
				<input type="hidden" name="itemId" value="<%=item.getCartItemId()%>">
				<label>Quantity: <input type="number" name="quantity"
					value="<%=item.getQuantity()%>" min="1">
				</label> <input type="submit" name="action" value="update"
					class="update-btn"> <input type="submit" name="action"
					value="remove" class="remove-btn">
			</form>
		</div>
		<%
			}
		} else {
		%>
		<p>Your cart is empty.</p>
		<%
		}
		%>

		<a href="Menu?restaurantId=<%=session.getAttribute("restaurantId") %>" class="btn add-more-items-btn">Add More Items</a>

		<%
		if (session.getAttribute("cart") != null) {
		%>
		<form action="checkout.jsp" method="post">
			<input type="submit" value="Proceed to Checkout"
				class="btn proceed-to-checkout-btn">
		</form>
		<%
		}
		%>
	</div>
</body>
</html>
