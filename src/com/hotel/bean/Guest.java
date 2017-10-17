package com.hotel.bean;

import java.util.Date;

public class Guest {
	int guestID;
	int roomID;
	
	static String fname;
	static String lname;
	static String phone;
	static String email;
	static String address;
	static String city;
	static String state;
	static String zipCode;
	static Date checkIn;
	Date checkOut;
	static String roomtype;
	static int now;
	private Room room;
	
	public Guest() {
		
	}
	
	public Guest(int guestID, int roomID, int now, String fname,
			String lname,  String email, String phone, String address, String city, String state, String zipCode, Date checkIn, Date checkOut, String roomtype) {
		super();
		this.guestID = guestID;
		this.roomID = roomID;
		this.now = now;
		Guest.fname = fname;
		Guest.lname = lname;
		Guest.phone = phone;
		Guest.email = email;
		Guest.phone = phone;
		Guest.address = address;
		Guest.city = city;
		Guest.state = state;
		Guest.zipCode = zipCode;
		Guest.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomtype = roomtype;
		
	
	}

	public static int getNow() {
		return now;
	}

	public void setNow(int now) {
		Guest.now = now;
	}

	public static String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		Guest.roomtype = roomtype;
	}

	public int getGuestID() {
		return guestID;
	}

	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	

	public static String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		Guest.fname = fname;
	}

	public static String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		Guest.lname = lname;
	}
	
	public static String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		Guest.phone = phone;
	}
	
	public static String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		Guest.email = email;
	}

	public static String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		Guest.address = address;
	}
	
	public static String getCity() {
		return city;
	}

	public void setCity(String city) {
		Guest.city = city;
	}
	
	public static String getState() {
		return state;
	}

	public void setState(String state) {
		Guest.state = state;
	}

	public static String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		Guest.zipCode = zipCode;
	}
	
	public static Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		Guest.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public String toString() {
		return "<center><title>Customer Information</title><h1>Customer Information</h1><br><br><b>GuestID: </b>"+guestID + "<br><br> " + "<b>Room Number: </b>" + roomID + "<br><br>" + "<b>Now: </b>" + now + "<br><br>" + "<b>First Name: </b>" + fname + "<br><br>" + "<b>Last Name: </b>" + lname + "<br><br>" + "<b>Email: </b>" + email + "<br><br> " +"<b>Phone: </b>" + phone +"<br>" +"<br>" + "<b>Address: </b>" + address + "<br><br>" +"<b>City: </b>"+ city + "<br><br>" +"<b>State: </b>" + state + "<br><br>" +"<b>Zip: </b>" + zipCode + "<br><br>" +"<b>Check-in Date:  </b>" + checkIn + "<br><br>" +"<b>Check-out Date: </b>" + checkOut + "<br></center>"; 
	}
}
