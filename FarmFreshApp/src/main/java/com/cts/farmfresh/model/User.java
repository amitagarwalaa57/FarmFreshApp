package com.cts.farmfresh.model;

public class User {
	private int userId;
	private String fname;
	private String lname;
	private String email;
	private String pword;
	private String mobNo;
	private String address;
	
	public int getUserId() {  
	    return userId;  
	}  
	public void setUserId(int id) {  
	    this.userId = id;  
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
	public String getPword() {
		return pword;
	}
	public void setPword(String password) {
		this.pword = password;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mn) {
		this.mobNo = mn;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String add) {
		this.address = add;
	}
	
	
	public User()
	{
		
	}
	public User(String fname, String lname, String email, String pword, String mobNo , String address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pword = pword;
		this.mobNo = mobNo;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + pword + ", Mobile Number=" + mobNo + ", Address=" + address + "]";
	}
	

}
