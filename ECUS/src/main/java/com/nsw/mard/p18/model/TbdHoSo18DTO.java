package com.nsw.mard.p18.model;

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
* @class TbdHoSo18
* Created by Nguyen Van Quang
* 04/12/2018 10:184:58
*
*/
public class TbdHoSo18DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TbdHoSo18DTO() {}

	public TbdHoSo18DTO(Long fiIdHoSo, String fiDocumentType, String fiDocumentName, Integer fiStatus, Date fiCreateDate, Date fiModifiedDate, Date fiReceiveDate, Integer fiActive, String fiApplicationNo, String fiNameOfRegistration, String fiAddressOfRegistration, String fiPhone, String fiEmail, String fiFax, String fiTaxCode, String fiPurposes, String fiPurposeOtherNote,  String fiImportGate, Date fiImportTimeFrom, Date fiImportTimeTo,
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

	@NotNull
	@Size(max = 255)
	@NotEmpty
	private String fiDocumentType;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String fiDocumentName;

	@NotNull
	private Integer fiStatus;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiCreateDate = new Date();

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiModifiedDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fiReceiveDate;

	@NotNull
	private Integer fiActive;

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



	@Size(max = 250)
	private String fiExperimentName;


	@Size(max = 250)
	private String fiExperimentCode;

	@NotNull
	@Size(max = 24)
	@NotEmpty
	private String fiTaxCode;

	private String fiStatusName;


	@Size(max = 250)
	@NotEmpty
	private String fiGates;

	@Size(max = 250)
	@NotEmpty
	private String fiContractNo;


	@Size(max = 250)
	@NotEmpty
	private String fiGoodListNo;


	@Size(max = 250)
	private String fiCQNo;


	@Size(max = 250)
	private String fiCQOrganization;


	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date fiCQDate;

	@Size(max = 250)
	private String fiCQIssueBy;

	private String fiCMSNo;

	private String fiCMSOrganization;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date fiCMSDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date fiSignDate;

	private String fiCMSIssueBy;


	@Size(max = 250)
	@NotEmpty
	private String fiInvoiceNo;


	@Size(max = 250)
	private String fiBillNo;

	private String fiDeclarationNo;

	private String fiCertificateType;

	private String fiCONo;

	private String fiCFSNo;

	@Size(max = 250)
	private String fiTechRegul;
	@Size(max = 250)
	private String fiApplyRegul;

	private String fiReasonDrawal;

	private String fiReasonCorrection;

	private Integer fiVersion;



	private Date fiSendDate;

	private Integer fiSended;
	@Size(max = 250)
	@NotEmpty
	private String fiSenderNumber;
	@Size(max = 500)
	@NotEmpty
	private String fiReceiptWritingAddress;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy", timezone = "GMT+7")
	private Date fiRegistrationDate;

	private String fiRegistrationNumber;

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

	public Date getFiSendDate() {
		return fiSendDate;
	}

	public void setFiSendDate(Date fiSendDate) {
		this.fiSendDate = fiSendDate;
	}
	
	public String getFiStatusName() {
		return fiStatusName;
	}

	public void setFiStatusName(String fiStatusName) {
		this.fiStatusName = fiStatusName;
	}

	public String getFiGates() {
		return fiGates;
	}

	public void setFiGates(String fiGates) {
		this.fiGates = fiGates;
	}

	public String getFiContractNo() {
		return fiContractNo;
	}

	public void setFiContractNo(String fiContractNo) {
		this.fiContractNo = fiContractNo;
	}

	public String getFiGoodListNo() {
		return fiGoodListNo;
	}

	public void setFiGoodListNo(String fiGoodListNo) {
		this.fiGoodListNo = fiGoodListNo;
	}

	public String getFiCQNo() {
		return fiCQNo;
	}

	public void setFiCQNo(String fiCQNo) {
		this.fiCQNo = fiCQNo;
	}

	public String getFiCQOrganization() {
		return fiCQOrganization;
	}

	public void setFiCQOrganization(String fiCQOrganization) {
		this.fiCQOrganization = fiCQOrganization;
	}

	public Date getFiCQDate() {
		return fiCQDate;
	}

	public void setFiCQDate(Date fiCQDate) {
		this.fiCQDate = fiCQDate;
	}

	public String getFiCQIssueBy() {
		return fiCQIssueBy;
	}

	public void setFiCQIssueBy(String fiCQIssueBy) {
		this.fiCQIssueBy = fiCQIssueBy;
	}

	public String getFiCMSNo() {
		return fiCMSNo;
	}

	public void setFiCMSNo(String fiCMSNo) {
		this.fiCMSNo = fiCMSNo;
	}

	public String getFiCMSOrganization() {
		return fiCMSOrganization;
	}

	public void setFiCMSOrganization(String fiCMSOrganization) {
		this.fiCMSOrganization = fiCMSOrganization;
	}

	public Date getFiCMSDate() {
		return fiCMSDate;
	}

	public void setFiCMSDate(Date fiCMSDate) {
		this.fiCMSDate = fiCMSDate;
	}

	public String getFiCMSIssueBy() {
		return fiCMSIssueBy;
	}

	public void setFiCMSIssueBy(String fiCMSIssueBy) {
		this.fiCMSIssueBy = fiCMSIssueBy;
	}

	public String getFiInvoiceNo() {
		return fiInvoiceNo;
	}

	public void setFiInvoiceNo(String fiInvoiceNo) {
		this.fiInvoiceNo = fiInvoiceNo;
	}

	public String getFiBillNo() {
		return fiBillNo;
	}

	public void setFiBillNo(String fiBillNo) {
		this.fiBillNo = fiBillNo;
	}

	public String getFiDeclarationNo() {
		return fiDeclarationNo;
	}

	public void setFiDeclarationNo(String fiDeclarationNo) {
		this.fiDeclarationNo = fiDeclarationNo;
	}

	public String getFiCONo() {
		return fiCONo;
	}

	public void setFiCONo(String fiCONo) {
		this.fiCONo = fiCONo;
	}

	public String getFiCFSNo() {
		return fiCFSNo;
	}

	public void setFiCFSNo(String fiCFSNo) {
		this.fiCFSNo = fiCFSNo;
	}

	public String getFiTechRegul() {
		return fiTechRegul;
	}

	public void setFiTechRegul(String fiTechRegul) {
		this.fiTechRegul = fiTechRegul;
	}

	public String getFiApplyRegul() {
		return fiApplyRegul;
	}

	public void setFiApplyRegul(String fiApplyRegul) {
		this.fiApplyRegul = fiApplyRegul;
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

	public Date getFiRegistrationDate() {
		return fiRegistrationDate;
	}

	public void setFiRegistrationDate(Date fiRegistrationDate) {
		this.fiRegistrationDate = fiRegistrationDate;
	}

	public String getFiRegistrationNumber() {
		return fiRegistrationNumber;
	}

	public void setFiRegistrationNumber(String fiRegistrationNumber) {
		this.fiRegistrationNumber = fiRegistrationNumber;
	}

	@Override
	public String toString() {
		return "TbdHoSo18DTO{" +
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
				", fiGates='" + fiGates + '\'' +
				", fiContractNo='" + fiContractNo + '\'' +
				", fiGoodListNo='" + fiGoodListNo + '\'' +
				", fiCQNo='" + fiCQNo + '\'' +
				", fiCQOrganization='" + fiCQOrganization + '\'' +
				", fiCQDate=" + fiCQDate +
				", fiCQIssueBy='" + fiCQIssueBy + '\'' +
				", fiCMSNo='" + fiCMSNo + '\'' +
				", fiCMSOrganization='" + fiCMSOrganization + '\'' +
				", fiCMSDate=" + fiCMSDate +
				", fiIssueBy='" + fiCMSIssueBy + '\'' +
				", fiInvoiceNo='" + fiInvoiceNo + '\'' +
				", fiBillNo='" + fiBillNo + '\'' +
				", fiDeclarationNo='" + fiDeclarationNo + '\'' +
				", fiCONo='" + fiCONo + '\'' +
				", fiCFSNo='" + fiCFSNo + '\'' +
				", fiExperimentName='" + fiExperimentName + '\'' +
				", fiExperimentCode='" + fiExperimentCode + '\'' +
				", fiTechRegul='" + fiTechRegul + '\'' +
				", fiApplyRegul='" + fiApplyRegul + '\'' +
				", fiReasonDrawal='" + fiReasonDrawal + '\'' +
				", fiReasonCorrection='" + fiReasonCorrection + '\'' +
				", fiSignDate=" + fiSignDate +
				", fiVersion=" + fiVersion +
				", fiSended=" + fiSended +
				", fiSenderNumber='" + fiSenderNumber + '\'' +
				", fiReceiptWritingAddress='" + fiReceiptWritingAddress + '\'' +
				", fiRegistrationNumber='" + fiRegistrationNumber + '\'' +
				", fiRegistrationDate='" + fiRegistrationDate + '\'' +
				'}';
	}
}
