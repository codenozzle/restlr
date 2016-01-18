package com.codenozzle.core;

import io.swagger.annotations.ApiModelProperty;


public abstract class Entity implements java.io.Serializable {

	private static final long serialVersionUID = -6621571718678881195L;
	
	private Integer id;
	
	@ApiModelProperty(value = "Product name", readOnly = true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
