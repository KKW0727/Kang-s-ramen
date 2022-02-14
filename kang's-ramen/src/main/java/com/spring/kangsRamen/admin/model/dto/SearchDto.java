package com.spring.kangsRamen.admin.model.dto;

public class SearchDto {

	private String searchType;
	private String searchContent;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	@Override
	public String toString() {
		return "SearchDto [searchType=" + searchType + ", searchContent=" + searchContent + "]";
	}

}