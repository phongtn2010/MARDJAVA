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
* @class BNNGuiChinhSuaGP
* Created by Nguyen Van Quang
* 05/12/2018 17:59:144
*
*/
@XmlRootElement(name = "MedicinePPLicenseEdit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiReason", "fiSignConfirmDate", "fiMedicinePPLicense", "fiDispatchNo", "fiOrganization", "fiAddress", "fiApplicationNo", "fiSignDate", "fiGoods", "fiPurposes", "fiPurposeOtherNote", "fiToxicityUsed", "fiTestingUsed", "fiGates", "fiTimeOfImportation", "fiNote", "fiSignConfirmName", "fiSignConfirmPosition", "fiSignConfirmAddress"})
public class BNNGuiChinhSuaGP {

	public BNNGuiChinhSuaGP() {}

	@XmlElement(name = "Reason", required = true)
	private String fiReason;

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "SignConfirmDate", required = true)
	private Date fiSignConfirmDate;

	@XmlElement(name = "MedicinePPLicense")
	private String fiMedicinePPLicense;

	@XmlElement(name = "DispatchNo", required = true)
	private String fiDispatchNo;

	@XmlElement(name = "Organization", required = true)
	private String fiOrganization;

	@XmlElement(name = "Address", required = true)
	private String fiAddress;

	@XmlElement(name = "ApplicationNo", required = true)
	private String fiApplicationNo;

	@XmlJavaTypeAdapter(DateSerialization.class)
	@XmlElement(name = "SignDate", required = true)
	private Date fiSignDate;

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
	@XmlElement(name = "TimeOfImportation", required = true)
	private Date fiTimeOfImportation;

	@XmlElement(name = "Note")
	private String fiNote;

	@XmlElement(name = "SignConfirmName", required = true)
	private String fiSignConfirmName;

	@XmlElement(name = "SignConfirmPosition", required = true)
	private String fiSignConfirmPosition;

	@XmlElement(name = "SignConfirmAddress", required = true)
	private String fiSignConfirmAddress;

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

	public String getFiMedicinePPLicense() {
		return this.fiMedicinePPLicense;
	}

	public void setFiMedicinePPLicense(String fiMedicinePPLicense) {
		this.fiMedicinePPLicense = fiMedicinePPLicense;
	}

	public String getFiDispatchNo() {
		return this.fiDispatchNo;
	}

	public void setFiDispatchNo(String fiDispatchNo) {
		this.fiDispatchNo = fiDispatchNo;
	}

	public String getFiOrganization() {
		return this.fiOrganization;
	}

	public void setFiOrganization(String fiOrganization) {
		this.fiOrganization = fiOrganization;
	}

	public String getFiAddress() {
		return this.fiAddress;
	}

	public void setFiAddress(String fiAddress) {
		this.fiAddress = fiAddress;
	}

	public String getFiApplicationNo() {
		return this.fiApplicationNo;
	}

	public void setFiApplicationNo(String fiApplicationNo) {
		this.fiApplicationNo = fiApplicationNo;
	}

	public Date getFiSignDate() {
		return this.fiSignDate;
	}

	public void setFiSignDate(Date fiSignDate) {
		this.fiSignDate = fiSignDate;
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

	public Date getFiTimeOfImportation() {
		return this.fiTimeOfImportation;
	}

	public void setFiTimeOfImportation(Date fiTimeOfImportation) {
		this.fiTimeOfImportation = fiTimeOfImportation;
	}

	public String getFiNote() {
		return this.fiNote;
	}

	public void setFiNote(String fiNote) {
		this.fiNote = fiNote;
	}

	public String getFiSignConfirmName() {
		return this.fiSignConfirmName;
	}

	public void setFiSignConfirmName(String fiSignConfirmName) {
		this.fiSignConfirmName = fiSignConfirmName;
	}

	public String getFiSignConfirmPosition() {
		return this.fiSignConfirmPosition;
	}

	public void setFiSignConfirmPosition(String fiSignConfirmPosition) {
		this.fiSignConfirmPosition = fiSignConfirmPosition;
	}

	public String getFiSignConfirmAddress() {
		return this.fiSignConfirmAddress;
	}

	public void setFiSignConfirmAddress(String fiSignConfirmAddress) {
		this.fiSignConfirmAddress = fiSignConfirmAddress;
	}

	@Override
	public String toString() {
		return "BNNGuiChinhSuaGP [" +
				"fiReason=" + fiReason + "," + 
				"fiSignConfirmDate=" + fiSignConfirmDate + "," + 
				"fiMedicinePPLicense=" + fiMedicinePPLicense + "," + 
				"fiDispatchNo=" + fiDispatchNo + "," + 
				"fiOrganization=" + fiOrganization + "," + 
				"fiAddress=" + fiAddress + "," + 
				"fiApplicationNo=" + fiApplicationNo + "," + 
				"fiSignDate=" + fiSignDate + "," + 
				"fiGoods=" + fiGoods + "," + 
				"fiPurposes=" + fiPurposes + "," + 
				"fiPurposeOtherNote=" + fiPurposeOtherNote + "," + 
				"fiToxicityUsed=" + fiToxicityUsed + "," + 
				"fiTestingUsed=" + fiTestingUsed + "," + 
				"fiGates=" + fiGates + "," + 
				"fiTimeOfImportation=" + fiTimeOfImportation + "," + 
				"fiNote=" + fiNote + "," + 
				"fiSignConfirmName=" + fiSignConfirmName + "," + 
				"fiSignConfirmPosition=" + fiSignConfirmPosition + "," + 
				"fiSignConfirmAddress=" + fiSignConfirmAddress + "]";
	}
}