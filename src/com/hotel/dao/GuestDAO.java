package com.hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.bean.Guest;

public class GuestDAO {
	public static final String URL = "jdbc:mysql://localhost:3306/hotelsystem";
	public static final String USER = "root";
	public static final String PASSWORD = "Dallasplano@123";
	public Connection con = null;
	
	public GuestDAO() {
	}
		public List<Guest> getGuest (String email) {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement ps = con.prepareStatement("select * from guest where email=?");
				
				ps.setString(1, email);
				
				ResultSet rs = ps.executeQuery();
				List<Guest> guestList = new ArrayList<Guest>();
			
				while(rs.next()) {
					Guest ob = new Guest();
					ob.setGuestID(rs.getInt(1));;
					ob.setRoomID(rs.getInt(2));
					ob.setNow(rs.getInt(3));
					ob.setFname(rs.getString(4));
					ob.setLname(rs.getString(5));
					ob.setEmail(rs.getString(6));
					ob.setPhone(rs.getString(7));
					ob.setAddress(rs.getString(8));
					ob.setCity(rs.getString(9));
					ob.setState(rs.getString(10));
					ob.setZipCode(rs.getString(11));
					ob.setCheckIn(rs.getDate(12));
					ob.setCheckOut(rs.getDate(13));
					ob.setRoomtype(rs.getString(14));
					guestList.add(ob);
				}
				if(guestList.size()>0)
					return guestList;
			}
			catch (SQLException | ClassNotFoundException e) {	
				e.printStackTrace();
			} 
			return null;
		
		}

public List<Guest> getGuest1 (String phone) {
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection)DriverManager.getConnection(URL, USER, PASSWORD);
		PreparedStatement ps = con.prepareStatement("select * from guest where phone=?");
		
		ps.setString(1, phone);
		
		ResultSet rs = ps.executeQuery();
		List<Guest> guestList = new ArrayList<Guest>();
	
		while(rs.next()) {
			Guest ob = new Guest();
			ob.setGuestID(rs.getInt(1));;
			ob.setRoomID(rs.getInt(2));
			ob.setNow(rs.getInt(3));
			ob.setFname(rs.getString(4));
			ob.setLname(rs.getString(5));
			ob.setEmail(rs.getString(6));
			ob.setPhone(rs.getString(7));
			ob.setAddress(rs.getString(8));
			ob.setCity(rs.getString(9));
			ob.setState(rs.getString(10));
			ob.setZipCode(rs.getString(11));
			ob.setCheckIn(rs.getDate(12));
			ob.setCheckOut(rs.getDate(13));
			ob.setRoomtype(rs.getString(14));
			guestList.add(ob);
		}
		if(guestList.size()>0)
			return guestList;
	}
	catch (SQLException | ClassNotFoundException e) {	
		e.printStackTrace();
	} 
	return null;

}
}
		
		//end database constructor definition

/**
public void savePerson(Guest person)
{
	try
	{
		Statement statement1 = con.createStatement();
	 
		String sqlBooking = "Insert into guest (firstname, lastname, phone, email, address, city, state, zip, check_in, check_out) values ('"+Guest.getFname()+"','"+Guest.getLname()+"','"+Guest.getPhone()+"','"+Guest.getEmail()+"','"+Guest.getAddress()+"','"+Guest.getCity()+"','"+Guest.getState()+"','"+Guest.getZipCode()+"','"+Guest.getCheckIn()+"','"+person.getCheckOut()+"');";
		
		statement1.addBatch(sqlBooking);
		statement1.executeBatch();  // Need to run the first batch SQL statement
		statement1.clearBatch(); // Now clear the batch after the run
		
		// Now fetch the bookingID assigned on the first insert to be used in the child tables
		String sqlID = "SELECT guestid from guest where firstname = '"+Guest.getFname()+"' and lastname = '"+Guest.getLname()+"';";
		ResultSet rs = statement1.executeQuery(sqlID);
		rs.next();
		int id = rs.getInt("guestid");

		Room myroom = person.getRoom();
		String sqlroom = "Insert into room (guestid, room_type, rate, res_num) values ("+id+",'"+myroom.toString()+"','"+myroom.getRate()+"','"+Room.getAvailability()+"');";
		statement1.addBatch(sqlroom);

		statement1.executeBatch();

		statement1.close();
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
}

public Guest updatePerson(Guest person)
{
	try
	{
		
		Statement statement1 = con.createStatement();

		String sqlPerson = "UPDATE guest SET address = '"+Guest.getAddress()+"', city = '"+Guest.getCity()+"', state = '"+Guest.getState()+"', zip = '"+Guest.getZipCode()+"' where guestid = (SELECT guestid from guest where firstname = '"+Guest.getFname()+"' AND lastname = '"+Guest.getLname()+"')";
		statement1.addBatch(sqlPerson);

		statement1.executeBatch();
		//JOptionPane.showMessageDialog(null, "Record(s) Updated");
		statement1.close();

		
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	return person;
}
} **/