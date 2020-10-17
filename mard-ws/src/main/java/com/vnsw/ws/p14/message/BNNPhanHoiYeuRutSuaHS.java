package com.vnsw.ws.p14.message;

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
* @class BNNPhanHoiYeuRutSuaHS
* Created by Nguyen Van Quang
* 05/12/2018 17:52:50
*
*/
@XmlRootElement(name = "MedicinePPRequestCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiReason", "fiSignConfirmDate", "fiDepartment", "fiCreaterName"})
public class BNNPhanHoiYeuRutSuaHS {

	public BNNPhanHoiYeuRutSuaHS() {}

	@XmlElement(name = "Reason")
	private String fiReason;

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "SignConfirmDate", required = true)
	private Date fiSignConfirmDate;

	@XmlElement(name = "Department")
	private String fiDepartment;

	@XmlElement(name = "CreaterName")
	private String fiCreaterName;

	public String getFiReason() {
		return this.fiReason;
	}

	public void setFiReason(String fiReason) {
		this.fiReason = fiReason;
	}

	public Date getFiSignConfirmDate() {
		return this.fiSignConfirmDate;
	}

	public void setFiSignConfirmDate(Date fiSignConfirmDate) {
		this.fiSignConfirmDate = fiSignConfirmDate;
	}

	public String getFiDepartment() {
		return this.fiDepartment;
	}

	public void setFiDepartment(String fiDepartment) {
		this.fiDepartment = fiDepartment;
	}

	public String getFiCreaterName() {
		return this.fiCreaterName;
	}

	public void setFiCreaterName(String fiCreaterName) {
		this.fiCreaterName = fiCreaterName;
	}

	@Override
	public String toString() {
		return "BNNPhanHoiYeuRutSuaHS [" +
				"fiReason=" + fiReason + "," + 
				"fiSignConfirmDate=" + fiSignConfirmDate + "," + 
				"fiDepartment=" + fiDepartment + "," + 
				"fiCreaterName=" + fiCreaterName + "]";
	}
}