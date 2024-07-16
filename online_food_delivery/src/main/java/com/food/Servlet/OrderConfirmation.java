package com.food.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.model.Order;
import com.food.model.Restaurant;
import com.food.model.User;

/**
 * Servlet implementation class Order
 */
@WebServlet("/OrderConfirmation")
public class OrderConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Order order=(Order) session.getAttribute("order");
		
		if(order!=null )
		{
			
			request.setAttribute("order", order);
			RequestDispatcher dispatcher=request.getRequestDispatcher("orderConfirmation.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("home.jsp");
		}
				
	}
}
