package com.codenozzle.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User extends Entity {

	private String firstName;
	private String lastName;
	private String emailAddress;
	private boolean active;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String emailAddress, boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
