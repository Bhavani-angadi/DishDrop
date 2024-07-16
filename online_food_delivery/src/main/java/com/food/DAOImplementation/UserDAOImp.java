package com.food.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.UserDAO;
import com.food.model.User;

public class UserDAOImp implements UserDAO {
	
	
	 Connection connection=null;
	public UserDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addUser(User user) {
		String sql="INSERT INTO `user`(`userName`,`password`,`email`,`address`,`role`) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return 0;

	}

	@Override
	public User getUser(String email) {
		
		String sql="SELECT * FROM `User` where `email`=?";
		User user=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next())
			{
				user = extractUserFromResultSet(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	private User extractUserFromResultSet(ResultSet res) throws SQLException {
		User user=new User();
		user.setUserId(res.getInt("userId"));
		user.setUserName(res.getString("userName"));
		user.setPassword(res.getString("password"));
		user.setEmail(res.getString("email"));
		user.setAddress(res.getString("address"));
		user.setRole(res.getString("role"));
		return user;
	}

	@Override
	public void updateUser(User user) {
		
		String sql="UPDATE `User` SET `userName`=?, `password`=?,`email`=?,`address`=?,`role`=? WHERE `userId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			pstmt.setInt(6, user.getUserId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		
		String sql="DELETE FROM `User` WHERE `userId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<User> getAllUser(User user) {
		
		Statement stmt=null;
		ResultSet res;
		List<User> al=new ArrayList<User>();
		String sql="Select * from `User`";
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(sql);
			
			while(res.next())
			{
				user = extractUserFromResultSet(res);
				al.add(user);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
		
	}

}
