package com.eatrest.office.inventory.management.service.beans;

public class FullOfficeCreationInputBean {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginInputBean [username=" + username + ", password=" + password + "]";
	}

	public FullOfficeCreationInputBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public FullOfficeCreationInputBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
