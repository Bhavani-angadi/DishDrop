package com.food.DAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.food.model.Order;

public interface OrderDAO {
	
	void addOrder(Order order, int restaurantId, int userId, HttpSession session);
	Order getOrder(int orderId);
	void updateOrder(Order order);
	void deleteOrder(int orderId);
	List<Order> getAllOrdersByUser(int userId);

}
