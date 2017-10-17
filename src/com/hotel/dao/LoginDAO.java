package com.hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*import com.hotel.bean.Employee;
import com.hotel.bean.Login;*/





public class LoginDAO {
	public static final String URL = "jdbc:mysql://localhost:3306/hotelsystem";
	public static final String USER = "root";
	public static final String PASSWORD = "Dallasplano@123";
	public static String us = "";
	public static String pa = "";
	public static boolean validate(String u,String p){  
		boolean status=false;
		ResultSet rs = null;
		 Connection con = null;
	    PreparedStatement ps = null;
		String query = "select email,pass from login where email = ? AND pass = ?";
			try{  
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection)DriverManager.getConnection(URL, USER, PASSWORD);
		      
				ps = con.prepareStatement(query);  				
				
				ps.setString(1,u);  
				ps.setString(2,p); 
				rs=ps.executeQuery();
				status=rs.next();  		      
			}
	
			catch(Exception e){
				
				System.out.println("ERROR: " + e);
			}   finally {
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (ps != null) {
	                try {
	                    ps.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
			}
			return status;  
		}   
	}
