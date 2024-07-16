package com.food.main;

import java.util.List;

import com.food.DAOImplementation.OrderDAOImp;
import com.food.DAOImplementation.RestaurantDAOImp;
import com.food.model.Order;
import com.food.model.Restaurant;

public class Launch {

	public static void main(String[] args) {
		
//		------------------------------------USER-------------------------------------------------------------
		
//		User u=new User("Bhavani","ravi@1974","bhavani27@gmail.com","PUNE","customer");
//		UserDAOImp ud=new UserDAOImp();
//		ud.addUser(u);
		
//		UserDAOImp ud=new UserDAOImp();
//		User user=ud.getUser("bhavani27@gmail.com");
//		System.out.println(user);
		
//		User u=new User(1,"Bhavani","bhavani@2002","bhavaniangadi@gmail.com","Maharashtra","customer");
//		UserDAOImp ud=new UserDAOImp();
//		ud.updateUser(u);
		
//		User u=new User();
//		UserDAOImp ud=new UserDAOImp();
//		List<User> list=ud.getAllUser(u);
//		for(User user:list)
//		{
//			System.out.println(user.getUserId()+" "+user.getUserName()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getAddress()+" "+user.getRole());
//		}
		
//		UserDAOImp ud=new UserDAOImp();
//		ud.deleteUser(3);
		
//		-------------------------------------RESTAURANT-----------------------------------------------------------
		
//		Restaurant r=new Restaurant(1,"Sri Udupi Park","South Indian",20,"ITPL",4.5,true);
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		rd.addRestaurant(r);
	
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		Restaurant restaurant=rd.getRestaurant(1);
//		System.out.println(restaurant);
		
//		Restaurant r=new Restaurant(1,"A2B","South Indian",20,"HOPE FARM",4.5,true);
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		rd.updateRestaurant(r);
		
//		Restaurant r=new Restaurant();
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		List<Restaurant> list=rd.getAllRestaurants();
//		for(Restaurant restaurant: list)
//		{
//			System.out.println( restaurant);
//		}
		
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		rd.deleteRestaurant(2);
		
//		--------------------------------------MENU------------------------------------------------------------------
		
//		Menu m=new Menu(1,"Masala Papad","cucumber,Tomato,Coriander",100.0,true);
//		MenuDAOImp md=new MenuDAOImp();
//		md.addMenu(m);
		
//		MenuDAOImp md=new MenuDAOImp();
//		Menu menu=md.getMenu(1);
//		System.out.println(menu);
		
//		Menu m=new Menu(1,"Masala Papad","cucumber,Tomato,Coriander,Onion",100.0,true);
//		MenuDAOImp md=new MenuDAOImp();
//		md.updateMenu(m);
		
//		MenuDAOImp md=new MenuDAOImp();
//		md.deleteMenu(2);
		
//		Menu m=new Menu();
//		MenuDAOImp md=new MenuDAOImp();
//		List<Menu> list=md.getAllMenusByRestaurant(r);
//		for(Menu menu: list)
//		{
//			System.out.println( menu);
//		}
		
//		-----------------------------------ORDER-------------------------------------------------------------------------
		
		Order o=new Order(1,2000.0,"pending","UPI");
		OrderDAOImp od=new OrderDAOImp();
		od.addOrder(o);
		
//		OrderDAOImp od=new OrderDAOImp();
//		Order order=od.getOrder(1);
//		System.out.println(order);
		
//		Order order=new Order(1,1000.0,"delivered","cod");
//		OrderDAOImp od=new OrderDAOImp();
//		od.updateOrder(order);
		
//		OrderDAOImp od=new OrderDAOImp();
//		od.deleteOrder(3);
		
//		Order o=new Order();
//		OrderDAOImp od=new OrderDAOImp();
//		List<Order> list=od.getAllOrdersByUser(o);
//		for(Order order: list)
//		{
//			System.out.println( order);
//		}
		
//		-----------------------------------------ORDERHISTORY------------------------------------------------------------
		
//		OrderHistory oh=new OrderHistory(1,2000.0,"delivered");
//		OrderHistoryDAOImp ohd=new OrderHistoryDAOImp();
//		ohd.addOrderHistory(oh);
		
//		OrderHistoryDAOImp ohd=new OrderHistoryDAOImp();
//		OrderHistory orderHistory=ohd.getOrderHistory(1);
//		System.out.println(orderHistory);
		
//		OrderHistory oh=new OrderHistory(1,1000.0,"returned");
//		OrderHistoryDAOImp ohd=new OrderHistoryDAOImp();
//		ohd.updateOrderHistory(oh);
		
//		OrderHistoryDAOImp ohd=new OrderHistoryDAOImp();
//		ohd.deleteOrderHistory(3);
		
//		OrderHistory oh=new OrderHistory();
//		OrderHistoryDAOImp ohd=new OrderHistoryDAOImp();
//		List<OrderHistory> list=ohd.getAllOrderHistoriesByUser(oh);
//		for(OrderHistory orderHistory: list)
//		{
//			System.out.println( orderHistory);
//		}
//		-----------------------------------------ORDERITEM-----------------------------------------------------------------
		
//		OrderItem oi=new OrderItem(1,2,200.0);
//		OrderItemDAOImp oid= new OrderItemDAOImp();
//		oid.addOrderItem(oi);
		
//		OrderItemDAOImp oid= new OrderItemDAOImp();
//		OrderItem orderItem=oid.getOrderItem(1);
//		System.out.println(orderItem);
		
//		OrderItem oi=new OrderItem(1,3,200.0);
//		OrderItemDAOImp oid= new OrderItemDAOImp();
//		oid.updateOrderItem(oi);
		
//		OrderItemDAOImp oid=new OrderItemDAOImp();
//		oid.deleteOrderItem(3);
		
//		OrderItem oi=new OrderItem();
//		OrderItemDAOImp oid=new OrderItemDAOImp();
//		List<OrderItem> list=oid.getAllOrderItemByUser(oi);
//		for(OrderItem orderItem: list)
//		{
//			System.out.println( orderItem);
//		}
		
//		-----------------------------------------------CARTITEM----------------------------------------------------------
		
//		CartItem ci=new CartItem(1,"Masala Papad",2,100.0);
//		CartItemDAOImp cid= new CartItemDAOImp();
//		cid.addCartItem(ci);
		
//		CartItemDAOImp cid= new CartItemDAOImp();
//		CartItem cartItem=cid.getCartItem(1);
//		System.out.println(cartItem);
		
//		CartItem ci=new CartItem(1,"Masala Papad",2,200.0);
//		CartItemDAOImp cid= new CartItemDAOImp();
//		cid.updateCartItem(ci);
		
//		CartItemDAOImp cid= new CartItemDAOImp();
//		cid.deleteCartItem(3);
		
//		CartItem ci=new CartItem();
//		CartItemDAOImp cid=new CartItemDAOImp();
//		List<CartItem> list=cid.getAllCartItemByUser(ci);
//		for(CartItem cartItem: list)
//		{
//			System.out.println( cartItem);
//		}
	}

}
