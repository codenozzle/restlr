package com.codenozzle.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User extends Entity {

	private static final long serialVersionUID = 7611899059740125965L;
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Boolean active;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String emailAddress, Boolean active) {
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

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
