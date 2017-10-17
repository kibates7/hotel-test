package com.hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.bean.Employee;
import com.hotel.bean.Guest;

public class EmployeeDAO {
	private Guest tempPerson;  // Temp buffer for Search
	
	public static final String URL = "jdbc:mysql://localhost:3306/hotelsystem";
	public static final String USER = "root";
	public static final String PASSWORD = "Dallasplano@123";
	public Connection con = null;
	
	public List<Employee> getEmp (String email) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement ps = con.prepareStatement("select * from employee where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			List<Employee> empList = new ArrayList<Employee>();
		
			while(rs.next()) {
				Employee ob = new Employee();
				ob.setEmpID(rs.getInt(1));
				ob.setJobType(rs.getString(2));
				ob.setFname(rs.getString(3));
				ob.setLname(rs.getString(4));
				ob.setEmail(rs.getString(5));
				ob.setPhone(rs.getString(6));
				ob.setAddress(rs.getString(7));
				ob.setCity(rs.getString(8));
				ob.setState(rs.getString(9));
				ob.setZip(rs.getString(10));
				empList.add(ob);
			}
			if(empList.size()>0)
				return empList;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}
}
	
	//end database constructor definition
	
/**	 //Function to perform Search
    public Guest searchPerson(String firstName, String lastName)
    {
        Guest person = null;
        
        Date checkIn;
        Date checkOut;
        String phone;
        String email;
        String address = "";
        String city = "";
        String state = "";
        String zipCode;
        int id;
        int roomID;
        String room;
       
        //SimpleDateFormat checkIn = new SimpleDateFormat("dd-MM-yyyy");
        //SimpleDateFormat checkOut = new SimpleDateFormat("dd-MM-yyyy");
        
        String sql1 = "SELECT * FROM " +
        				"guest " +
        				"INNER JOIN room on guest.guestid = room.guestid " +
        				"where firstname = '"+firstName+"' AND lastname = '"+lastName+"'";
   
      
            try
            {
            	// Create a prepared statement
            	Statement s = con.createStatement();

            	ResultSet rs = s.executeQuery(sql1);
            	rs.next();	// Only expecting one row

            	id = rs.getInt("guestid");
            	
            	roomID = rs.getInt("roomid");
            	firstName = rs.getString("firstname");
            	lastName = rs.getString("lastname");
            	phone = rs.getString("phone");
            	email = rs.getString("email");
            	checkIn = rs.getDate("check_in");
            	checkOut = rs.getDate("check_out");
            	address = rs.getString("address");
            	city = rs.getString("city");
            	state = rs.getString("state");
            	zipCode = rs.getString("zip");
            	
            	// Create a room object
            	//Room myRoom = new Room(rs.getInt("roomid"), rs.getString("room_type"),rs.getInt("rate"));
            	//Create a Guest object
            	//person = new Guest(id, roomID, email, firstName, lastName, phone, address, city, state, zipCode, checkIn, checkOut, myRoom);
            			
            	tempPerson = person;
            }
	
            catch(Exception e)
            {
            	System.out.println(e);
            }

       return person;
       } 
            
    public Guest getGuest()
    {
    	return tempPerson;
    }
}
**/
