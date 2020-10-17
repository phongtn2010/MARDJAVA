package com.vnsw.ws.p16.message;

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
* @class DNYeuCauSuaHS
* Created by Nguyen Van Quang
* 05/12/2018 17:45:19
*
*/
@XmlRootElement(name = "VarietyRequestEdit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiRequestDate", "fiReason", "fiApplication", "fiTechnicalDeclarations"})
public class  DNYeuCauSuaHS {

	public DNYeuCauSuaHS() {}

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "RequestDate", required = true)
	private Date fiRequestDate;

	@XmlElement(name = "Reason", required = true)
	private String fiReason;

	@XmlElement(name = "Application", required = true)
	private Application fiApplication;

	@XmlElementWrapper(name = "TechnicalDeclarationList")
	@XmlElement(name = "TechnicalDeclaration", required = true)
	private List<TechnicalDeclaration> fiTechnicalDeclarations;

	public Date getFiRequestDate() {
		return fiRequestDate;
	}

	public void setFiRequestDate(Date fiRequestDate) {
		this.fiRequestDate = fiRequestDate;
	}

	public String getFiReason() {
		return fiReason;
	}

	public void setFiReason(String fiReason) {
		this.fiReason = fiReason;
	}

	public Application getFiApplication() {
		return fiApplication;
	}

	public void setFiApplication(Application fiApplication) {
		this.fiApplication = fiApplication;
	}

	public List<TechnicalDeclaration> getFiTechnicalDeclarations() {
		return fiTechnicalDeclarations;
	}

	public void setFiTechnicalDeclarations(List<TechnicalDeclaration> fiTechnicalDeclarations) {
		this.fiTechnicalDeclarations = fiTechnicalDeclarations;
	}
}