package com.codenozzle.api.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

import com.codenozzle.core.Entity;

@XmlRootElement
public class Product extends Entity {

	private static final long serialVersionUID = -8200503315550831684L;
	
	private String productSku;
	private String productName;
	private String description;
	private BigDecimal price;
	private Boolean active;
	private LocalDateTime createdOn;
	
	public Product() {
		
	}
	
	public Product(String productSku, String productName, String description, BigDecimal price, Boolean active) {
		this.productSku = productSku;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.active = active;
		this.createdOn = LocalDateTime.now();
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

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public void setCreated(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public LocalDateTime getCreated() {
		return this.createdOn;
	}

}
