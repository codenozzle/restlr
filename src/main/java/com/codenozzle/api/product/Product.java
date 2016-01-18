package com.codenozzle.api.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

import com.codenozzle.core.Entity;

@XmlRootElement
@ApiModel(value="DifferentModel", description="Sample model for the documentation")
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
	
	@ApiModelProperty(value = "Product SKU", required = true)
	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	@ApiModelProperty(value = "Product name", required = true)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@ApiModelProperty(value = "Product description", required = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ApiModelProperty(value = "Product price", required = true)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@ApiModelProperty(value = "Product active status", required = true)
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	@ApiModelProperty(value = "Date created", readOnly = true)
	public LocalDateTime getCreated() {
		return this.createdOn;
	}
	
	public void setCreated(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

}
