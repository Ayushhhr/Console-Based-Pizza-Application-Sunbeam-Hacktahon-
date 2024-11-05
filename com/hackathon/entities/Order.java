package com.hackathon.entities;

import java.util.Date;
import java.util.List;

public class Order 
{
	private int id;
	private int customerId;
	private Date date;
	private String status;
	private List<OrderDetails> orderDetails;
	private Customer customer;
	
	public Order() 
	{
	
	}
	public Order(int id, int customerId, Date date, String status, List<OrderDetails> orderDetails, Customer customer) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.date = date;
		this.status = status;
		this.orderDetails = orderDetails;
		this.customer = customer;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	@Override
	public String toString() 
	{
		return "Order [id=" + id + ", customerId=" + customerId + ", date=" + date + ", status=" + status
				+ ", orderDetails=" + orderDetails + ", customer=" + customer + "]";
	}

	
	
	
}
