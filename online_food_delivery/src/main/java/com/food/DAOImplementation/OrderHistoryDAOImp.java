package com.food.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderHistoryDAO;
import com.food.model.Order;
import com.food.model.OrderHistory;

public class OrderHistoryDAOImp implements OrderHistoryDAO {

	Connection connection=null;
	public OrderHistoryDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		String sql="INSERT INTO `orderHistory`(`totalAmount`,`status`) VALUES(?,?)";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setDouble(1, orderHistory.getTotalAmount());
			pstmt.setString(2,orderHistory.getStatus());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		String sql="SELECT * FROM `orderhistory` WHERE `orderHistoryId`=?";
		OrderHistory orderHistory=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, orderHistoryId);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next())
			{
				orderHistory=extractOrderHistoryFromResultSet(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderHistory;
	}

	private OrderHistory extractOrderHistoryFromResultSet(ResultSet res) throws SQLException {
		OrderHistory orderHistory=new OrderHistory();
		orderHistory.setOrderHistoryId(res.getInt("orderHistoryId"));
		orderHistory.setOrderId(res.getInt("orderId"));
		orderHistory.setUserId(res.getInt("userId"));
		orderHistory.setOrderDate(res.getDate("orderDate"));
		orderHistory.setTotalAmount(res.getDouble("totalAmount"));
		orderHistory.setStatus(res.getString("status"));
		return orderHistory;
	}
	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		String sql="UPDATE `orderhistory` SET `totalAmount`=?,`status`=? WHERE `orderHistoryId`=? ";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setDouble(1, orderHistory.getTotalAmount());
			pstmt.setString(2, orderHistory.getStatus());
			pstmt.setInt(3, orderHistory.getOrderHistoryId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		String sql="DELETE FROM `orderhistory` WHERE `orderHistoryId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, orderHistoryId);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderHistory> getAllOrderHistoriesByUser(OrderHistory orderHistory) {
		Statement stmt=null;
		ResultSet res;
		List<OrderHistory> al=new ArrayList<OrderHistory>();
		String sql="Select * from `orderHistory`";
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(sql);
			
			while(res.next())
			{
				orderHistory = extractOrderHistoryFromResultSet(res);
				al.add(orderHistory);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
