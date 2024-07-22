package com.food.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOImplementation.MenuDAOImp;
import com.food.DAO.MenuDAO;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		
		if(cart==null)
		{
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
			
			String action=request.getParameter("action");
			if("add".equals(action))
			{
				addItemsToCart(request,cart);
			}
			else if("update".equals(action))
			{
				updateCartItem(request,cart);
			}
			else if("remove".equals(action))
			{
				removeItemFromCart(request,cart);
			}
			session.setAttribute("cart",cart);
			response.sendRedirect("Cart.jsp");
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	private void addItemsToCart(HttpServletRequest request, Cart cart)
	{
		int itemId=Integer.parseInt(request.getParameter("itemsId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		MenuDAO menuDAO=new MenuDAOImp();
		Menu menuItem=menuDAO.getMenu(itemId);
		
		HttpSession session=request.getSession();
		session.setAttribute("restaurantId", menuItem.getRestaurantId());
		
		if(menuItem!=null)
		{
			CartItem item=new CartItem(menuItem.getMenuId(),menuItem.getRestaurantId(),menuItem.getItemName(),quantity, menuItem.getPrice());
			cart.addItem(item);
		}
		
	}
	
	private void updateCartItem(HttpServletRequest request, Cart cart)
	{
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}
	
	private void removeItemFromCart(HttpServletRequest request, Cart cart)
	{
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		cart.removeItem(itemId);
	}
	

}
