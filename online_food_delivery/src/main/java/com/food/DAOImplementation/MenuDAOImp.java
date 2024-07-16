package com.food.DAOImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.model.Menu;
import com.food.model.Restaurant;
import com.food.model.User;

public class MenuDAOImp implements MenuDAO{

	Connection connection=null;
	public MenuDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivery","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addMenu(Menu menu) {
		
		String sql="INSERT INTO `menu`(`itemName`,`description`,`price`,`isAvailable`) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, menu.getItemName());
			pstmt.setString(2, menu.getDescription());
			pstmt.setDouble(3, menu.getPrice());
			pstmt.setBoolean(4, menu.isAvailable());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getMenus(int restaurantId) {
		String sql="SELECT * FROM `menu` WHERE restaurantId=?";
		List<Menu> al=new ArrayList<Menu>();
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, restaurantId);
			ResultSet res=pstmt.executeQuery();
			
			while(res.next())
			{
				al.add(extractMenuFromResultSet(res));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return al;
	}

	private Menu extractMenuFromResultSet(ResultSet res) throws SQLException {
		Menu menu=new Menu();
		menu.setMenuId(res.getInt("menuId"));
		menu.setRestaurantId(res.getInt("restaurantId"));
		menu.setItemName(res.getString("itemName"));
		menu.setDescription(res.getString("description"));
		menu.setPrice(res.getDouble("price"));
		menu.setAvailable(res.getBoolean("isAvailable"));
		
		return menu;
	}
	@Override
	public void updateMenu(Menu menu) {
		String sql="UPDATE `menu` SET `itemName`=?,`description`=?,`price`=?,`isAvailable`=? WHERE `menuId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, menu.getItemName());
			pstmt.setString(2, menu.getDescription());
			pstmt.setDouble(3, menu.getPrice());
			pstmt.setBoolean(4, menu.isAvailable());
			pstmt.setInt(5, menu.getMenuId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int menuId) {
		String sql="DELETE FROM `menu` WHERE `menuId`=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, menuId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenusByRestaurant() {
		Statement stmt=null;
		ResultSet res;
		List<Menu> al=new ArrayList<Menu>();
		String sql="Select * from `menu`";
		try {
			stmt=connection.createStatement();
			res=stmt.executeQuery(sql);
			
			while(res.next())
			{
				al.add(extractMenuFromResultSet(res));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
	@Override
	public Menu getMenu(int menuId) {
		String sql="SELECT * FROM `menu` where `menuId`=?";
		Menu menu=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, menuId);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next())
			{
				menu = extractMenuFromResultSet(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public Menu getMenuByItemName(String itemName) {
	    String sql = "SELECT * FROM `menu` WHERE `itemName` = ?";
	    Menu menu = null;
	    try {
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        pstmt.setString(1, itemName);
	        ResultSet res = pstmt.executeQuery();
	        if (res.next()) {
	            menu = extractMenuFromResultSet(res);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return menu;
	}

}
