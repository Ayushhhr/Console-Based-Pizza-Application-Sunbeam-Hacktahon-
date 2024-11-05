package com.hackathon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	private static final String USERNAME = "D2_86803_Ayush";
	private static final String PASSWORD = "manager";
	private static final String URL = "jdbc:mysql://localhost:3306/hackathon";

	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}
