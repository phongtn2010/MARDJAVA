package com.nsw.mard.p17.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdGiayPhep17
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
public class TbdGiayPhep17 implements Serializable {

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


	private String fiImportGate;

	private Date fiImportTimeFrom;



	private Date fiImportTimeTo;

	private String fiNote;

	private String fiDeniedReason;



	private Date fiSignConfirmDate;

	private String fiSignConfirmName;

	private String fiSignConfirmPosition;

	private String fiSignConfirmAddress;

	public Integer getFiLicenseType() {
		return fiLicenseType;
	}

	public void setFiLicenseType(Integer fiLicenseType) {
		this.fiLicenseType = fiLicenseType;
	}

	private Integer fiLicenseType;


	private String fiMultiproductLicense;

	private String fiLicenseContent;

	public String getFiMultiproductLicense() {
		return fiMultiproductLicense;
	}

	public void setFiMultiproductLicense(String fiMultiproductLicense) {
		this.fiMultiproductLicense = fiMultiproductLicense;
	}

	public String getFiLicenseContent() {
		return fiLicenseContent;
	}

	public void setFiLicenseContent(String fiLicenseContent) {
		this.fiLicenseContent = fiLicenseContent;
	}

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

	public String getFiDeniedReason() {
		return fiDeniedReason;
	}

	public void setFiDeniedReason(String fiDeniedReason) {
		this.fiDeniedReason = fiDeniedReason;
	}

	public String getFiImportGate() {
		return this.fiImportGate;
	}

	public void setFiImportGate(String fiImportGate) {
		this.fiImportGate = fiImportGate;
	}

	public Date getFiImportTimeFrom() {
		return this.fiImportTimeFrom;
	}

	public void setFiImportTimeFrom(Date fiImportTimeFrom) {
		this.fiImportTimeFrom = fiImportTimeFrom;
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
	public Date getFiImportTimeTo() {
		return fiImportTimeTo;
	}

	public void setFiImportTimeTo(Date fiImportTimeTo) {
		this.fiImportTimeTo = fiImportTimeTo;
	}

	public String getFiSignConfirmAddress() {
		return this.fiSignConfirmAddress;
	}

	public void setFiSignConfirmAddress(String fiSignConfirmAddress) {
		this.fiSignConfirmAddress = fiSignConfirmAddress;
	}

	@Override
	public String toString() {
		return "TbdGiayPhep17 [" +
				"fiId=" + fiId + "," + 
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiDispatchNo=" + fiDispatchNo + "," + 
				"fiOrganization=" + fiOrganization + "," + 
				"fiAddress=" + fiAddress + "," + 
				"fiApplicationNo=" + fiApplicationNo + "," + 
				"fiSignDate=" + fiSignDate + "," + 
				"fiPurposes=" + fiPurposes + "," + 
				"fiPurposeOtherNote=" + fiPurposeOtherNote + "," +
				"fiImportGate=" + fiImportGate + "," +
				"fiImportTimeFrom=" + fiImportTimeFrom + "," +
				"fiImportTimeTo=" + fiImportTimeTo + "," +
				"fiNote=" + fiNote + "," +
				"fiDeniedReason=" + fiDeniedReason + "," +
				"fiSignConfirmDate=" + fiSignConfirmDate + "," + 
				"fiSignConfirmName=" + fiSignConfirmName + "," + 
				"fiSignConfirmPosition=" + fiSignConfirmPosition + "," + 
				"fiSignConfirmAddress=" + fiSignConfirmAddress + "]";
	}
}
