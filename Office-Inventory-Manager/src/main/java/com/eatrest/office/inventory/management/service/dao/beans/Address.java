/**
 * 
 */
package com.eatrest.office.inventory.management.service.dao.beans;

/**
 * @author Anurag Jain
 *
 */
public class Address {
	private String addressName;
	private String building;
	private String floor;
	private String officeNumber;
	private String lineOne;
	private String lineTwo;
	private String city;
	private String state;
	private String locality;
	private String country;
	private String zipCode;
	private String lat;
	private String lang;

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getLineOne() {
		return lineOne;
	}

	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}

	public String getLineTwo() {
		return lineTwo;
	}

	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
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

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "Address [addressName=" + addressName + ", building=" + building + ", floor=" + floor + ", officeNumber="
				+ officeNumber + ", lineOne=" + lineOne + ", lineTwo=" + lineTwo + ", city=" + city + ", state=" + state
				+ ", locality=" + locality + ", country=" + country + ", zipCode=" + zipCode + ", lat=" + lat
				+ ", lang=" + lang + "]";
	}

	public Address(String addressName, String building, String floor, String officeNumber, String lineOne,
			String lineTwo, String city, String state, String locality, String country, String zipCode, String lat,
			String lang) {
		super();
		this.addressName = addressName;
		this.building = building;
		this.floor = floor;
		this.officeNumber = officeNumber;
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.city = city;
		this.state = state;
		this.locality = locality;
		this.country = country;
		this.zipCode = zipCode;
		this.lat = lat;
		this.lang = lang;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
}
