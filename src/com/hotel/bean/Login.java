package com.hotel.bean;

public class Login {
	int userid;
	int guestid;
	String username;
	String pass;
	
	public Login(int userid, int guestid, String username, String pass) {
		super();
		this.userid = userid;
		this.guestid = guestid;
		this.username = username;
		this.pass = pass;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getGuestid() {
		return guestid;
	}

	public void setGuestid(int guestid) {
		this.guestid = guestid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}	
}
