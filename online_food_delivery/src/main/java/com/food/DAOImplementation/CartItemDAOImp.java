package com.food.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.CartItemDAO;
import com.food.model.CartItem;
import com.food.model.OrderItem;

public class CartItemDAOImp implements CartItemDAO{

	Connection connection=null;
	public CartItemDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addCartItem(CartItem cartItem) {
		String sql="INSERT INTO `cartitem`(`itemName`,`quantity`,`price`) VALUES(?,?,?)";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, cartItem.getCartItemName());
			pstmt.setInt(2, cartItem.getQuantity());
			pstmt.setDouble(3, cartItem.getPrice());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CartItem getCartItem(int cartItemId) {
		String sql="SELECT * FROM `cartitem` WHERE `cartitemId`=?";
		CartItem cartItem=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, cartItemId);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next())
			{
				cartItem=extractCartItemFromResultSet(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItem;
	}

	private CartItem extractCartItemFromResultSet(ResultSet res) throws SQLException {
		CartItem cartItem=new CartItem();
		cartItem.setCartItemId(res.getInt("cartItemId"));
		cartItem.setResaurantId(res.getInt("restaurantId"));
		cartItem.setCartItemName(res.getString("cartItemName"));
		cartItem.setQuantity(res.getInt("quantity"));
		cartItem.setPrice(res.getDouble("price"));
		return cartItem;
	}
	@Override
	public void updateCartItem(CartItem cartItem) {
		String sql="UPDATE `cartitem` SET `cartItemName`=?,`quantity`=?,`price`=? WHERE `cartitemId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, cartItem.getCartItemName());
			pstmt.setInt(2, cartItem.getQuantity());
			pstmt.setDouble(3, cartItem.getPrice());
			pstmt.setInt(4, cartItem.getCartItemId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCartItem(int cartItemId) {
		String sql="DELETE FROM `cartitem` WHERE `cartItemId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, cartItemId);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CartItem> getAllCartItemByUser(CartItem cartItem) {
		Statement stmt=null;
		ResultSet res;
		List<CartItem> al=new ArrayList<CartItem>();
		String sql="Select * from `cartItem`";
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(sql);
			
			while(res.next())
			{
				cartItem = extractCartItemFromResultSet(res);
				al.add(cartItem);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
