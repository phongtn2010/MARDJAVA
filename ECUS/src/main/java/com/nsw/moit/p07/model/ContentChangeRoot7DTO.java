package com.nsw.moit.p07.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "KQXL")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContentChangeRoot7DTO {

	@XmlElement(name = "Name")
	private String name;
	
	@XmlElementWrapper(name = "ContentChangeList")
	@XmlElement(name = "Content")
	private List<ContentChange7DTO> contentChange7DTOs = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ContentChange7DTO> getContentChange7DTOs() {
		return contentChange7DTOs;
	}
	public void setContentChange7DTOs(List<ContentChange7DTO> contentChange7DTOs) {
		this.contentChange7DTOs = contentChange7DTOs;
	}
	@Override
	public String toString() {
		return "ContentChangeRoot7DTO [name=" + name + ", contentChange7DTOs=" + contentChange7DTOs + "]";
	}
	
	
}
