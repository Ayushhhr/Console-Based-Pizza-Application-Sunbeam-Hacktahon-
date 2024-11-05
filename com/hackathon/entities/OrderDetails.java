package com.hackathon.entities;

public class OrderDetails 
{
	private int id;
	private int orderId;
	private ItemPrice itemPrice;
	
	public OrderDetails() 
	{
	}

	public OrderDetails(int id, int orderId, ItemPrice itemPrice) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemPrice = itemPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public ItemPrice getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", orderId=" + orderId + ", itemPrice=" + itemPrice + "]";
	}
	
	
}
