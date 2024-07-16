package com.food.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.RestaurantDAO;
import com.food.DAOImplementation.RestaurantDAOImp;
import com.food.model.Restaurant;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
      RestaurantDAO restaurantDAO; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }
    	@Override
    	public void init() throws ServletException {
    		restaurantDAO=new RestaurantDAOImp();
    	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<Restaurant> restaurantList = restaurantDAO.getAllRestaurants();
	        req.setAttribute("restaurantList", restaurantList);
	        req.getRequestDispatcher("home.jsp").include(req, resp);
	}

}
