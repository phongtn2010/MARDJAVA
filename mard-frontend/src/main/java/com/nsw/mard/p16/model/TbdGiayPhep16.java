package com.nsw.mard.p16.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdGiayPhep16
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
public class TbdGiayPhep16 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiId;

	@NotNull
	private Long fiIdHoSo;

	@NotNull
	@Size(max = 250)
	private String fiOrganization;

	@NotNull
	@Size(max = 250)
	private String fiAddress;

	@NotNull
	@Size(max = 50)
	private String fiApplicationNo;

	@NotNull
	private Date fiSignDate;

	private String fiBase;

	@NotNull
	@Size(max = 250)
	private String fiPurposes;

	@Size(max = 250)
	private String fiTotalQuantity;

	@Size(max = 500)
	private String fiScale;

	@Size(max = 3000)
	private String fiLocation;

	@NotNull
	@Size(max = 1000)
	private String fiLawBase;

	@NotNull
	@Size(max = 1000)
	private String fiReport;

	@NotNull
	private Date fiDealineImport;
	@NotNull
	@Size(max = 3000)
	private String fiRecipients;
	@NotNull
	@Size(max = 50)
	private String fiDispatchNo;

	@NotNull
	private Date fiSignConfirmDate;

	@NotNull
	@Size(max = 100)
	private String fiSignConfirmName;

	@NotNull
	@Size(max = 100)
	private String fiSignConfirmPosition;

	@NotNull
	@Size(max = 100)
	private String fiSignConfirmAddress;

	public Long getFiId() {
		return fiId;
	}

	public void setFiId(Long fiId) {
		this.fiId = fiId;
	}

	public Long getFiIdHoSo() {
		return fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public String getFiOrganization() {
		return fiOrganization;
	}

	public void setFiOrganization(String fiOrganization) {
		this.fiOrganization = fiOrganization;
	}

	public String getFiAddress() {
		return fiAddress;
	}

	public void setFiAddress(String fiAddress) {
		this.fiAddress = fiAddress;
	}

	public String getFiApplicationNo() {
		return fiApplicationNo;
	}

	public void setFiApplicationNo(String fiApplicationNo) {
		this.fiApplicationNo = fiApplicationNo;
	}

	public Date getFiSignDate() {
		return fiSignDate;
	}

	public void setFiSignDate(Date fiSignDate) {
		this.fiSignDate = fiSignDate;
	}

	public String getFiBase() {
		return fiBase;
	}

	public void setFiBase(String fiBase) {
		this.fiBase = fiBase;
	}

	public String getFiPurposes() {
		return fiPurposes;
	}

	public void setFiPurposes(String fiPurposes) {
		this.fiPurposes = fiPurposes;
	}

	public String getFiTotalQuantity() {
		return fiTotalQuantity;
	}

	public void setFiTotalQuantity(String fiTotalQuantity) {
		this.fiTotalQuantity = fiTotalQuantity;
	}

	public String getFiScale() {
		return fiScale;
	}

	public void setFiScale(String fiScale) {
		this.fiScale = fiScale;
	}

	public String getFiLocation() {
		return fiLocation;
	}

	public void setFiLocation(String fiLocation) {
		this.fiLocation = fiLocation;
	}

	public String getFiLawBase() {
		return fiLawBase;
	}

	public void setFiLawBase(String fiLawBase) {
		this.fiLawBase = fiLawBase;
	}

	public String getFiReport() {
		return fiReport;
	}

	public void setFiReport(String fiReport) {
		this.fiReport = fiReport;
	}

	public Date getFiDealineImport() {
		return fiDealineImport;
	}

	public void setFiDealineImport(Date fiDealineImport) {
		this.fiDealineImport = fiDealineImport;
	}

	public String getFiRecipients() {
		return fiRecipients;
	}

	public void setFiRecipients(String fiRecipients) {
		this.fiRecipients = fiRecipients;
	}

	public String getFiDispatchNo() {
		return fiDispatchNo;
	}

	public void setFiDispatchNo(String fiDispatchNo) {
		this.fiDispatchNo = fiDispatchNo;
	}

	public Date getFiSignConfirmDate() {
		return fiSignConfirmDate;
	}

	public void setFiSignConfirmDate(Date fiSignConfirmDate) {
		this.fiSignConfirmDate = fiSignConfirmDate;
	}

	public String getFiSignConfirmName() {
		return fiSignConfirmName;
	}

	public void setFiSignConfirmName(String fiSignConfirmName) {
		this.fiSignConfirmName = fiSignConfirmName;
	}

	public String getFiSignConfirmPosition() {
		return fiSignConfirmPosition;
	}

	public void setFiSignConfirmPosition(String fiSignConfirmPosition) {
		this.fiSignConfirmPosition = fiSignConfirmPosition;
	}

	public String getFiSignConfirmAddress() {
		return fiSignConfirmAddress;
	}

	public void setFiSignConfirmAddress(String fiSignConfirmAddress) {
		this.fiSignConfirmAddress = fiSignConfirmAddress;
	}

	private String fiNote;

	public String getFiNote() {
		return fiNote;
	}

	public void setFiNote(String fiNote) {
		this.fiNote = fiNote;
	}
}