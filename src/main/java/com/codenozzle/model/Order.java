package com.codenozzle.model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order extends Entity {
	
	private static final long serialVersionUID = -245124497967270964L;
	
	private Integer userId;
	private Integer shippingAddressId;
	private Integer billingAddressId;
	private OrderStatus orderStatus;
	private LocalDateTime dateOrdered;
	private boolean active;
	private User user;
	private Address shippingAddress;
	private Address billingAddress;
	
	public Order() {
		
	}
	
	public Order(User user, Address shippingAddress, Address billingAddress, OrderStatus orderStatus, LocalDateTime dateOrdered, boolean active) {
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

	public LocalDateTime getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(LocalDateTime dateOrdered) {
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
