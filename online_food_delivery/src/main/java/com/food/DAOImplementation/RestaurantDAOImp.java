package com.food.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;
import com.food.model.User;

public class RestaurantDAOImp implements RestaurantDAO {

	Connection connection=null;
	private int noOfRecords;
	public RestaurantDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addRestaurant(Restaurant restaurant) {
		String sql="INSERT INTO `restaurant`(`restaurantName`,`cuisineType`,`deliveryTime`,`address`,`rating`,`isActive`) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,restaurant.getRestaurantName());
			pstmt.setString(2,restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
//			pstmt.setInt(5, restaurant.getAdminUserId());
			pstmt.setDouble(5,restaurant.getRating());
			pstmt.setBoolean(6,restaurant.isActive());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		String sql="SELECT * FROM `restaurant` WHERE `restaurantId`=?";
		Restaurant restaurant =null;
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, restaurantId);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next())
			{
				restaurant=extractRestaurantFromResultSet(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	private Restaurant extractRestaurantFromResultSet(ResultSet res) throws SQLException {
		Restaurant restaurant=new Restaurant();
		
		restaurant.setRestaurantId(res.getInt("restaurantId"));
		restaurant.setRestaurantName(res.getString("restaurantName"));
		restaurant.setCuisineType(res.getString("cuisineType"));
		restaurant.setDeliveryTime(res.getInt("deliveryTime"));
		restaurant.setAdminUserId(res.getInt("adminUserId"));
		restaurant.setAddress(res.getString("address"));
		restaurant.setRating(res.getDouble("rating"));
		restaurant.setActive(res.getBoolean("isActive"));
		restaurant.setImgPath(res.getString("imgPath"));
		return restaurant;
	}
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		String sql="UPDATE `restaurant` SET `restaurantName`=?,`cuisineType`=?,`deliveryTime`=?,`address`=?,`rating`=?,`isActive`=? WHERE `restaurantId`=? ";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,restaurant.getRestaurantName());
			pstmt.setString(2,restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setDouble(5,restaurant.getRating());
			pstmt.setBoolean(6,restaurant.isActive());
			pstmt.setInt(7, restaurant.getRestaurantId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		
		String sql="DELETE FROM `restaurant` WHERE `restaurantId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, restaurantId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		Statement stmt=null;
		ResultSet res;
		List<Restaurant> al=new ArrayList<Restaurant>();
		String sql="Select * from `restaurant`";
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(sql);
			
			while(res.next())
			{
				al.add(extractRestaurantFromResultSet(res));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	
	



}
