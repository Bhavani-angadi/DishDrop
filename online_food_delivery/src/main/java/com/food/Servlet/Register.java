package com.food.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserDAO;
import com.food.DAOImplementation.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void init() throws ServletException {
    	userDAO=new UserDAOImp();
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
		String userName, email, password,confirmPassword,address,role;
		userName=request.getParameter("name");
		email=request.getParameter("email");
		password=request.getParameter("pwd");
		confirmPassword=request.getParameter("cpwd");
		address=request.getParameter("address");
		role=request.getParameter("role");
		
		if(password.equals(confirmPassword))
		{
			
			int x=userDAO.addUser(new User(userName, password, email, address, role));
			if(x!=0)
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("signup.jsp?error=database");
			}
		}
		else
		{
			response.sendRedirect("signup.jsp?error=password");
		}
	}

}
