package com.nsw.mard.p18.model;

import java.io.Serializable;
import java.util.Date;


/***
*
*
* @Model
* @class TbdGiayPhep18
* Created by Nguyen Van Quang
* 11/12/2018 10:06:22
*
*/
public class TbdThongBaoKetQua18 implements Serializable {

	private static final long serialVersionUID = 1L;


	private Long fiId;

	private Long fiIdHoSo;

	private String fiDispatchNo;

	private String fiOrganization;

	private String fiAddress;

	private String fiApplicationNo;

	private Date fiSignDate;



	private Date fiImportTimeFrom;



	private Date fiImportTimeTo;
	private String fiGates;

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

	private String fiNote;

	private Date fiSignConfirmDate;

	private String fiSignConfirmName;

	private String fiSignConfirmPosition;

	private String fiSignConfirmAddress;

	//

	private String fiExperimentCode;



	private String fiExperimentName;

	private String fiDownloadUrl;

	private String fiResult;

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

	public String getFiDispatchNo() {
		return fiDispatchNo;
	}

	public void setFiDispatchNo(String fiDispatchNo) {
		this.fiDispatchNo = fiDispatchNo;
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



	public Date getFiImportTimeFrom() {
		return fiImportTimeFrom;
	}

	public void setFiImportTimeFrom(Date fiImportTimeFrom) {
		this.fiImportTimeFrom = fiImportTimeFrom;
	}

	public Date getFiImportTimeTo() {
		return fiImportTimeTo;
	}

	public void setFiImportTimeTo(Date fiImportTimeTo) {
		this.fiImportTimeTo = fiImportTimeTo;
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

	public String getFiNote() {
		return fiNote;
	}

	public void setFiNote(String fiNote) {
		this.fiNote = fiNote;
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
	public String getFiExperimentCode() {
		return fiExperimentCode;
	}

	public void setFiExperimentCode(String fiExperimentCode) {
		this.fiExperimentCode = fiExperimentCode;
	}

	public String getFiExperimentName() {
		return fiExperimentName;
	}

	public void setFiExperimentName(String fiExperimentName) {
		this.fiExperimentName = fiExperimentName;
	}

	public String getFiDownloadUrl() {
		return fiDownloadUrl;
	}

	public void setFiDownloadUrl(String fiDownloadUrl) {
		this.fiDownloadUrl = fiDownloadUrl;
	}

	public String getFiResult() {
		return fiResult;
	}

	public void setFiResult(String fiResult) {
		this.fiResult = fiResult;
	}

	public String getFiSignConfirmAddress() {
		return fiSignConfirmAddress;
	}

	public void setFiSignConfirmAddress(String fiSignConfirmAddress) {
		this.fiSignConfirmAddress = fiSignConfirmAddress;
	}

	@Override
	public String toString() {
		return "TbdGiayPhep18{" +
				"fiId=" + fiId +
				", fiIdHoSo=" + fiIdHoSo +
				", fiDispatchNo='" + fiDispatchNo + '\'' +
				", fiOrganization='" + fiOrganization + '\'' +
				", fiAddress='" + fiAddress + '\'' +
				", fiApplicationNo='" + fiApplicationNo + '\'' +
				", fiSignDate=" + fiSignDate +
				", fiImportTimeFrom=" + fiImportTimeFrom +
				", fiImportTimeTo=" + fiImportTimeTo +
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
				", fiCMSIssueBy='" + fiCMSIssueBy + '\'' +
				", fiInvoiceNo='" + fiInvoiceNo + '\'' +
				", fiBillNo='" + fiBillNo + '\'' +
				", fiDeclarationNo='" + fiDeclarationNo + '\'' +
				", fiCONo='" + fiCONo + '\'' +
				", fiCFSNo='" + fiCFSNo + '\'' +
				", fiTechRegul='" + fiTechRegul + '\'' +
				", fiApplyRegul='" + fiApplyRegul + '\'' +
				", fiNote='" + fiNote + '\'' +
				", fiSignConfirmDate=" + fiSignConfirmDate +
				", fiSignConfirmName='" + fiSignConfirmName + '\'' +
				", fiSignConfirmPosition='" + fiSignConfirmPosition + '\'' +
				", fiSignConfirmAddress='" + fiSignConfirmAddress + '\'' +
				", fiExperimentName='" + fiExperimentName + '\'' +
				", fiExperimentCode='" + fiExperimentCode + '\'' +
				", fiResult='" + fiResult +
				'}';
	}


}
