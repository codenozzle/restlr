package com.codenozzle.model;

import java.time.LocalDateTime;

public abstract class Entity implements java.io.Serializable {

	private static final long serialVersionUID = -6621571718678881195L;
	
	private Integer id;
	private LocalDateTime createdOn;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setCreated(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public LocalDateTime getCreated() {
		return this.createdOn;
	}
	
}
