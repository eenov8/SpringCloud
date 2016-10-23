/**
 * 
 */
package com.eatrest.ui.service.beans;

/**
 * @author Harman
 *
 */
public class LoginInputDTO {
	private String name;
	private String password;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginInputDTO [name=" + name + ", password=" + password + "]";
	}

	/**
	 * @param name
	 * @param password
	 */
	public LoginInputDTO(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	/**
	 * 
	 */
	public LoginInputDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
