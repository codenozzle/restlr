package com.codenozzle.api.order;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderStatus {

	public static OrderStatus DRAFT = new OrderStatus(1, "Draft");
	public static OrderStatus IN_PROGRESS = new OrderStatus(2, "In Progress");
	public static OrderStatus SHIPPED = new OrderStatus(3, "Shipped");
	public static OrderStatus DELIVERED = new OrderStatus(4, "Delivered");
	public static OrderStatus COMPLETE = new OrderStatus(5, "Complete");
	public static OrderStatus ERROR = new OrderStatus(6, "Error");
	
	public static List<OrderStatus> orderStatuses = Arrays.asList(DRAFT, IN_PROGRESS, SHIPPED, DELIVERED, COMPLETE, ERROR);
	
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
	
	public static List<OrderStatus> getAll() {
		return orderStatuses;
	}

	public static OrderStatus get(Integer id) {
		return orderStatuses.get(id);
	}

	public static Integer size() {
		return orderStatuses.size();
	}
	
}
