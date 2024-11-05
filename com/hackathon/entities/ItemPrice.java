package com.hackathon.entities;

public class ItemPrice 
{
	private int id;
	private Item item;
	private String Size;
	private double price;
	
	public ItemPrice() 
	{
	
	}
	
	public ItemPrice(int id, String size, double price) 
	{
		this.id = id;
		Size = size;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemPrice [id=" + id  + ", Size=" + Size + ", price=" + price + "]";
	}

	
	
}
