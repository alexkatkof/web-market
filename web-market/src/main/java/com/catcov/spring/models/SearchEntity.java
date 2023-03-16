package com.catcov.spring.models;

public class SearchEntity {
	
	private String searchTitle;
	
	public String getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}
	
	public SearchEntity() {}
	
	public SearchEntity(String searchTitle) {
		this.searchTitle = searchTitle;
	}

}
