package com.food.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderDAO;
import com.food.DAOImplementation.OrderDAOImp;
import com.food.model.Order;
import com.food.model.User;

/**
 * Servlet implementation class OrderHistory
 */
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	OrderDAO orderDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	orderDAO=new OrderDAOImp();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user!=null)
		{
			List<Order> orderHistory =orderDAO.getAllOrdersByUser(user.getUserId());
			request.setAttribute("orderHistory", orderHistory);
			RequestDispatcher dispatcher=request.getRequestDispatcher("orderHistory.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}

	

}
