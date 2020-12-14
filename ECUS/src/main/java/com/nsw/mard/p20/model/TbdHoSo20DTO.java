package com.nsw.mard.p20.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/***
*
*
* @Model
* @class TbdHoSo20
* Created by Nguyen Van Quang
* 04/12/2020 10:204:58
*
*/
public class TbdHoSo20DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TbdHoSo20DTO() {}

	public TbdHoSo20DTO(Long fiIdHoSo, String fiDocumentType, String fiDocumentName, Integer fiStatus, Date fiCreateDate, Date fiModifiedDate, Date fiReceiveDate, Integer fiActive, String fiApplicationNo, String fiNameOfRegistration, String fiAddressOfRegistration, String fiPhone, String fiEmail, String fiFax, String fiTaxCode, String fiPurposes, String fiPurposeOtherNote,  String fiImportGate, Date fiImportTimeFrom, Date fiImportTimeTo,
						String fiCertificateNumber, String fiCertificateType, Date fiCertificateSignDate) {
		this.fiIdHoSo = fiIdHoSo;
		this.fiDocumentType = fiDocumentType;
		this.fiDocumentName = fiDocumentName;
		this.fiStatus = fiStatus;
		this.fiCreateDate = fiCreateDate;
		this.fiModifiedDate = fiModifiedDate;
		this.fiReceiveDate = fiReceiveDate;
		this.fiActive = fiActive;
		this.fiApplicationNo = fiApplicationNo;
		this.fiNameOfRegistration = fiNameOfRegistration;
		this.fiAddressOfRegistration = fiAddressOfRegistration;
		this.fiPhone = fiPhone;
		this.fiEmail = fiEmail;
		this.fiFax = fiFax;
		this.fiTaxCode = fiTaxCode;
	}


	private Long fiIdHoSo;


	@Size(max = 255)
	@NotEmpty
	private String fiDocumentType;


	@NotEmpty
	@Size(max = 255)
	private String fiDocumentName;


	private Integer fiStatus;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiCreateDate = new Date();


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiModifiedDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiReceiveDate;


	private Integer fiActive;


	@Size(max = 20)
	@NotEmpty
	private String fiApplicationNo;



	@Size(max = 255)
	private String fiNameOfRegistration;


	@Size(max = 500)
	private String fiAddressOfRegistration;

	@Size(max = 50)
	private String fiPhone;

	@Size(max = 250)
	private String fiEmail;

	@Size(max = 250)
	private String fiFax;



	private Date fiSendDate;

	@Size(max = 250)
	private String fiExperimentName;


	@Size(max = 250)
	private String fiExperimentCode;


	@Size(max = 24)
	@NotEmpty
	private String fiTaxCode;

	private String fiStatusName;


	private String fiCertificateType;



	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date fiSignDate;


	private String fiReasonDrawal;

	private String fiReasonCorrection;

	private Integer fiVersion;

	private Integer fiSended;


	@Size(max = 250)
	@NotEmpty
	private String fiSenderNumber;


	@Size(max = 500)
	@NotEmpty
	private String fiReceiptWritingAddress;

	public String getFiRegistrationNumber() {
		return fiRegistrationNumber;
	}

	public void setFiRegistrationNumber(String fiRegistrationNumber) {
		this.fiRegistrationNumber = fiRegistrationNumber;
	}

	public Date getFiRegistrationDate() {
		return fiRegistrationDate;
	}

	public void setFiRegistrationDate(Date fiRegistrationDate) {
		this.fiRegistrationDate = fiRegistrationDate;
	}

	private String fiRegistrationNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date fiRegistrationDate;



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



	public String getFiStatusName() {
		return fiStatusName;
	}

	public void setFiStatusName(String fiStatusName) {
		this.fiStatusName = fiStatusName;
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

	public Integer getFiVersion() {
		return fiVersion;
	}

	public void setFiVersion(Integer fiVersion) {
		this.fiVersion = fiVersion;
	}

	public Integer getFiSended() {
		return fiSended;
	}

	public void setFiSended(Integer fiSended) {
		this.fiSended = fiSended;
	}

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
	public String getFiCertificateType() {
		return fiCertificateType;
	}

	public void setFiCertificateType(String fiCertificateType) {
		this.fiCertificateType = fiCertificateType;
	}

	public Date getFiSignDate() {
		return fiSignDate;
	}

	public void setFiSignDate(Date fiSignDate) {
		this.fiSignDate = fiSignDate;
	}
	public String getFiExperimentName() {
		return fiExperimentName;
	}

	public void setFiExperimentName(String fiExperimentName) {
		this.fiExperimentName = fiExperimentName;
	}

	public String getFiExperimentCode() {
		return fiExperimentCode;
	}

	public void setFiExperimentCode(String fiExperimentCode) {
		this.fiExperimentCode = fiExperimentCode;
	}

	public Date getFiSendDate() {
		return fiSendDate;
	}

	public void setFiSendDate(Date fiSendDate) {
		this.fiSendDate = fiSendDate;
	}


	@Override
	public String toString() {
		return "TbdHoSo20DTO{" +
				"fiIdHoSo=" + fiIdHoSo +
				", fiDocumentType='" + fiDocumentType + '\'' +
				", fiDocumentName='" + fiDocumentName + '\'' +
				", fiStatus=" + fiStatus +
				", fiCreateDate=" + fiCreateDate +
				", fiModifiedDate=" + fiModifiedDate +
				", fiReceiveDate=" + fiReceiveDate +
				", fiActive=" + fiActive +
				", fiApplicationNo='" + fiApplicationNo + '\'' +
				", fiNameOfRegistration='" + fiNameOfRegistration + '\'' +
				", fiAddressOfRegistration='" + fiAddressOfRegistration + '\'' +
				", fiPhone='" + fiPhone + '\'' +
				", fiCertificateType=" + fiCertificateType + '\'' +
				", fiEmail='" + fiEmail + '\'' +
				", fiFax='" + fiFax + '\'' +
				", fiTaxCode='" + fiTaxCode + '\'' +
				", fiStatusName='" + fiStatusName + '\'' +
				", fiExperimentName='" + fiExperimentName + '\'' +
				", fiExperimentCode='" + fiExperimentCode + '\'' +
				", fiReasonDrawal='" + fiReasonDrawal + '\'' +
				", fiReasonCorrection='" + fiReasonCorrection + '\'' +
				", fiSignDate=" + fiSignDate +
				", fiVersion=" + fiVersion +
				", fiSended=" + fiSended +
				", fiSenderNumber='" + fiSenderNumber + '\'' +
				", fiReceiptWritingAddress='" + fiReceiptWritingAddress + '\'' +
				'}';
	}
}
