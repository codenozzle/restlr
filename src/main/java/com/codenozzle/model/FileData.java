package com.codenozzle.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class FileData extends Entity {
	
	private static final long serialVersionUID = 7170649188425673798L;
	
	private byte[] imageInBytes;
	private byte[] thumbnailInByte;
	private String fileName;
	private String type;
	private Integer fileSize;
	private Integer thumbnailFileSize;

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
	
	public Integer getFileSize() {
		return this.fileSize;
	}
	
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public void setImageData(byte[] imageInBytes) {
		this.imageInBytes = imageInBytes;
	}
	
	@XmlTransient
	public byte[] getImageData() {
		return imageInBytes;
	}

	public void setThumbnailData(byte[] thumbnailInByte) {
		this.thumbnailInByte = thumbnailInByte;
	}
	
	@XmlTransient
	public byte[] getThumbnailData() {
		return thumbnailInByte;
	}

	public void setThumbnailFileSize(Integer thumbnailFileSize) {
		this.thumbnailFileSize = thumbnailFileSize;
	}
	
	public Integer getThumbnailFileSize() {
		return this.thumbnailFileSize;
	}

}
