package com.nsw.moit.p06.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "KQXL")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContentChangeRoot6DTO {

	@XmlElement(name = "Name")
	private String name;
	
	@XmlElementWrapper(name = "ContentChangeList")
	@XmlElement(name = "Content")
	private List<ContentChange6DTO> contentChange6DTOs = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ContentChange6DTO> getContentChange6DTOs() {
		return contentChange6DTOs;
	}
	public void setContentChange6DTOs(List<ContentChange6DTO> contentChange6DTOs) {
		this.contentChange6DTOs = contentChange6DTOs;
	}
	@Override
	public String toString() {
		return "ContentChangeRoot6DTO [name=" + name + ", contentChange6DTOs=" + contentChange6DTOs + "]";
	}
	
	
}
