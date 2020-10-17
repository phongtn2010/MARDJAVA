package com.vnsw.ws.p15.message;

import com.vnsw.ws.annotations.DateSerialization;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/***
*
*
* @Model
* @class DNYeuCauRutHS
* Created by Nguyen Van Quang
* 05/12/2018 17:50:50
*
*/
@XmlRootElement(name = "GeneticCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiRequestDate"})
public class DNYeuCauRutHS {

	public DNYeuCauRutHS() {}

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "RequestDate", required = true)
	private Date fiRequestDate;

	public Date getFiRequestDate() {
		return this.fiRequestDate;
	}

	public void setFiRequestDate(Date fiRequestDate) {
		this.fiRequestDate = fiRequestDate;
	}


	@Override
	public String toString() {
		return "DNYeuCauRutHS [" +
				"fiRequestDate=" + fiRequestDate +"]";
	}
}