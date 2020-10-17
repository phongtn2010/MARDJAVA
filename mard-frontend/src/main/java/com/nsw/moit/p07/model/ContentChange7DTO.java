package com.nsw.moit.p07.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ContentChange7DTO {

	@XmlElement(name = "Name")
	private String name;
	
	@XmlElement(name = "From")
	private String fromValue;
	
	@XmlElement(name = "To")
	private String toValue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFromValue() {
		return fromValue;
	}
	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}
	public String getToValue() {
		return toValue;
	}
	public void setToValue(String toValue) {
		this.toValue = toValue;
	}
	@Override
	public String toString() {
		return "MessageChange6DTO [name=" + name + ", fromValue=" + fromValue + ", toValue=" + toValue + "]";
	}
	public ContentChange7DTO(String name, String fromValue, String toValue) {
		super();
		this.name = name;
		this.fromValue = fromValue;
		this.toValue = toValue;
	}
	public ContentChange7DTO() {
	}
	
	
}
