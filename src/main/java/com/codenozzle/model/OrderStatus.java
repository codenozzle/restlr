package com.codenozzle.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum OrderStatus {

	DRAFT (1, "Draft"),
	IN_PROGRESS (2, "In Progress"),
	SHIPPED (3, "Shipped"),
	DELIVERED (4, "Delivered"),
	COMPLETE (5, "Complete"),
	ERROR (6, "Error");
	
	private int id;
	private String title;
	
	OrderStatus() {
		
	}
	
	OrderStatus(int id, String title) {
		this.setId(id);
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
