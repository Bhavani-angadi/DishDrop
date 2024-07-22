<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List, com.food.model.User, com.food.model.Restaurant " %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HOME PAGE</title>
    <link href="home.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300..800;1,300..800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>


</head>
<body>
    <div class="parent">
    <div class="navigation">
        <div class="nav-item location-dropdown">
            <i class="fas fa-map-marker-alt"></i>
            <select>
                <option value="bangalore">Bangalore</option>
                <option value="mumbai">Mumbai</option>
                <option value="delhi">Delhi</option>
                <option value="chennai">Chennai</option>
            </select>
        </div>
        <div class="nav-item search-bar">
            <i class="fas fa-search"></i>
            <input type="text" placeholder="Search for restaurants, cuisine or a dish">
        </div>
        <a class="nav-item" href=""><i class="fas fa-tags"></i> Offers</a>
        <a class="nav-item" href="">Menu</a>
        <a class="nav-item" href="">Restaurant</a>
        <%
            if (user != null) {
        %>
        <!-- Display when user is logged in -->
        <a class="nav-item" href="Cart"><i class="fas fa-shopping-cart"></i> Cart</a>
        <a class="nav-item" href="OrderHistory"><i class="fas fa-history"></i> Order History</a>
         <div class="nav-item dropdown">
                    <a href="javascript:void(0)" class="dropbtn"><i class="fas fa-user"></i> Profile</a>
                    <div class="dropdown-content">
                       <p>Name: <%= user.getUserName() %></p>
        				<p>Email: <%= user.getEmail() %></p>
                        <a href="logout.jsp">Logout</a>
                    </div>
         </div>
        
        <%
            } else {
        %>
        <!-- Display when user is not logged in -->
        <a class="nav-item" href="login.jsp">Sign in</a>
        <a class="nav-item" href=""><i class="fas fa-shopping-cart"></i> Cart</a>
        <%
            }
        %>
    </div>
</div>


    <div class="homepage">
        <div class="picture">
            <p class="name">DishDrop</p>
            <p class="description">At DishDrop, we believe that every meal should be an adventure, delivered hot and fresh right to your doorstep. Whether you're craving a hearty breakfast, a savory lunch, or a delectable dinner, we've got you covered with a vast array of options from your favorite local restaurants and top-rated eateries.</p>

        </div>

    </div>

    <div class="content">
        <!-- Other content of the page -->
        <p class="tags">--------------------------------------WHAT'S ON YOUR MIND? &#x1F914;--------------------------------------</p>
    </div>

    <div class="parent3">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <ul class="carousel-indicators">
                <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></li>
                <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
                <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
                <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"></li>
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="row align-items-center">
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/b1.avif" class="d-block w-100 dish" alt="Biriyani">
                                <div class="carousel-caption d-md-block">
                                    <p>Biriyani</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/d1.avif" class="d-block w-100 dish" alt="Desserts">
                                <div class="carousel-caption d-md-block">
                                    <p>Desserts</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/i1.jpg" class="d-block w-100 dish" alt="Ice Cream">
                                <div class="carousel-caption d-md-block">
                                    <p>Ice Cream</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row align-items-center">
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/p1.avif" class="d-block w-100 dish" alt="Pizza">
                                <div class="carousel-caption d-md-block">
                                    <p>Pizza</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/panner1.jpg" class="d-block w-100 dish" alt="Paneer">
                                <div class="carousel-caption d-md-block">
                                    <p>Paneer</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/para1.avif" class="d-block w-100 dish" alt="Paratha">
                                <div class="carousel-caption d-md-block">
                                    <p>Paratha</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row align-items-center">
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/r1.avif" class="d-block w-100 dish" alt="Rolls">
                                <div class="carousel-caption d-md-block">
                                    <p>Rolls</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/sb1.jpg" class="d-block w-100 dish" alt="Desk Friendly Dishes">
                                <div class="carousel-caption d-md-block">
                                    <p>Desk Friendly Dishes</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/n1.avif" class="d-block w-100 dish" alt="North Indian">
                                <div class="carousel-caption d-md-block">
                                    <p>North Indian</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row align-items-center">
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/c1.avif" class="d-block w-100 dish" alt="Chicken">
                                <div class="carousel-caption d-md-block">
                                    <p>Chicken</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/bur1.avif" class="d-block w-100 dish" alt="Burger">
                                <div class="carousel-caption d-md-block">
                                    <p>Burger</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="position-relative">
                                <img src="IMAGES/s1.jpg" class="d-block w-100 dish" alt="South Indian">
                                <div class="carousel-caption d-md-block">
                                    <p>South Indian</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>

    <div class="content">
        <!-- Other content of the page -->
        <p class="tags">-----------------------------------------ENJOY YOUR MEAL! &#x1F924;-----------------------------------------</p>
    </div>


    
    
   
   <div class="image-container">
         <%
			    @SuppressWarnings("unchecked")
			     List<Restaurant> restaurantList = (List<Restaurant>) request.getAttribute("restaurantList");
			       if (restaurantList != null && !restaurantList.isEmpty()) {
			           for (Restaurant restaurant : restaurantList) {
		%>
         <div class="image-item">
                 <img src="<%= restaurant.getImgPath() %>" class="gallery-image">
                 <p><%= restaurant.getRestaurantName() %></p>
                 <div class="rating">
                     <p><%= restaurant.getRating() %></p>
                     <span class="star">&#x2606;</span>
                </div>
                     <p><%= restaurant.getCuisineType() %></p>
                     <p><%= restaurant.getAddress() %></p>
                      <p><%= restaurant.getDeliveryTime() %> mins</p>
                      <div class="view-menu-container">
                           <a href="Menu?restaurantId=<%= restaurant.getRestaurantId() %>" class="view-menu-link">View Menu</a>
                   	</div>
        </div>
    <%
            }
        } else {
    %>
           <p>No restaurants available at this point</p>
    <%
        }
    %>
    </div>


	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"></script>
    
    <div id="topRestCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="d-flex justify-content-center">
                    <div class="rest">
                        <div class="img-rest">
                            <img src="IMAGES/stories.webp" alt="Stories Brewery & Kitchen">
                        </div>
                        <div class="rest-info">
                            <p class="rest-name">Stories Brewery & Kitchen</p>
                            <p class="rest-rating">4.5&#x2606;</p>
                            <p class="rest-cuisine">North Indian, Continental, Chinese, Finger Food, Beverages, Desserts</p>
                            <p class="rest-location">BTM</p>
                        </div>
                    </div>
                    <div class="rest">
                        <div class="img-rest">
                            <img src="IMAGES/xoox.jpg" alt="XOOX Brewmill">
                        </div>
                        <div class="rest-info">
                            <p class="rest-name">XOOX Brewmill</p>
                            <p class="rest-rating">4.5&#x2606;</p>
                            <p class="rest-cuisine">North Indian, Continental, American, Italian, Asian, Modern Indian, Pizza, Desserts</p>
                            <p class="rest-location">Koramangala 5th Block</p>
                        </div>
                    </div>
                    <div class="rest">
                        <div class="img-rest">
                            <img src="IMAGES/uru.avif" alt="URU Brewpark">
                        </div>
                        <div class="rest-info">
                            <p class="rest-name">URU Brewpark</p>
                            <p class="rest-rating">4.5&#x2606;</p>
                            <p class="rest-cuisine">North Indian, Continental, Chinese, Italian, Asian, Pizza, Lebanese, Beverages</p>
                            <p class="rest-location">JP Nagar</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="d-flex justify-content-center">
                    <div class="rest">
                        <div class="img-rest">
                            <img src="IMAGES/reservior.avif" alt="The Reservoire">
                        </div>
                        <div class="rest-info">
                            <p class="rest-name">The Reservoire</p>
                            <p class="rest-rating">4.5&#x2606;</p>
                            <p class="rest-cuisine">North Indian, Biryani, Asian, Italian, Continental, Bar Food, Beverages, Desserts</p>
                            <p class="rest-location">Koramangala 5th Block</p>
                        </div>
                    </div>
                    <div class="rest">
                        <div class="img-rest">
                            <img src="IMAGES/gillys.avif" alt="Gilly's 104 Bar">
                        </div>
                        <div class="rest-info">
                            <p class="rest-name">Gilly's 104 Bar</p>
                            <p class="rest-rating">4.5&#x2606;</p>
                            <p class="rest-cuisine">Bar Food, Chinese, Continental, North-Indian, Mughlai, Seafood, Desserts, Beverages</p>
                            <p class="rest-location">Koramangala 5th Block</p>
                        </div>
                    </div>
                    <div class="rest">
                        <div class="img-rest">
                            <img src="IMAGES/boho.webp" alt="Boho">
                        </div>
                        <div class="rest-info">
                            <p class="rest-name">Boho</p>
                            <p class="rest-rating">4.5&#x2606;</p>
                            <p class="rest-cuisine">Continental, Asian, American, Mexican, Beverages, Desserts, Korean, Italian</p>
                            <p class="rest-location">Koramangala 5th Block</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#topRestCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#topRestCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    
    <div class="explore-more-container">
        <button class="explore-more-btn">Explore More Restaurants</button>
    </div>
    
    
    
    
    <div class="features-section">
        <h2 class="features-heading">Why Choose Our Food Delivery App?</h2>
        <div class="features-container">
            <div class="feature-item">
                <img src="IMAGES/delivery.avif" alt="Fastest Delivery" class="feature-icon">
                <h3 class="feature-title">Fastest Delivery</h3>
                <p class="feature-description">Get your food delivered to you in no time with our super-fast delivery service.</p>
            </div>
            <div class="feature-item">
                <img src="IMAGES/spoon.jpg" alt="Best Quality" class="feature-icon">
                <h3 class="feature-title">Best Quality</h3>
                <p class="feature-description">Enjoy high-quality meals prepared by top chefs using the freshest ingredients.</p>
            </div>
            <div class="feature-item">
                <img src="IMAGES/toprating.jpg" alt="Top Ratings" class="feature-icon">
                <h3 class="feature-title">Top Ratings</h3>
                <p class="feature-description">Our app is rated highly by users for its excellent service and user experience.</p>
            </div>
            <div class="feature-item">
                <img src="IMAGES/affordable.jpg" alt="Affordable Prices" class="feature-icon">
                <h3 class="feature-title">Affordable Prices</h3>
                <p class="feature-description">Enjoy delicious meals at prices that won't break the bank.</p>
            </div>
        </div>
    </div>
    

    <footer class="footer">
        <div class="footer-section">
            <h4>ABOUT US</h4>
            <ul>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Our Story</a></li>
                <li><a href="#">Team</a></li>
            </ul>
        </div>
        <div class="footer-section">
            <h4>CUSTOMER SERVICE</h4>
            <ul>
                <li><a href="#">Contact Us</a></li>
                <li><a href="#">FAQs</a></li>
                <li><a href="#">Support</a></li>
            </ul>
        </div>
        <div class="footer-section">
            <h4>INFORMATION</h4>
            <ul>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Terms & Conditions</a></li>
                <li><a href="#">Cookie Policy</a></li>
            </ul>
        </div>
        <div class="footer-section">
            <h4>FOLLOW US</h4>
            <ul class="social-media">
                <li><a href="#"><i class="fab fa-facebook"></i></a></li>
                <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                <li><a href="#"><i class="fab fa-linkedin"></i></a></li>
            </ul>
        </div>
    </footer>

</body>
</html>