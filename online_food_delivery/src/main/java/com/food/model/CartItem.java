package com.food.model;

public class CartItem {
	
	private int cartItemId;
	private int menuId;
	private int restaurantId;
	private String cartItemName;
	private int quantity;
	private double price;
	
	public CartItem()
	{
		
	}

	public CartItem(int menuId,int restaurantId , String cartItemName, int quantity, double price) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.cartItemName = cartItemName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	public int getMenuId() {
		return menuId;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setResaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getCartItemName() {
		return cartItemName;
	}

	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return cartItemId+" "+restaurantId+" "+cartItemName+" "+quantity+" "+price;
	}
}
