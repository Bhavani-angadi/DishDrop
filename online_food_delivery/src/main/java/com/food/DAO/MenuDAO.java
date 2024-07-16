package com.food.DAO;

import java.util.List;

import com.food.model.Menu;

public interface MenuDAO {
	
	void addMenu(Menu menu);
	List<Menu> getMenus(int restaurantId);
	Menu getMenu(int menuId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	List<Menu> getAllMenusByRestaurant();
	Menu getMenuByItemName(String itemName);

}
