package com.food.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.model.OrderHistory;
import com.food.model.OrderItem;

public class OrderItemDAOImp implements OrderItemDAO {

	Connection connection=null;
	public OrderItemDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addOrderItem(OrderItem orderItem) {
		String sql="INSERT INTO `orderitem`(`quantity`,`itemTotal`) VALUES(?,?)";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1,orderItem.getQuantity());
			pstmt.setDouble(2, orderItem.getItemTotal());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		String sql="SELECT * FROM `orderitem` WHERE `orderitemId`=?";
		OrderItem orderItem=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, orderItemId);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next())
			{
				orderItem=extractOrderItemFromResultSet(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	private OrderItem extractOrderItemFromResultSet(ResultSet res) throws SQLException {
		OrderItem orderItem=new OrderItem();
		orderItem.setOrderItemId(res.getInt("orderItemId"));
		orderItem.setOrderId(res.getInt("orderId"));
		orderItem.setMenuId(res.getInt("menuId"));
		orderItem.setQuantity(res.getInt("quantity"));
		orderItem.setItemTotal(res.getDouble("itemTotal"));
		return orderItem;
	}
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		String sql="UPDATE `orderitem` SET `quantity`=?,`itemTotal`=? WHERE `orderitemId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, orderItem.getQuantity());
			pstmt.setDouble(2, orderItem.getItemTotal());
			pstmt.setInt(3, orderItem.getOrderItemId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		String sql="DELETE FROM `orderItem` WHERE `orderItemId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, orderItemId);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderItem> getAllOrderItemByUser(OrderItem orderItem) {
		Statement stmt=null;
		ResultSet res;
		List<OrderItem> al=new ArrayList<OrderItem>();
		String sql="Select * from `orderItem`";
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(sql);
			
			while(res.next())
			{
				orderItem = extractOrderItemFromResultSet(res);
				al.add(orderItem);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
