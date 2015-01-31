package com.codenozzle.model;

public abstract class Entity implements java.io.Serializable {

	private static final long serialVersionUID = -6621571718678881195L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
