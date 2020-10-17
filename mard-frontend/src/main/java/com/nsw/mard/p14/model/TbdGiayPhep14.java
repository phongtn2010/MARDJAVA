package com.nsw.mard.p14.model;

import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdGiayPhep14
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
public class TbdGiayPhep14 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	private Long fiIdHoSo;

	private String fiDispatchNo;

	private String fiOrganization;

	private String fiAddress;

	private String fiApplicationNo;

	private Date fiSignDate;

	private String fiPurposes;

	private String fiPurposeOtherNote;

	private String fiToxicityUsed;

	private String fiTestingUsed;

	private String fiGates;

	private Date fiTimeOfImportation;

	private String fiNote;

	private Date fiSignConfirmDate;

	private String fiSignConfirmName;

	private String fiSignConfirmPosition;

	private String fiSignConfirmAddress;

	public Long getFiId() {
		return this.fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return this.fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
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

	public Date getFiSignConfirmDate() {
		return this.fiSignConfirmDate;
	}

	public void setFiSignConfirmDate(Date fiSignConfirmDate) {
		this.fiSignConfirmDate = fiSignConfirmDate;
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
		return "TbdGiayPhep14 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiDispatchNo=" + fiDispatchNo + "," + 
				"fiOrganization=" + fiOrganization + "," + 
				"fiAddress=" + fiAddress + "," + 
				"fiApplicationNo=" + fiApplicationNo + "," + 
				"fiSignDate=" + fiSignDate + "," + 
				"fiPurposes=" + fiPurposes + "," + 
				"fiPurposeOtherNote=" + fiPurposeOtherNote + "," + 
				"fiToxicityUsed=" + fiToxicityUsed + "," + 
				"fiTestingUsed=" + fiTestingUsed + "," + 
				"fiGates=" + fiGates + "," + 
				"fiTimeOfImportation=" + fiTimeOfImportation + "," + 
				"fiNote=" + fiNote + "," + 
				"fiSignConfirmDate=" + fiSignConfirmDate + "," + 
				"fiSignConfirmName=" + fiSignConfirmName + "," + 
				"fiSignConfirmPosition=" + fiSignConfirmPosition + "," + 
				"fiSignConfirmAddress=" + fiSignConfirmAddress + "]";
	}
}