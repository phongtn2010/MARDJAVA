package com.vnsw.ws.p16.message;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p16.message.Goods;

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
* 05/12/2018 17:169:59
*
*/
@XmlRootElement(name = "Variety")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiApplication", "fiTechnicalDeclarations"})
public class DNDangKyHoSo {

	@XmlElement(name = "Application", required = true)
	private Application fiApplication;

	@XmlElementWrapper(name = "TechnicalDeclarationList")
	@XmlElement(name = "TechnicalDeclaration", required = true)
	private List<TechnicalDeclaration> fiTechnicalDeclarations;

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