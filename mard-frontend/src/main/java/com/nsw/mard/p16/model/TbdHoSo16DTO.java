package com.nsw.mard.p16.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class TbdHoSo16
* Created by Nguyen Van Quang
* 04/12/2018 10:164:57
*
*/
public class TbdHoSo16DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiIdHoSo;

	@NotNull
	@Size(max = 255)
	@NotEmpty
	private String fiDocumentType;

	@NotNull
	@Size(max = 255)
	@NotEmpty
	private String fiDocumentName;

	@NotEmpty
	private String fiTaxCode;

	@NotNull
	private Integer fiStatus;

	private Integer fiOldStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private Date fiCreateDate;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiModifiedDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiSendDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiReceiveDate;

	@NotNull
	private Integer fiActive;

	@Size(max = 500)
	private String fiReasonDrawal;

	@Size(max = 500)
	private String fiReasonCorrection;

	@NotNull
	@Size(max = 20)
	@NotEmpty
	private String fiApplicationNo;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String fiNameOfRegistration;

	@NotNull
	@NotEmpty
	@Size(max = 500)
	private String fiAddressOfRegistration;

	@Size(max = 50)
	private String fiPhone;

	@Size(max = 250)
	private String fiEmail;

	@Size(max = 250)
	private String fiFax;


	@NotNull
	private Integer fiPurposes;

	@Size(max = 250)
	private String fiOtherPurposesValue;

	@NotEmpty
	@NotNull
	@Size(max = 205)
	private String fiTotalQuantity;

	@NotNull
	private Integer fiImportTime;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiDeadlineImport;


	@Size(max = 2000)
	private String fiScale;

	@Size(max = 2000)
	private String fiLocation;

	@NotNull
	@Size(max = 50)
	@NotEmpty
	private String fiDocument;

	@Size(max = 250)
	private String fiOtherPaperValue;


	@NotNull
	@Size(max = 250)
	@NotEmpty
	private String fiSignAddress;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiSignDate;

	@NotNull
	@Size(max = 250)
	@NotEmpty
	private String fiSignName;

	@NotNull
	@Size(max = 250)
	@NotEmpty
	private String fiSignerPosition;

	private String fiStatusName;

	private Integer fiVersion;

	public Integer getFiVersion() {
		return fiVersion;
	}

	public void setFiVersion(Integer fiVersion) {
		this.fiVersion = fiVersion;
	}

	private Integer fiSended;

	public Integer getFiSended() {
		return fiSended;
	}

	public void setFiSended(Integer fiSended) {
		this.fiSended = fiSended;
	}

	public Long getFiIdHoSo() {
		return fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public String getFiDocumentType() {
		return fiDocumentType;
	}

	public void setFiDocumentType(String fiDocumentType) {
		this.fiDocumentType = fiDocumentType;
	}

	public String getFiDocumentName() {
		return fiDocumentName;
	}

	public void setFiDocumentName(String fiDocumentName) {
		this.fiDocumentName = fiDocumentName;
	}

	public String getFiTaxCode() {
		return fiTaxCode;
	}

	public void setFiTaxCode(String fiTaxCode) {
		this.fiTaxCode = fiTaxCode;
	}

	public Integer getFiStatus() {
		return fiStatus;
	}

	public void setFiStatus(Integer fiStatus) {
		this.fiStatus = fiStatus;
	}

	public Integer getFiOldStatus() {
		return fiOldStatus;
	}

	public void setFiOldStatus(Integer fiOldStatus) {
		this.fiOldStatus = fiOldStatus;
	}

	public Date getFiCreateDate() {
		return fiCreateDate;
	}

	public void setFiCreateDate(Date fiCreateDate) {
		this.fiCreateDate = fiCreateDate;
	}

	public Date getFiModifiedDate() {
		return fiModifiedDate;
	}

	public void setFiModifiedDate(Date fiModifiedDate) {
		this.fiModifiedDate = fiModifiedDate;
	}

	public Date getFiSendDate() {
		return fiSendDate;
	}

	public void setFiSendDate(Date fiSendDate) {
		this.fiSendDate = fiSendDate;
	}

	public Date getFiReceiveDate() {
		return fiReceiveDate;
	}

	public void setFiReceiveDate(Date fiReceiveDate) {
		this.fiReceiveDate = fiReceiveDate;
	}

	public Integer getFiActive() {
		return fiActive;
	}

	public void setFiActive(Integer fiActive) {
		this.fiActive = fiActive;
	}

	public String getFiReasonDrawal() {
		return fiReasonDrawal;
	}

	public void setFiReasonDrawal(String fiReasonDrawal) {
		this.fiReasonDrawal = fiReasonDrawal;
	}

	public String getFiReasonCorrection() {
		return fiReasonCorrection;
	}

	public void setFiReasonCorrection(String fiReasonCorrection) {
		this.fiReasonCorrection = fiReasonCorrection;
	}

	public String getFiApplicationNo() {
		return fiApplicationNo;
	}

	public void setFiApplicationNo(String fiApplicationNo) {
		this.fiApplicationNo = fiApplicationNo;
	}

	public String getFiNameOfRegistration() {
		return fiNameOfRegistration;
	}

	public void setFiNameOfRegistration(String fiNameOfRegistration) {
		this.fiNameOfRegistration = fiNameOfRegistration;
	}

	public String getFiAddressOfRegistration() {
		return fiAddressOfRegistration;
	}

	public void setFiAddressOfRegistration(String fiAddressOfRegistration) {
		this.fiAddressOfRegistration = fiAddressOfRegistration;
	}

	public String getFiPhone() {
		return fiPhone;
	}

	public void setFiPhone(String fiPhone) {
		this.fiPhone = fiPhone;
	}

	public String getFiEmail() {
		return fiEmail;
	}

	public void setFiEmail(String fiEmail) {
		this.fiEmail = fiEmail;
	}

	public String getFiFax() {
		return fiFax;
	}

	public void setFiFax(String fiFax) {
		this.fiFax = fiFax;
	}

	public Integer getFiPurposes() {
		return fiPurposes;
	}

	public void setFiPurposes(Integer fiPurposes) {
		this.fiPurposes = fiPurposes;
	}

	public String getFiOtherPurposesValue() {
		return fiOtherPurposesValue;
	}

	public void setFiOtherPurposesValue(String fiOtherPurposesValue) {
		this.fiOtherPurposesValue = fiOtherPurposesValue;
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

	public String getFiDocument() {
		return fiDocument;
	}

	public void setFiDocument(String fiDocument) {
		this.fiDocument = fiDocument;
	}

	public String getFiOtherPaperValue() {
		return fiOtherPaperValue;
	}

	public void setFiOtherPaperValue(String fiOtherPaperValue) {
		this.fiOtherPaperValue = fiOtherPaperValue;
	}

	public String getFiSignAddress() {
		return fiSignAddress;
	}

	public void setFiSignAddress(String fiSignAddress) {
		this.fiSignAddress = fiSignAddress;
	}

	public Date getFiSignDate() {
		return fiSignDate;
	}

	public void setFiSignDate(Date fiSignDate) {
		this.fiSignDate = fiSignDate;
	}

	public String getFiSignName() {
		return fiSignName;
	}

	public void setFiSignName(String fiSignName) {
		this.fiSignName = fiSignName;
	}

	public String getFiSignerPosition() {
		return fiSignerPosition;
	}

	public void setFiSignerPosition(String fiSignerPosition) {
		this.fiSignerPosition = fiSignerPosition;
	}

	public String getFiStatusName() {
		return fiStatusName;
	}

	public void setFiStatusName(String fiStatusName) {
		this.fiStatusName = fiStatusName;
	}

	public String getFiTotalQuantity() {
		return fiTotalQuantity;
	}

	public void setFiTotalQuantity(String fiTotalQuantity) {
		this.fiTotalQuantity = fiTotalQuantity;
	}

	public Integer getFiImportTime() {
		return fiImportTime;
	}

	public void setFiImportTime(Integer fiImportTime) {
		this.fiImportTime = fiImportTime;
	}

	public Date getFiDeadlineImport() {
		return fiDeadlineImport;
	}

	public void setFiDeadlineImport(Date fiDeadlineImport) {
		this.fiDeadlineImport = fiDeadlineImport;
	}
}