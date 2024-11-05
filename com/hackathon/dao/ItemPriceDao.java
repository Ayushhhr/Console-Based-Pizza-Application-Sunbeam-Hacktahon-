package com.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hackathon.entities.ItemPrice;
import com.hackathon.util.DBUtil;

public class ItemPriceDao implements AutoCloseable
{
private Connection con;
	
	public ItemPriceDao() throws SQLException 
	{
		con = DBUtil.getConnection();
	}
	
	public ItemPrice getPriceById(int id) throws SQLException
	{
		String sql = "select p.ID, p.SIZES, p.Price from pizza_pricing p where p.ID = ?";
		ItemPrice itemPrice = null;
		try( PreparedStatement stmt = con.prepareStatement(sql) )
		{			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
	          {
				itemPrice = new ItemPrice(rs.getInt(1),rs.getString(2),rs.getDouble(3));
	          }
		}
		return itemPrice;
	}
	
	@Override
	public void close() throws Exception 
	{
		if(con != null)
			con.close();
	}
}
