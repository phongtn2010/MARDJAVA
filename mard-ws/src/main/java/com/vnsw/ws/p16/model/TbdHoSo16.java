package com.vnsw.ws.p16.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/***
 *
 *
 * @Entity
 * @class TbdHoSo16
 * Created by Nguyen Van Quang
 * 11/12/2018 10:1616:48
 *
 */
public class TbdHoSo16 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiIdHoSo;
	private String fiDocumentType;

	private String fiDocumentName;

	private String fiTaxCode;

	private Integer fiStatus;

	private Integer fiOldStatus;

	private Date fiCreateDate;

	private Date fiModifiedDate;

	private Date fiSendDate;

	private Date fiReceiveDate;

	private Integer fiActive;

	private String fiReasonDrawal;

	private String fiReasonCorrection;

	private String fiApplicationNo;

	private String fiNameOfRegistration;

	private String fiAddressOfRegistration;

	private String fiPhone;

	private String fiEmail;

	private String fiFax;


	private String fiTotalQuantity;
	private Integer fiImportTime;
	private Date fiDeadlineImport;


	private Integer fiPurposes;

	private String fiOtherPurposesValue;

	private String fiScale;

	private String fiLocation;
	private String fiDocument;

	private String fiOtherPaperValue;

	private String fiSignAddress;
	private Date fiSignDate;
	private String fiSignName;

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


	public String getFiTaxCode() {
		return fiTaxCode;
	}

	public void setFiTaxCode(String fiTaxCode) {
		this.fiTaxCode = fiTaxCode;
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

}