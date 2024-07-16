package com.food.model;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private int menuId;
	private String itemName;
	private int quantity;
	private double itemTotal;
	
	public OrderItem()
	{
		
	}

	public OrderItem(int orderItemId,String itemName, int quantity, double itemTotal) {
		super();
		this.orderItemId = orderItemId;
//		this.orderId = orderId;
//		this.menuId = menuId;
		this.itemName=itemName;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemName() {
		return itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	@Override
	public String toString() {
		return orderItemId+" "+orderId+" "+menuId+" "+itemName+" "+quantity+" "+itemTotal;
	}

}
