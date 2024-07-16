<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import=" com.food.model.Restaurant, com.food.model.Menu, java.util.List  " %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MENU</title>
    <link rel="stylesheet" href="menu.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
</head>
<body>

    <div class="content-container">
        <%
            Restaurant restaurant = (Restaurant) request.getAttribute("restaurant");
        %>

        <div class="restaurant-info">
            <h1><%= restaurant.getRestaurantName() %></h1>
            <img src="<%= restaurant.getImgPath() %>" alt="<%= restaurant.getRestaurantName() %> Image">
            <p>Location: <%= restaurant.getAddress() %></p>
            <p>Rating: <%= restaurant.getRating() %> (2000 Ratings)</p>
            <p>Cuisine: <%= restaurant.getCuisineType() %></p>
            <p>Delivery Time: <%= restaurant.getDeliveryTime() %> mins</p>
        </div>

        <%
            @SuppressWarnings("unchecked")
            List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu menu : menuList) {
        %>
                    <div class="category-section">
                        <div class="menu-item">
                         <img src="<%= menu.getImgPath() %>" alt="<%= menu.getItemName() %> Image" width="100" height="100">
                            <div class="menu-details">
                                <h2><%= menu.getItemName() %></h2>
                                <p><%= menu.getDescription() %></p>
                                <p class="price">&#8377;<%= menu.getPrice() %></p>
                            </div>
                            <form action="Cart" method="post"> 
                                <input type="hidden" name="itemsId" value="<%=menu.getMenuId() %>">
                                Quantity: <input type="number" name="quantity" value="1" min="1" class="quantity-input">
                                <input type="submit" value="Add to Cart" class="add-to-cart-btn">
                                <input type="hidden" name="action" value="add">
                            </form>
                        </div>
                    </div>
        <%
                }
            } else {
        %>
                <p>No menu items available.</p>
        <%
            }
        %>
    </div>
    
</body>
</html>
