package com.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hackathon.util.DBUtil;

public class ItemDao implements AutoCloseable
{
private Connection con;
	
	public ItemDao() throws SQLException 
	{
		con = DBUtil.getConnection();
	}
	
	public void displayVegMenu() throws SQLException
	{
		String sql = "select * from pizza_items where Type = 'Veg'";
		
		try( PreparedStatement stmt = con.prepareStatement(sql) )
		{
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
	          {
				System.out.println("-----------------------");
	            System.out.println("Id: " + rs.getString(1));
	            System.out.println("Name: " + rs.getString(2));
	            System.out.println("Type: " + rs.getString(3));
	            System.out.println("Category: " + rs.getString(4));
	            System.out.println("Description: " + rs.getString(5));
	            System.out.println();
	          }
		}
	}
	public void displayNonVegMenu() throws SQLException
	{
		String sql = "select * from pizza_items where Type = 'NonVeg'";
		
		try( PreparedStatement stmt = con.prepareStatement(sql) )
		{
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
	          {
				System.out.println("-----------------------");
	            System.out.println("Id: " + rs.getString(1));
	            System.out.println("Name: " + rs.getString(2));
	            System.out.println("Type: " + rs.getString(3));
	            System.out.println("Category: " + rs.getString(4));
	            System.out.println("Description: " + rs.getString(5));
	            System.out.println();
	          }
		}
	}
	
	public void displayAvailableSizes(int id) throws SQLException
	{
		String sql = "select p.ID, p.SIZES, p.Price from pizza_pricing p where p.ITEMID = ?";
		
		try( PreparedStatement stmt = con.prepareStatement(sql) )
		{
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
	          {
				System.out.println("ID : " + rs.getInt(1) );
	            System.out.println("Size: " + rs.getString(2));
	            System.out.println("Price: " + rs.getDouble(3));
	            System.out.println();
	          }
		}
	}
	
	@Override
	public void close() throws Exception 
	{
		if(con != null)
			con.close();
	}
}
