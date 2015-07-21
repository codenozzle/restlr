package com.codenozzle.api.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.collections4.CollectionUtils;

import com.codenozzle.api.address.Address;
import com.codenozzle.api.user.User;
import com.codenozzle.core.Entity;

@XmlRootElement
public class Order extends Entity {
	
	private static final long serialVersionUID = -245124497967270964L;
	public static final BigDecimal taxRate = BigDecimal.valueOf(0.05);
	
	private User user;
	private String orderNumber;
	private OrderStatus orderStatus;
	private LocalDateTime createdOn;
	private Boolean active;
	
	private String shippingName;
	private Address shippingAddress;
	private String billingName;
	private Address billingAddress;
	
	private BigDecimal taxes;
	private BigDecimal shipping;
	private BigDecimal subTotal;
	private BigDecimal grandTotal;
	
	private Collection<OrderLineItem> lineItems;
	
	public Order() {
		
	}
	
	public Order(User user, Address shippingAddress, Address billingAddress, OrderStatus orderStatus, LocalDateTime dateOrdered) {
		this.user = user;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress; 
		this.orderStatus = orderStatus;
		this.active = Boolean.TRUE;
		this.createdOn = LocalDateTime.now();
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public void setCreated(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public LocalDateTime getCreated() {
		return this.createdOn;
	}

	public Collection<OrderLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Collection<OrderLineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public BigDecimal getTaxes() {
		return taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	public BigDecimal getShipping() {
		return shipping;
	}

	public void setShipping(BigDecimal shipping) {
		this.shipping = shipping;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public void calculateTotals() {
		subTotal = BigDecimal.ZERO;
		if (CollectionUtils.isNotEmpty(lineItems)) {
			for (OrderLineItem lineItem : this.lineItems) {
				subTotal = subTotal.add(lineItem.getSubTotal());
			}
		}
		shipping = BigDecimal.valueOf(9.99);
		taxes = subTotal.multiply(taxRate);
		grandTotal = taxes.add(shipping).add(subTotal);
	}
	
}
