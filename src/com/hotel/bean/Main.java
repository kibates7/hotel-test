package com.hotel.bean;

//import com.hotel.dao.EmployeeDAO;
import com.hotel.dao.GuestDAO;
import com.hotel.dao.LoginDAO;

public class Main {
	private static final int guestID = 1;
	//private static final int empID = 0;

	public static void main(String[] args) throws Exception {
	    GuestDAO daoGuest = new GuestDAO();
		//daoGuest.getGuest(guestID);
		//EmployeeDAO daoEmp = new EmployeeDAO();
		//daoEmp.getEmp(empID);
		LoginDAO.validate("", "");
	}
}