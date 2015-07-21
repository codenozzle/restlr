package com.codenozzle.api.order;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.codenozzle.api.product.Product;
import com.codenozzle.core.Entity;

@XmlRootElement
public class OrderLineItem extends Entity {

	private static final long serialVersionUID = -9175620806291601816L;
	
	private Product product;
	private Integer quantity;
	private BigDecimal subTotal;
	
	public OrderLineItem() {
		
	}
	
	public OrderLineItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		this.subTotal = product.getPrice().multiply(BigDecimal.valueOf(quantity.doubleValue()));
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

}
