package com.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hackathon.util.DBUtil;

public class OrderDao implements AutoCloseable
{
private Connection con;
	
	public OrderDao() throws SQLException 
	{
		con = DBUtil.getConnection();
	}
	
	public void displayOrders() throws SQLException
	{
		String sql = "select CustomerId, OrderTime, STATUS from pizza_orders";
		
		try( PreparedStatement stmt = con.prepareStatement(sql) )
		{
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
	          {
				System.out.println("-----------------------------------");
	            System.out.println("Customer Id | " + rs.getString("CustomerId"));
	            System.out.println("Order Time | " + rs.getDate("OrderTime"));
	            System.out.println("Status | " + rs.getString("STATUS"));
	          }
		}
	}
	public void displayOrdersById(int id) throws SQLException
	{
		String sql = "select c.name, c.mobile, od.id as OrderDetailsID,o.id as OrderID, i.name,i.type,i.category,i.description from pizza_orderdetails od , pizza_orders o, pizza_items i, pizza_customers c where od.OrderId = o.CustomerId AND od.PriceId = i.id having OrderID = ?";
		
		try( PreparedStatement stmt = con.prepareStatement(sql) )
		{
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
	          {
				System.out.println("--------------------------------------");
				System.out.println("Customer Name    | " + rs.getString(1));
				System.out.println("Mobile           | " + rs.getString(2));
				System.out.println("Order Details Id | " + rs.getInt(3));
				System.out.println("Order Id 		 | " + rs.getInt(4));
				System.out.println("Pizza			 | " + rs.getString(5));
				System.out.println("Type			 | " + rs.getString(6));
				System.out.println("Category		 | " + rs.getString(7));
				System.out.println("Description		 | " + rs.getString(8));
				System.out.println("--------------------------------------");
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
