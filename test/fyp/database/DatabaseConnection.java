/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyp.database;
/**
 *
 * @author Lim
 */
import java.sql.*;
import java.util.*;

public class DatabaseConnection {
    private Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	//Date dummyDate = new Date(0); //date if not found reply/thread for given ID :1 Jan 1970,7.30am
	
	public DatabaseConnection()
	{
		connect();
	}
	
	public void connect()
	{
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/fyp";
		String username = "root";
		String password = "";
		try
		{
			Class.forName(driverName);
			conn = DriverManager.getConnection(url,username, password);
			System.out.println("Database is connected..");	
		}
		catch(Exception e)
		{
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}
	
	public void disconnect()
	{
		if (rs != null) 
		{
			try 
			{
				rs.close();
			} 
			catch (SQLException e){}
		}
		if (stm != null) 
		{
			try 
			{
				stm.close();
			} 
			catch (SQLException e){}
		}
		if (conn != null) 
		{
			try 
			{
				conn.close();
			}
			catch (SQLException e){}
		}
	}
        
        public int sqlToGetInt(String sql, String columnName)
	{
		int result = -1;
		try
		{
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			if(rs.next()) 
			{ 
				result = rs.getInt(columnName); 
			}
		}
		catch(Exception e)
		{
			System.out.print("Error detected: " + e);
		}	
		return result;
	}
	
	public String sqlToGetString(String sql, String columnName)
	{
		String result = "NOTFOUND";
		try
		{
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			if(rs.next()) 
			{ 
				result = rs.getString(columnName); 
			}
		}
		catch(Exception e)
		{
			System.out.print("Error detected: " + e);
		}	
		return result;
	}
        
        public boolean sqlToInsertUpdateDelete(String sql)
	{
		boolean returnStatus = true;
		try
		{
			stm = conn.createStatement();
			stm.executeUpdate(sql);
		}
		catch(Exception e)
		{
			System.out.print("Error detected: " + e);
			returnStatus = false;
		}	
		return returnStatus;
	}
}
