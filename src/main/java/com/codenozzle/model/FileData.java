package com.codenozzle.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class FileData extends Entity {
	
	private static final long serialVersionUID = 7170649188425673798L;
	
	private byte[] imageInBytes;
	private String fileName;
	private String type;
	private long size;

	public FileData() {
		
	}
	
	public String getName() {
		return fileName;
	}
	
	public void setName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Long getSize() {
		return this.size;
	}
	
	public void setSize(Long size) {
		this.size = size;
	}

	public void setByteArray(byte[] imageInBytes) {
		this.imageInBytes = imageInBytes;
	}
	
	@XmlTransient
	public byte[] getByteArray() {
		return imageInBytes;
	}

}
