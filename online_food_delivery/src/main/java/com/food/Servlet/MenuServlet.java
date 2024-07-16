package com.food.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.MenuDAO;
import com.food.DAO.RestaurantDAO;
import com.food.DAOImplementation.MenuDAOImp;
import com.food.DAOImplementation.RestaurantDAOImp;
import com.food.model.Menu;
import com.food.model.Restaurant;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RestaurantDAO restaurantDAO;
	MenuDAO menuDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	restaurantDAO=new RestaurantDAOImp();
    	menuDAO=new MenuDAOImp();
    }
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        
        // Retrieve restaurant details
        Restaurant restaurant = restaurantDAO.getRestaurant(restaurantId);
        
        // Retrieve menu items for the restaurant
        List<Menu> menuList = menuDAO.getMenus(restaurant.getRestaurantId());
        
        // Set attributes in request scope
        req.setAttribute("restaurant", restaurant);
        req.setAttribute("menuList", menuList);
       HttpSession session=req.getSession();
       session.setAttribute("menuList", menuList);
       session.setAttribute("resturantId", restaurantId);
        
        // Forward the request to menu.jsp
        req.getRequestDispatcher("menu.jsp").include(req, resp);
	}
}
