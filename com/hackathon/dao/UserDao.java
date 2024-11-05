package com.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hackathon.entities.Customer;
import com.hackathon.util.DBUtil;

public class UserDao implements AutoCloseable
{
	private Connection con;
	
	public UserDao() throws SQLException 
	{
		con = DBUtil.getConnection();
	}
	
	    public void userRegistration(Customer c) 
	    {
	    	
	        String sql = "select ID from  pizza_customers where Email=? or Mobile=?";
	        
	        try( PreparedStatement stmt = con.prepareStatement(sql)  )
	        {
	        	
		        stmt.setString(1, c.getEmail());
		        stmt.setString(2, c.getMobile());
		        ResultSet rs = stmt.executeQuery();
	
			        if(!rs.next())
			        {
			        	
			         String sql1="insert into  pizza_customers(Name, Password, Mobile, Address ,Email) values(?,?,?,?,?)";
			        
			         PreparedStatement stmt1 = con.prepareStatement(sql1);
			         
			          stmt1.setString(1, c.getName());
			          stmt1.setString(2, c.getPassword());
			          stmt1.setString(3, c.getMobile());
			          stmt1.setString(4, c.getAddress());
			          stmt1.setString(5, c.getEmail());
			          
			          stmt1.executeUpdate();
			          
			          System.out.println("user inserted successfully...");
			        }
			        else
			        {
			          System.out.println("\nEmail/Phone number is already used for registration");
			          System.out.println("\nPlease try registering with different email/Phone number");
			        }
	        } 
	        catch(SQLException e)
	        {
	          e.printStackTrace();
	        }
	      }

	      public Customer userLogin(Customer c)
	      {
	        String sql="select Name from pizza_customers where Email=? and Password=?";
	        try(PreparedStatement stmt = con.prepareStatement(sql))
	        {
	          stmt.setString(1, c.getEmail());
	          stmt.setString(2, c.getPassword());
	          
	          ResultSet rs = stmt.executeQuery();
	          if(rs.next())
	          {
	            System.out.println("Login Successfull as " + rs.getString("Name"));
	            c.setName(rs.getString("Name"));
	            return c;
	          }
	        }
	        catch(SQLException e)
	        {
	          e.printStackTrace();
	        } 
	        System.out.println("provided username or password in incorrect");
            return c;
	      }
	      
//	      public User studentlogin(User user) {
//
//	        PreparedStatement pst=null;
//	        ResultSet rs=null;
//	        String sql="select user_id as id from users where user_email=? and user_password=?";
//	        try{
//	          pst= conn.prepareStatement(sql);
//	          pst.setString(1, user.getUseremail());
//	          pst.setString(2, user.getPassword());
//	          
//	          rs=pst.executeQuery();
//	          if(rs.next()){
//	            System.out.println("User Authenticated successfully");
//	            user.setUserId(rs.getInt("id"));
//	            loggedInUser.setUserId(rs.getInt(1));
//	            user.setAuthenticated(true);
//	          }else{
//	            user.setAuthenticated(false);
//	            System.out.println("provided username or password in incorrect");
//
//	          }
//	          db.closePSandRS(pst, rs);
//
//	        }
//	        catch(SQLException e)
//	        {
//	          e.printStackTrace();
//	        } finally {
//	          db.closePSandRS(pst, rs);
//	        }
//	        
//	        return user;
//	      }
//
//
//
//	      public void issuedbook(User user){
//	        // System.out.println("\n update BOOK PAGE");
//	        try{
//	          
//	          String sql = "select * from book where book_id in (select book_id from issue_book where user_id=?)";
//	          PreparedStatement stmt = conn.prepareStatement(sql); 
//	          stmt.setInt(1,user.getUserId());
//	          ResultSet set = stmt.executeQuery();
//	         
//	          while(set.next()){
//	            System.out.println("Book Id = " + set.getInt(1));
//	            System.out.println("Book Name = "+set.getString(2));
//	          }
//	          
//	          db.closePSandRS(stmt,set);
//
//	        }catch(Exception e){
//	          e.printStackTrace();
//	        }
//	      }

		@Override
		public void close() throws Exception 
		{
			if(con != null)
				con.close();
		}
}
