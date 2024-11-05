package com.hackathon.entities;

import java.util.List;

public class Item 
{
	private int id;
	private String name;
	private String type;
	private String category;
	private String description;
	private List<ItemPrice> itemPrice;
	
	public Item() 
	{
		
	}

	public Item(int id, String name, String type, String category, String description, List<ItemPrice> itemPrice) 
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.itemPrice = itemPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemPrice> getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(List<ItemPrice> itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() 
	{
		return "Item [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category + ", description="
				+ description + ", itemPrice=" + itemPrice + "]";
	}
	
	
	
}
