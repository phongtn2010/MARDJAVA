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
* @class BNNGuiChinhSuaGP
* Created by Nguyen Van Quang
* 05/12/2018 17:59:154
*
*/
@XmlRootElement(name = "GeneticLicenseEdit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiReason", "fiGeneticLicense"})
public class BNNGuiChinhSuaGP {

	public BNNGuiChinhSuaGP() {}

	@XmlElement(name = "Reason")
	private String fiReason;

	@XmlElement(name = "GeneticLicense", required = true)
	private GeneticLicense fiGeneticLicense;

	public String getFiReason() {
		return fiReason;
	}

	public void setFiReason(String fiReason) {
		this.fiReason = fiReason;
	}

	public GeneticLicense getFiGeneticLicense() {
		return fiGeneticLicense;
	}

	public void setFiGeneticLicense(GeneticLicense fiGeneticLicense) {
		this.fiGeneticLicense = fiGeneticLicense;
	}
}