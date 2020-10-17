package com.vnsw.ws.p14.message;

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
@XmlRootElement(name = "MedicinePPRequestEdit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiRequestDate", "fiReason", "fiApplicationNo", "fiNameOfRegistration", "fiAddressOfRegistration", "fiPhone", "fiEmail", "fiFax", "fiTaxCode", "fiGoods", "fiPurposes", "fiPurposeOtherNote", "fiToxicityUsed", "fiTestingUsed", "fiGates", "fiImportTimeFrom", "fiImportTimeTo", "fiAttachment"})
public class DNYeuCauSuaHS {

	public DNYeuCauSuaHS() {}

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "RequestDate", required = true)
	private Date fiRequestDate;

	@XmlElement(name = "Reason", required = true)
	private String fiReason;

	@XmlElement(name = "ApplicationNo", required = true)
	private String fiApplicationNo;

	@XmlElement(name = "NameOfRegistration", required = true)
	private String fiNameOfRegistration;

	@XmlElement(name = "AddressOfRegistration", required = true)
	private String fiAddressOfRegistration;

	@XmlElement(name = "Phone")
	private String fiPhone;

	@XmlElement(name = "Email")
	private String fiEmail;

	@XmlElement(name = "Fax")
	private String fiFax;

	@XmlElement(name = "TaxCode", required = true)
	private String fiTaxCode;

	@XmlElementWrapper(name = "GoodsList")
	@XmlElement(name = "Goods", required = true)
	private List<Goods> fiGoods;

	@XmlElement(name = "Purposes", required = true)
	private String fiPurposes;

	@XmlElement(name = "PurposeOtherNote")
	private String fiPurposeOtherNote;

	@XmlElement(name = "ToxicityUsed")
	private String fiToxicityUsed;

	@XmlElement(name = "TestingUsed")
	private String fiTestingUsed;

	@XmlElement(name = "Gates", required = true)
	private String fiGates;

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "ImportTimeFrom")
	private Date fiImportTimeFrom;

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "ImportTimeTo", required = true)
	private Date fiImportTimeTo;

	@XmlElementWrapper(name = "AttachmentList")
	@XmlElement(name = "Attachment", required = true)
	private List<Attachment> fiAttachment;

	public Date getFiRequestDate() {
		return this.fiRequestDate;
	}

	public void setFiRequestDate(Date fiRequestDate) {
		this.fiRequestDate = fiRequestDate;
	}

	public String getFiReason() {
		return this.fiReason;
	}

	public void setFiReason(String fiReason) {
		this.fiReason = fiReason;
	}

	public String getFiApplicationNo() {
		return this.fiApplicationNo;
	}

	public void setFiApplicationNo(String fiApplicationNo) {
		this.fiApplicationNo = fiApplicationNo;
	}

	public String getFiNameOfRegistration() {
		return this.fiNameOfRegistration;
	}

	public void setFiNameOfRegistration(String fiNameOfRegistration) {
		this.fiNameOfRegistration = fiNameOfRegistration;
	}

	public String getFiAddressOfRegistration() {
		return this.fiAddressOfRegistration;
	}

	public void setFiAddressOfRegistration(String fiAddressOfRegistration) {
		this.fiAddressOfRegistration = fiAddressOfRegistration;
	}

	public String getFiPhone() {
		return this.fiPhone;
	}

	public void setFiPhone(String fiPhone) {
		this.fiPhone = fiPhone;
	}

	public String getFiEmail() {
		return this.fiEmail;
	}

	public void setFiEmail(String fiEmail) {
		this.fiEmail = fiEmail;
	}

	public String getFiFax() {
		return this.fiFax;
	}

	public void setFiFax(String fiFax) {
		this.fiFax = fiFax;
	}

	public String getFiTaxCode() {
		return this.fiTaxCode;
	}

	public void setFiTaxCode(String fiTaxCode) {
		this.fiTaxCode = fiTaxCode;
	}

	public List<Goods> getFiGoods() {
		return this.fiGoods;
	}

	public void setFiGoods(List<Goods> fiGoods) {
		this.fiGoods = fiGoods;
	}

	public String getFiPurposes() {
		return this.fiPurposes;
	}

	public void setFiPurposes(String fiPurposes) {
		this.fiPurposes = fiPurposes;
	}

	public String getFiPurposeOtherNote() {
		return this.fiPurposeOtherNote;
	}

	public void setFiPurposeOtherNote(String fiPurposeOtherNote) {
		this.fiPurposeOtherNote = fiPurposeOtherNote;
	}

	public String getFiToxicityUsed() {
		return this.fiToxicityUsed;
	}

	public void setFiToxicityUsed(String fiToxicityUsed) {
		this.fiToxicityUsed = fiToxicityUsed;
	}

	public String getFiTestingUsed() {
		return this.fiTestingUsed;
	}

	public void setFiTestingUsed(String fiTestingUsed) {
		this.fiTestingUsed = fiTestingUsed;
	}

	public String getFiGates() {
		return this.fiGates;
	}

	public void setFiGates(String fiGates) {
		this.fiGates = fiGates;
	}

	public Date getFiImportTimeFrom() {
		return this.fiImportTimeFrom;
	}

	public void setFiImportTimeFrom(Date fiImportTimeFrom) {
		this.fiImportTimeFrom = fiImportTimeFrom;
	}

	public Date getFiImportTimeTo() {
		return this.fiImportTimeTo;
	}

	public void setFiImportTimeTo(Date fiImportTimeTo) {
		this.fiImportTimeTo = fiImportTimeTo;
	}

	public List<Attachment> getFiAttachment() {
		return this.fiAttachment;
	}

	public void setFiAttachment(List<Attachment> fiAttachment) {
		this.fiAttachment = fiAttachment;
	}

	@Override
	public String toString() {
		return "DNYeuCauSuaHS [" +
				"fiRequestDate=" + fiRequestDate + "," + 
				"fiReason=" + fiReason + "," + 
				"fiApplicationNo=" + fiApplicationNo + "," + 
				"fiNameOfRegistration=" + fiNameOfRegistration + "," + 
				"fiAddressOfRegistration=" + fiAddressOfRegistration + "," + 
				"fiPhone=" + fiPhone + "," + 
				"fiEmail=" + fiEmail + "," + 
				"fiFax=" + fiFax + "," + 
				"fiTaxCode=" + fiTaxCode + "," + 
				"fiGoods=" + fiGoods + "," + 
				"fiPurposes=" + fiPurposes + "," + 
				"fiPurposeOtherNote=" + fiPurposeOtherNote + "," + 
				"fiToxicityUsed=" + fiToxicityUsed + "," + 
				"fiTestingUsed=" + fiTestingUsed + "," + 
				"fiGates=" + fiGates + "," + 
				"fiImportTimeFrom=" + fiImportTimeFrom + "," + 
				"fiImportTimeTo=" + fiImportTimeTo + "," + 
				"fiAttachment=" + fiAttachment + "]";
	}
}