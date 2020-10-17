package com.vnsw.ws.p15.message;

import com.vnsw.ws.annotations.DateSerialization;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/***
*
*
* @Model
* @class DNDangKyHoSo
* Created by Nguyen Van Quang
* 05/12/2018 17:159:59
*
*/
@XmlRootElement(name = "GeneticImport")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiApplication", "fiAttachment"})
public class DNDangKyHoSo {


	@XmlElement(name = "Application", required = true)
	private Application fiApplication;


	@XmlElementWrapper(name = "AttachFileList")
	@XmlElement(name = "AttachFile", required = true)
	private List<Attachment> fiAttachment;

	public Application getFiApplication() {
		return fiApplication;
	}

	public void setFiApplication(Application fiApplication) {
		this.fiApplication = fiApplication;
	}

	public List<Attachment> getFiAttachment() {
		return fiAttachment;
	}

	public void setFiAttachment(List<Attachment> fiAttachment) {
		this.fiAttachment = fiAttachment;
	}
}