/**
 * 
 */
package com.eatrest.user.management.service.dao.beans;

/**
 * @author Anurag Jain
 *
 */
public class User {
	private String username;
	private String password;
	private String email;
	private String contact;
	private String status;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", contact=" + contact
				+ ", status=" + status + "]";
	}

	public User(String username, String password, String email, String contact, String status) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.status = status;
	}

}
