package com.nsw.mard.p17.model;

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
* @class TbdHoSo17
* Created by Nguyen Van Quang
* 04/12/2018 10:174:57
*
*/
public class TbdHoSo17DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public TbdHoSo17DTO() {}

	public TbdHoSo17DTO(Long fiIdHoSo, String fiDocumentType, String fiDocumentName, Integer fiStatus, Date fiCreateDate, Date fiModifiedDate, Date fiReceiveDate, Integer fiActive, String fiApplicationNo, String fiNameOfRegistration, String fiAddressOfRegistration, String fiPhone, String fiEmail, String fiFax, String fiTaxCode, String fiPurposes, String fiPurposeOtherNote,  String fiImportGate, Date fiImportTimeFrom, Date fiImportTimeTo,
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
		this.fiPurposes = fiPurposes;
		this.fiPurposeOtherNote = fiPurposeOtherNote;

		this.fiImportGate = fiImportGate;
		this.fiImportTimeFrom = fiImportTimeFrom;
		this.fiImportTimeTo = fiImportTimeTo;
		//code them
		this.fiCertificateNumber = fiCertificateNumber;
		this.fiCertificateType = fiCertificateType;
		this.fiCertificateSignDate = fiCertificateSignDate;
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

	@NotNull
	@Size(max = 24)
	@NotEmpty
	private String fiTaxCode;

	@NotNull
	@Size(max = 250)
	@NotEmpty
	private String fiPurposes;

	@Size(max = 500)
	private String fiPurposeOtherNote;

	@NotNull
	@NotEmpty
	@Size(max = 500)
	private String fiImportGate;

    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String fiCertificateNumber;

    @Size(max = 250)
    private String fiCertificateType;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fiCertificateSignDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fiImportTimeFrom;

	private String fiStatusName;

	public String getFiStatusName() {
		return fiStatusName;
	}

	public void setFiStatusName(String fiStatusName) {
		this.fiStatusName = fiStatusName;
	}

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fiImportTimeTo;

	private String fiReasonDrawal;

	private String fiReasonCorrection;

	private Integer fiVersion;

	private Integer fiSended;



	private Date fiSendDate;


	private String fiReceiptWritingAddress;

	private String fiSenderNumber;

	public String getFiReceiptWritingAddress() {
		return fiReceiptWritingAddress;
	}

	public void setFiReceiptWritingAddress(String fiReceiptWritingAddress) {
		this.fiReceiptWritingAddress = fiReceiptWritingAddress;
	}

	public String getFiSenderNumber() {
		return fiSenderNumber;
	}

	public void setFiSenderNumber(String fiSenderNumber) {
		this.fiSenderNumber = fiSenderNumber;
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

	private long totalFileSize;

	public long getTotalFileSize() {
		return totalFileSize;
	}

	public void setTotalFileSize(long totalFileSize) {
		this.totalFileSize = totalFileSize;
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
	public Date getFiSendDate() {
		return fiSendDate;
	}

	public void setFiSendDate(Date fiSendDate) {
		this.fiSendDate = fiSendDate;
	}

	@Override
	public String toString() {
		return "TbdHoSo17 [" +
				"fiIdHoSo=" + fiIdHoSo + "," + 
				"fiDocumentType=" + fiDocumentType + "," + 
				"fiDocumentName=" + fiDocumentName + "," + 
				"fiStatus=" + fiStatus + "," + 
				"fiCreateDate=" + fiCreateDate + "," + 
				"fiModifiedDate=" + fiModifiedDate + "," + 
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
                "fiCertificateNumber=" + fiCertificateNumber + "," +
                "fiCertificateType=" + fiCertificateType + "," +
                "fiCertificateSignDate=" + fiCertificateSignDate + "," +
				"fiImportTimeFrom=" + fiImportTimeFrom + "," +
				"fiImportTimeTo=" + fiImportTimeTo + "]";
	}
}
