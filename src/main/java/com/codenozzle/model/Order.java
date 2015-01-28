package com.codenozzle.model;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order extends Entity {

	private Integer userId;
	private Integer shippingAddressId;
	private Integer billingAddressId;
	private OrderStatus orderStatus;
	private Timestamp dateOrdered;
	private boolean active;
	
	private User user;
	private Address shippingAddress;
	private Address billingAddress;
	
	public Order() {
		
	}
	
	public Order(User user, Address shippingAddress, Address billingAddress, OrderStatus orderStatus, Timestamp dateOrdered, boolean active) {
		this.user = user;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress; 
		this.orderStatus = orderStatus;
		this.dateOrdered = dateOrdered;
		this.active = active;
	}

	public Order(Integer userId, Integer shippingAddressId, Integer billingAddressId) {
		this.setUserId(userId);
		this.setShippingAddressId(shippingAddressId);
		this.setBillingAddressId(billingAddressId);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Timestamp dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(Integer shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public Integer getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(Integer billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	
}
