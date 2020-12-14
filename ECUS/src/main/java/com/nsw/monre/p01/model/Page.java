package com.nsw.monre.p01.model;

public class Page {

	private String title;
	
	private String hoverTitle;
	
	private int value;
	
	private boolean active;
	
	String description;
	
	private String cssClass;
	
	

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getHoverTitle() {
		return hoverTitle;
	}

	public void setHoverTitle(String hoverTitle) {
		this.hoverTitle = hoverTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

	public Page(String title, String hoverTitle, int value, boolean active, String description) {
		super();
		this.title = title;
		this.hoverTitle = hoverTitle;
		this.value = value;
		this.active = active;
		this.description = description;
	}

	public Page() {
	}


	
	
	
}
