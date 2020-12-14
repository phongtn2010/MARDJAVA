package com.nsw.mard.p17.model;

import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdHoSo17
* Created by Nguyen Van Quang
* 11/12/2018 10:1717:50
*
*/
public class TbdHoSo17 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiIdHoSo;

	private String fiDocumentType;

	private String fiDocumentName;

	private Integer fiStatus;

	private Integer fiOldStatus;

	private Date fiCreateDate;

	private Date fiModifiedDate;

	private Date fiSendDate;

	private Date fiReceiveDate;

	private Integer fiActive;

	private String fiApplicationNo;

	private String fiNameOfRegistration;

	private String fiAddressOfRegistration;

	private String fiPhone;

	private String fiEmail;

	private String fiFax;

	private String fiTaxCode;

	private String fiPurposes;

	private String fiPurposeOtherNote;


	private String fiImportGate;

	private String fiCertificateNumber;

	private String fiOrganization;

	private String fiCertificateType;

	private Date fiCertificateSignDate;

	private Date fiImportTimeFrom;

	private Date fiImportTimeTo;

	private String fiReasonDrawal;

	private String fiReasonCorrection;

	private Integer fiVersion;

	private String fiSenderNumber;

	private String fiReceiptWritingAddress;

	public String getFiSenderNumber() {
		return fiSenderNumber;
	}

	public void setFiSenderNumber(String fiSenderNumber) {
		this.fiSenderNumber = fiSenderNumber;
	}

	public String getFiReceiptWritingAddress() {
		return fiReceiptWritingAddress;
	}

	public void setFiReceiptWritingAddress(String fiReceiptWritingAddress) {
		this.fiReceiptWritingAddress = fiReceiptWritingAddress;
	}

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
		return this.fiIdHoSo;
	}

	public void setFiIdHoSo(Long fiIdHoSo) {
		this.fiIdHoSo = fiIdHoSo;
	}

	public String getFiDocumentType() {
		return this.fiDocumentType;
	}

	public void setFiDocumentType(String fiDocumentType) {
		this.fiDocumentType = fiDocumentType;
	}

	public String getFiDocumentName() {
		return this.fiDocumentName;
	}

	public void setFiDocumentName(String fiDocumentName) {
		this.fiDocumentName = fiDocumentName;
	}

	public Integer getFiStatus() {
		return this.fiStatus;
	}

	public void setFiStatus(Integer fiStatus) {
		this.fiStatus = fiStatus;
	}

	public Integer getFiOldStatus() {
		return this.fiOldStatus;
	}

	public void setFiOldStatus(Integer fiOldStatus) {
		this.fiOldStatus = fiOldStatus;
	}

	public Date getFiCreateDate() {
		return this.fiCreateDate;
	}

	public void setFiCreateDate(Date fiCreateDate) {
		this.fiCreateDate = fiCreateDate;
	}

	public Date getFiModifiedDate() {
		return this.fiModifiedDate;
	}

	public void setFiModifiedDate(Date fiModifiedDate) {
		this.fiModifiedDate = fiModifiedDate;
	}

	public Date getFiSendDate() {
		return this.fiSendDate;
	}

	public void setFiSendDate(Date fiSendDate) {
		this.fiSendDate = fiSendDate;
	}

	public Date getFiReceiveDate() {
		return this.fiReceiveDate;
	}

	public void setFiReceiveDate(Date fiReceiveDate) {
		this.fiReceiveDate = fiReceiveDate;
	}

	public Integer getFiActive() {
		return this.fiActive;
	}

	public void setFiActive(Integer fiActive) {
		this.fiActive = fiActive;
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

	public Date getFiImportTimeTo() {
		return this.fiImportTimeTo;
	}

	public void setFiImportTimeTo(Date fiImportTimeTo) {
		this.fiImportTimeTo = fiImportTimeTo;
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
	public String getFiCertificateNumber() {
		return fiCertificateNumber;
	}

	public void setFiCertificateNumber(String fiCertificateNumber) {
		this.fiCertificateNumber = fiCertificateNumber;
	}

	public String getFiCertificateType() {
		return fiCertificateType;
	}

	public void setFiCertificateType(String fiCertificateType) {
		this.fiCertificateType = fiCertificateType;
	}

	public Date getFiCertificateSignDate() {
		return fiCertificateSignDate;
	}

	public void setFiCertificateSignDate(Date fiCertificateSignDate) {
		this.fiCertificateSignDate = fiCertificateSignDate;
	}
	public String getFiOrganization() {
		return fiOrganization;
	}

	public void setFiOrganization(String fiOrganization) {
		this.fiOrganization = fiOrganization;
	}

	@Override
	public String toString() {
		return "TbdHoSo17 [" +
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiDocumentType=" + fiDocumentType + "," + 
				"fiDocumentName=" + fiDocumentName + "," + 
				"fiStatus=" + fiStatus + "," + 
				"fiOldStatus=" + fiOldStatus + "," + 
				"fiCreateDate=" + fiCreateDate + "," + 
				"fiModifiedDate=" + fiModifiedDate + "," + 
				"fiSendDate=" + fiSendDate + "," + 
				"fiReceiveDate=" + fiReceiveDate + "," + 
				"fiActive=" + fiActive + "," + 
				"fiApplicationNo=" + fiApplicationNo + "," + 
				"fiNameOfRegistration=" + fiNameOfRegistration + "," + 
				"fiAddressOfRegistration=" + fiAddressOfRegistration + "," + 
				"fiPhone=" + fiPhone + "," + 
				"fiEmail=" + fiEmail + "," + 
				"fiFax=" + fiFax + "," + 
				"fiTaxCode=" + fiTaxCode + "," + 
				"fiPurposes=" + fiPurposes + "," + 
				"fiPurposeOtherNote=" + fiPurposeOtherNote + "," +
				"fiImportGate=" + fiImportGate + "," +
				"fiOrganization=" + fiOrganization + "," +
				"fiCertificateNumber=" + fiCertificateNumber + "," +
				"fiCertificateType=" + fiCertificateType + "," +
				"fiCertificateSignDate=" + fiCertificateSignDate + "," +
				"fiImportTimeFrom=" + fiImportTimeFrom + "," + 
				"fiImportTimeTo=" + fiImportTimeTo + "," +
				"fiSenderNumber=" +  fiSenderNumber + "," +
				"fiReceiptWritingAdress=" + fiReceiptWritingAddress +
		        "]";
	}
}
