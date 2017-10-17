package com.hotel.bean;

public class Employee {
	int empID;
	String jobtype;
	String fname;
	String lname;
	String email;
	String phone;
	String address;
	String city;
	String state;
	String zip;
	
	public Employee() {
		
	}

	public Employee(int empID, String jobtype, String fname, String lname,
			String email, String phone, String address, String city,
			String state, String zip) {
		super();
		this.empID = empID;
		this.jobtype = jobtype;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getJobType() {
		return jobtype;
	}

	public void setJobType(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String toString() {
		return  "<b>EmployeeID: </b>"+ empID + "<br> " + "<b>Job Type: </b>" + jobtype + "<br>" + "<b>First Name: </b>" + fname + "<br>" + "<b>Last Name: </b>" + lname + "<br>" + "<b>Email: </b>" + email + "<br>" + "<b>Address: </b>" + address + "<br>" +"<b>City: </b>"+ city + "<br>" +"<b>State: </b>" + state + "<br>" +"<b>Zip: </b>" + zip;
	}
}