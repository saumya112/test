package com.rs.fer.bean;

public class Address {

	private int id;
	private String adressLane1;
	private String adressLane2;
	private String street;
	private String city;
	private String state;
	private String zipCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdressLane1() {
		return adressLane1;
	}

	public void setAdressLane1(String adressLane1) {
		this.adressLane1 = adressLane1;
	}

	public String getAdressLane2() {
		return adressLane2;
	}

	public void setAdressLane2(String adressLane2) {
		this.adressLane2 = adressLane2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
