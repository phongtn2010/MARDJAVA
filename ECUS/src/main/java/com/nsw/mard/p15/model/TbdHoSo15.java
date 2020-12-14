package com.nsw.mard.p15.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdHoSo15
* Created by Nguyen Van Quang
* 11/12/2018 10:1515:50
*
*/
public class TbdHoSo15 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiIdHoSo;

	@NotNull
	@Size(max = 255)
	private String fiDocumentType;

	@NotNull
	@Size(max = 255)
	private String fiDocumentName;

	@NotNull
	private Integer fiStatus;

	private Integer fiOldStatus;

	@NotNull
	private Date fiCreateDate;

	@NotNull
	private Date fiModifiedDate;

	private Date fiSendDate;

	private Date fiReceiveDate;

	@NotNull
	private Integer fiActive;

	@Size(max = 500)
	private String fiReasonDrawal;

	@Size(max = 500)
	private String fiReasonCorrection;

	@NotNull
	@Size(max = 20)
	private String fiApplicationNo;

	@NotNull
	@Size(max = 255)
	private String fiNameOfRegistration;

	@NotNull
	@Size(max = 500)
	private String fiAddressOfRegistration;

	@Size(max = 50)
	private String fiPhone;

	@Size(max = 250)
	private String fiEmail;

	@Size(max = 250)
	private String fiFax;

	@NotNull
	@Size(max = 15)
	private String fiTaxCode;

	@NotNull
	@Size(max = 250)
	private String fiPurposes;

	@Size(max = 500)
	private String fiOtherPurposeDetail;

	@Size(max = 500)
	private String fiOrganizationReceiving;

	@Size(max = 500)
	private String fiSummaryOfNumber;

	@NotNull
	private String fiTotalQuantity;

	@NotNull
	private Date fiTimeImport;

	@Size(max = 500)
	private String fiSignAddress;

	private Date fiSignDate;

	@Size(max = 250)
	private String fiSignName;

	@NotNull
	@Size(max = 25)
	private String fiSignerPosition;

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

	public String getFiTaxCode() {
		return fiTaxCode;
	}

	public void setFiTaxCode(String fiTaxCode) {
		this.fiTaxCode = fiTaxCode;
	}

	public String getFiPurposes() {
		return fiPurposes;
	}

	public void setFiPurposes(String fiPurposes) {
		this.fiPurposes = fiPurposes;
	}

	public String getFiOtherPurposeDetail() {
		return fiOtherPurposeDetail;
	}

	public void setFiOtherPurposeDetail(String fiOtherPurposeDetail) {
		this.fiOtherPurposeDetail = fiOtherPurposeDetail;
	}

	public String getFiOrganizationReceiving() {
		return fiOrganizationReceiving;
	}

	public void setFiOrganizationReceiving(String fiOrganizationReceiving) {
		this.fiOrganizationReceiving = fiOrganizationReceiving;
	}

	public String getFiSummaryOfNumber() {
		return fiSummaryOfNumber;
	}

	public void setFiSummaryOfNumber(String fiSummaryOfNumber) {
		this.fiSummaryOfNumber = fiSummaryOfNumber;
	}

	public String getFiTotalQuantity() {
		return fiTotalQuantity;
	}

	public void setFiTotalQuantity(String fiTotalQuantity) {
		this.fiTotalQuantity = fiTotalQuantity;
	}

	public Date getFiTimeImport() {
		return fiTimeImport;
	}

	public void setFiTimeImport(Date fiTimeImport) {
		this.fiTimeImport = fiTimeImport;
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

	@Override
	public String toString() {
		return "TbdHoSo15{" +
				"fiIdHoSo=" + fiIdHoSo +
				", fiDocumentType='" + fiDocumentType + '\'' +
				", fiDocumentName='" + fiDocumentName + '\'' +
				", fiStatus=" + fiStatus +
				", fiOldStatus=" + fiOldStatus +
				", fiCreateDate=" + fiCreateDate +
				", fiModifiedDate=" + fiModifiedDate +
				", fiSendDate=" + fiSendDate +
				", fiReceiveDate=" + fiReceiveDate +
				", fiActive=" + fiActive +
				", fiReasonDrawal='" + fiReasonDrawal + '\'' +
				", fiReasonCorrection='" + fiReasonCorrection + '\'' +
				", fiApplicationNo='" + fiApplicationNo + '\'' +
				", fiNameOfRegistration='" + fiNameOfRegistration + '\'' +
				", fiAddressOfRegistration='" + fiAddressOfRegistration + '\'' +
				", fiPhone='" + fiPhone + '\'' +
				", fiEmail='" + fiEmail + '\'' +
				", fiFax='" + fiFax + '\'' +
				", fiTaxCode='" + fiTaxCode + '\'' +
				", fiPurposes='" + fiPurposes + '\'' +
				", fiOtherPurposeDetail='" + fiOtherPurposeDetail + '\'' +
				", fiOrganizationReceiving='" + fiOrganizationReceiving + '\'' +
				", fiSummaryOfNumber='" + fiSummaryOfNumber + '\'' +
				", fiTotalQuantity=" + fiTotalQuantity +
				", fiTimeImport=" + fiTimeImport +
				", fiSignAddress='" + fiSignAddress + '\'' +
				", fiSignDate='" + fiSignDate + '\'' +
				", fiSignName='" + fiSignName + '\'' +
				", fiSignerPosition=" + fiSignerPosition +
				'}';
	}
}