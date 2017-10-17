package com.hotel.bean;

public class Room {
	int roomID;
	static String roomType;
	 int rate;
	static int available;
	
	public Room(int roomID, String roomType, int rate, int available) {
		super();
		this.roomID = roomID;
		Room.roomType = roomType;
		this.rate = rate;
		Room.available = available;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public static String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		Room.roomType = roomType;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	 public static int getAvailablity() {
		return available;
	}
	public void setAvailable(int available) {
		Room.available = available;
	}
	
	@Override
	public String toString() {
		return roomType;
	}
	
}
