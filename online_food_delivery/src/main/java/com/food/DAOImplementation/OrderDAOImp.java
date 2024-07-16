package com.food.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.food.model.OrderItem;
import com.food.model.OrderHistory;
import com.food.DAO.OrderDAO;
import com.food.DAO.MenuDAO;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;
import com.food.model.Order;

public class OrderDAOImp implements OrderDAO {

	Connection connection=null;
	private Statement stmt;
	public OrderDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addOrder(Order order, int restaurantId, int userId, HttpSession session) {
	    String sqlOrder = "INSERT INTO `order`(`userId`,`restaurantId`,`totalAmount`,`status`,`paymentMethod`) VALUES(?,?,?,?,?)";
	    try {
	        // Insert the order
	        PreparedStatement pstmtOrder = connection.prepareStatement(sqlOrder);
	        pstmtOrder.setInt(1, userId);
	        pstmtOrder.setInt(2, restaurantId);
	        pstmtOrder.setDouble(3, order.getTotalAmount());
	        pstmtOrder.setString(4, order.getStatus());
	        pstmtOrder.setString(5, order.getPaymentMethod());
	        pstmtOrder.executeUpdate();

	        // Retrieve the max orderId
	        Statement stmt = connection.createStatement();
	        ResultSet res = stmt.executeQuery("SELECT max(orderId) as x FROM `order`");
	        int id = 0;
	        if (res.next()) {
	            id = res.getInt("x");
	        }

	        // Insert order items
	        Cart cart = (Cart) session.getAttribute("cart");
	        MenuDAO menuDAO = new MenuDAOImp();
	        String sqlOrderItem = "INSERT INTO `orderItem`(`orderId`,`menuId`,`itemName`,`quantity`,`itemTotal`) VALUES(?,?,?,?,?)";
	        PreparedStatement pstmtOrderItem = connection.prepareStatement(sqlOrderItem);
	        for (CartItem cartItem : cart.getItems().values()) {
	            Menu menuItem = menuDAO.getMenuByItemName(cartItem.getCartItemName());
	            if (menuItem != null) {
	                pstmtOrderItem.setInt(1, id);
	                pstmtOrderItem.setInt(2, menuItem.getMenuId());
	                pstmtOrderItem.setString(3, menuItem.getItemName());
	                pstmtOrderItem.setInt(4, cartItem.getQuantity());
	                pstmtOrderItem.setDouble(5, cartItem.getPrice() * cartItem.getQuantity());
	                pstmtOrderItem.executeUpdate();
	            }
	        }

	        // Insert into orderHistory
	        String sqlOrderHistory = "INSERT INTO `orderHistory`(`orderId`,`userId`,`totalAmount`,`status`) VALUES(?,?,?,?)";
	        PreparedStatement pstmtOrderHistory = connection.prepareStatement(sqlOrderHistory);
	        pstmtOrderHistory.setInt(1, id);
	        pstmtOrderHistory.setInt(2, userId);
	        pstmtOrderHistory.setDouble(3, order.getTotalAmount());
	        pstmtOrderHistory.setString(4, "delivered");
	        pstmtOrderHistory.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public Order getOrder(int orderId) {
		String sql="SELECT * FROM `order` WHERE `orderId`=?";
		Order order=null;
		try {
				PreparedStatement pstmt=connection.prepareStatement(sql);
				pstmt.setInt(1, orderId);
				ResultSet res=pstmt.executeQuery();
				
				if(res.next())
				{
					order=extractOrderFromResultSet(res);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return order;
	}

	private Order extractOrderFromResultSet(ResultSet res) throws SQLException {
		Order order=new Order();
		order.setOrderID(res.getInt("orderId"));
		order.setOrderDate(res.getDate("orderDate"));
		order.setTotalAmount(res.getDouble("totalAmount"));
		order.setStatus(res.getString("status"));
		order.setPaymentMethod(res.getString("paymentMethod"));
		return order;
	}
	@Override
	public void updateOrder(Order order) {
		String sql="UPDATE `order` SET `totalAmount`=?,`status`=?,`paymentMethod`=? WHERE `orderID`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setDouble(1, order.getTotalAmount());
			pstmt.setString(2,order.getStatus());
			pstmt.setString(3, order.getPaymentMethod());
			pstmt.setInt(4, order.getOrderId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderId) {
		String sql="DELETE FROM `order` WHERE `orderId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getAllOrdersByUser(int userId) {
		Statement stmt=null;
		ResultSet res;
		List<Order> al=new ArrayList<Order>();
		String sql="Select * from `order` where `userId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, userId);
			res=pstmt.executeQuery();
			
			while(res.next())
			{
				al.add(extractOrderFromResultSet(res));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
