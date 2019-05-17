package com.rs.fer.bean;

public class User {

	private int id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String mobilenumber;
	private String email;
	private String userName;
	private String password;
	
	
	private Address address;

	public Address getAddress() {
		return address;
	}
	

	public void setId(int id) {
		this.id = id;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void FirstName(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getMiddlename() {
		return middlename;
	}


	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
