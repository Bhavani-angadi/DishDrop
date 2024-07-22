<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.food.model.Restaurant,com.food.model.Order, com.food.model.OrderItem, com.food.DAO.OrderItemDAO, com.food.DAOImplementation.OrderItemDAOImp, com.food.DAO.RestaurantDAO,com.food.DAOImplementation.RestaurantDAOImp  " %>

<!DOCTYPE html>
<html>
<head>
    <title>Order History</title>
    <link rel="stylesheet" href="orderHistory.css">
</head>
<body>
    <h1>Order History</h1>
    <%
    @SuppressWarnings("unchecked")
        List<Order> orderHistory = (List<Order>) request.getAttribute("orderHistory");
        RestaurantDAO restaurantDAO = new RestaurantDAOImp(); 
       /*  Restaurant restaurant=(Restaurant) session.getAttribute("resturantId"); */
        if (orderHistory != null && !orderHistory.isEmpty()) {
            for (Order order : orderHistory) {
                int restaurantId = order.getRestaurantId();
               		Restaurant restaurant = restaurantDAO.getRestaurant(restaurantId); 
    %>
                <div class="order">
                    <h2>Restaurant: <%= restaurant.getRestaurantName() %></h2>
                    <p>Location: <%= restaurant.getAddress() %></p>
                    <p>Order Date: <%= order.getOrderDate() %></p>
                    <p>Status: <%= order.getStatus() %></p>
                    <p>Total Amount: $<%= order.getTotalAmount() %></p>

                    <h3>Items:</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Item Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                OrderItemDAO orderItemDAO = new OrderItemDAOImp();
                                List<OrderItem> items = orderItemDAO.getOrderItem(order.getOrderId());
                                for (OrderItem item : items) {
                            %>
                                <tr>
                                    <td><%= item.getItemName() %></td>
                                    <td><%= item.getQuantity() %></td>
                                    <td>$<%= item.getItemTotal() %></td>
                                </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
    <%
            }
        } else {
    %>
        <p>No orders found.</p>
    <%
        }
    %>
</body>
</html>

