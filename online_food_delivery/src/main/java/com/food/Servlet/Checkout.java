package com.food.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import com.food.DAO.OrderDAO;
import com.food.DAO.OrderItemDAO;
import com.food.DAOImplementation.OrderDAOImp;
import com.food.DAOImplementation.OrderItemDAOImp;
import com.food.DAO.OrderHistoryDAO;
import com.food.DAOImplementation.OrderHistoryDAOImp;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.OrderItem;
import com.food.model.Restaurant;
import com.food.model.User;
import com.food.model.Menu;
import com.food.DAO.MenuDAO;
import com.food.DAOImplementation.MenuDAOImp;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private OrderDAO orderDAO;
    private MenuDAO menuDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() {
    	orderDAO = new OrderDAOImp();
        menuDAO = new MenuDAOImp();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        Integer restaurantId = (Integer) session.getAttribute("restaurantId");

        if (cart != null && user != null && restaurantId != null && !cart.getItems().isEmpty()) {
            // Extract checkout form data
            String address = request.getParameter("address");
            String paymentMethod = request.getParameter("paymentMethod");

            // Create and populate the order object
            Order order = new Order();
            order.setUserId(user.getUserId());
            order.setRestaurantId(restaurantId);
            order.setOrderDate(new Date());
            order.setPaymentMethod(paymentMethod);
            order.setStatus("Pending");

            // Calculate the total amount
            double totalAmount = 0;
            for (CartItem item : cart.getItems().values()) {
                Menu menuItem = menuDAO.getMenuByItemName(item.getCartItemName());
                if (menuItem != null) {
                    totalAmount += item.getPrice() * item.getQuantity();
                }
            }
            order.setTotalAmount(totalAmount);

            // Save the order to the database
            orderDAO.addOrder(order, restaurantId, user.getUserId(), session);

            // Clear the cart and redirect to the order confirmation page
            session.removeAttribute("cart");
            session.setAttribute("order", order);
            response.sendRedirect("OrderConfirmation"); // Redirect to an order confirmation page
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if user is not logged in or cart is empty
        }
    }
}
