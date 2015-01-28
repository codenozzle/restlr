package com.codenozzle.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product extends Entity  {

	private String productSku;
	private String productName;
	private String description;
	private BigDecimal price;
	private boolean active;
	
	public Product() {
		
	}
	
	public Product(String productSku, String productName, String description, BigDecimal price, boolean active) {
		this.productSku = productSku;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.active = active;
	}
	
	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
