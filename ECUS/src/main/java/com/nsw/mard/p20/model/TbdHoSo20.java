package com.nsw.mard.p20.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdHoSo20
* Created by Nguyen Van Quang
* 11/12/2020 10:2020:50
*
*/
public class TbdHoSo20 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long fiIdHoSo;

	private String fiDocumentType;

	private String fiDocumentName;

	private String fiGates;

	private Integer fiStatus;

	private Integer fiOldStatus;

	private Date fiCreateDate;

	private Date fiModifiedDate;

	private Date fiSendDate;

	private Date fiReceiveDate;

	private Integer fiActive;

	private String fiCertificateType;

	private String fiApplicationNo;

	private String fiNameOfRegistration;

	private String fiAddressOfRegistration;

	private String fiPhone;

	private String fiEmail;

	private String fiFax;

	private String fiTaxCode;

	private Date fiSignDate;




	private String fiContractNo;

	private String fiGoodListNo;

	private String fiCQNo;

	private String fiCQOrganization;

	private Date fiCQDate;

	private String fiCQIssueBy;

	private String fiCMSNo;

	private String fiCMSOrganization;

	private Date fiCMSDate;

	private String fiCMSIssueBy;

	private String fiInvoiceNo;

	private String fiBillNo;

	private String fiDeclarationNo;

	private String fiCONo;

	private String fiCFSNo;

	private String fiTechRegul;

	private String fiApplyRegul;

	private String fiOrganization;

	private String fiReasonDrawal;

	private String fiExperimentName;

	private String fiExperimentCode;

	private String fiReasonCorrection;

	private Integer fiVersion;

	private Integer fiSended;


	private String fiSenderNumber;

	private String fiReceiptWritingAddress;

	private String fiRegistrationNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date fiRegistrationDate;

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

	public Date getFiSignDate() {
		return fiSignDate;
	}

	public void setFiSignDate(Date fiSignDate) {
		this.fiSignDate = fiSignDate;
	}


	public String getFiOrganization() {
		return fiOrganization;
	}

	public void setFiOrganization(String fiOrganization) {
		this.fiOrganization = fiOrganization;
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

	public String getFiCertificateType() {
		return fiCertificateType;
	}
	public String getFiGates() {
		return fiGates;
	}

	public void setFiGates(String fiGates) {
		this.fiGates = fiGates;
	}

	public void setFiCertificateType(String fiCertificateType) {
		this.fiCertificateType = fiCertificateType;
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

	@Override
	public String toString() {
		return "TbdHoSo20{" +
				"fiIdHoSo=" + fiIdHoSo +
				", fiDocumentType='" + fiDocumentType + '\'' +
				", fiDocumentName='" + fiDocumentName + '\'' +
				", fiGates='" + fiGates + '\'' +
				", fiStatus=" + fiStatus +
				", fiOldStatus=" + fiOldStatus +
				", fiCreateDate=" + fiCreateDate +
				", fiModifiedDate=" + fiModifiedDate +
				", fiSendDate=" + fiSendDate +
				", fiReceiveDate=" + fiReceiveDate +
				", fiActive=" + fiActive +
				", fiCertificateType='" + fiCertificateType + '\'' +
				", fiApplicationNo='" + fiApplicationNo + '\'' +
				", fiNameOfRegistration='" + fiNameOfRegistration + '\'' +
				", fiAddressOfRegistration='" + fiAddressOfRegistration + '\'' +
				", fiPhone='" + fiPhone + '\'' +
				", fiEmail='" + fiEmail + '\'' +
				", fiFax='" + fiFax + '\'' +
				", fiTaxCode='" + fiTaxCode + '\'' +
				", fiSignDate=" + fiSignDate +
				", fiContractNo='" + fiContractNo + '\'' +
				", fiGoodListNo='" + fiGoodListNo + '\'' +
				", fiCQNo='" + fiCQNo + '\'' +
				", fiCQOrganization='" + fiCQOrganization + '\'' +
				", fiCQDate=" + fiCQDate +
				", fiCQIssueBy='" + fiCQIssueBy + '\'' +
				", fiCMSNo='" + fiCMSNo + '\'' +
				", fiCMSOrganization='" + fiCMSOrganization + '\'' +
				", fiCMSDate=" + fiCMSDate +
				", fiCMSIssueBy='" + fiCMSIssueBy + '\'' +
				", fiInvoiceNo='" + fiInvoiceNo + '\'' +
				", fiBillNo='" + fiBillNo + '\'' +
				", fiDeclarationNo='" + fiDeclarationNo + '\'' +
				", fiCONo='" + fiCONo + '\'' +
				", fiCFSNo='" + fiCFSNo + '\'' +
				", fiTechRegul='" + fiTechRegul + '\'' +
				", fiApplyRegul='" + fiApplyRegul + '\'' +
				", fiOrganization='" + fiOrganization + '\'' +
				", fiReasonDrawal='" + fiReasonDrawal + '\'' +
				", fiExperimentName='" + fiExperimentName + '\'' +
				", fiExperimentCode='" + fiExperimentCode + '\'' +
				", fiReasonCorrection='" + fiReasonCorrection + '\'' +
				", fiVersion=" + fiVersion +
				", fiSended=" + fiSended +
				", fiSenderNumber='" + fiSenderNumber + '\'' +
				", fiReceiptWritingAddress='" + fiReceiptWritingAddress + '\'' +
				", fiRegistrationNumber='" + fiRegistrationNumber + '\'' +
				", fiRegistrationDate=" + fiRegistrationDate +
				'}';
	}
}
