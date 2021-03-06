package com.codenozzle.api.address;

import javax.xml.bind.annotation.XmlRootElement;

import com.codenozzle.core.Entity;

@XmlRootElement
public class Address extends Entity {

	private static final long serialVersionUID = -3467994633316920149L;
	
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	
	public Address() {
		
	}
	
	public Address(String name, String address1, String address2, String city, String state, String zip) {
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
