package com.catcov.spring.models;

import org.springframework.web.multipart.MultipartFile;

public class ImageAndDesc {

	private int id;
	private String description;
	private MultipartFile image;
	
	public ImageAndDesc() {}
	public ImageAndDesc(String description, MultipartFile image) {
		this.description = description;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
}
