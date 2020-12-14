package com.nsw.mard.p19.model;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TbdThongBaoKetQua19DTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long fiId;

    private Long fiIdHoSo;

    private String fiDispatchNo;

    private String fiOrganization;

    private String fiAddress;

    private String fiApplicationNo;


    private String fiExperimentCode;

    private String fiExperimentName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+7")
    private Date fiImportTimeFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+7")
    private Date fiImportTimeTo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+7")
    private Date fiSignConfirmDate;


    private String fiSignConfirmAddress;

    private String fiSignConfirmPosition;


    private String fiSignConfirmName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+7")
    private Date fiSignDate;

    private String fiGates;

    private String fiNote;

    private String fiContractNo;

    private String fiGoodListNo;

    private String fiCQNo;

    private String fiCQOrganization;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+7")
    private Date fiCQDate;

    private String fiCQIssueBy;

    private String fiCMSNo;

    private String fiCMSOrganization;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+7")
    private Date fiCMSDate;

    private String fiCMSIssueBy;

    private String fiInvoiceNo;

    private String fiBillNo;

    private String fiDeclarationNo;

    private String fiCONo;

    private String fiCFSNo;

    private String fiTechRegul;

    private String fiApplyRegul;

    private String fiDownloadUrl;

    private String fiResult;

    private TbdHoSo19 tbdHoSo19;

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

    public Date getFiSignConfirmDate() {
        return fiSignConfirmDate;
    }

    public void setFiSignConfirmDate(Date fiSignConfirmDate) {
        this.fiSignConfirmDate = fiSignConfirmDate;
    }

    public String getFiSignConfirmAddress() {
        return fiSignConfirmAddress;
    }

    public void setFiSignConfirmAddress(String fiSignConfirmAddress) {
        this.fiSignConfirmAddress = fiSignConfirmAddress;
    }

    public String getFiSignConfirmPosition() {
        return fiSignConfirmPosition;
    }

    public void setFiSignConfirmPosition(String fiSignConfirmPosition) {
        this.fiSignConfirmPosition = fiSignConfirmPosition;
    }

    public String getFiSignConfirmName() {
        return fiSignConfirmName;
    }

    public void setFiSignConfirmName(String fiSignConfirmName) {
        this.fiSignConfirmName = fiSignConfirmName;
    }

    public Date getFiSignDate() {
        return fiSignDate;
    }

    public void setFiSignDate(Date fiSignDate) {
        this.fiSignDate = fiSignDate;
    }

    public String getFiGates() {
        return fiGates;
    }

    public void setFiGates(String fiGates) {
        this.fiGates = fiGates;
    }

    public String getFiNote() {
        return fiNote;
    }

    public void setFiNote(String fiNote) {
        this.fiNote = fiNote;
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

    public TbdHoSo19 getTbdHoSo19() {
        return tbdHoSo19;
    }

    public void setTbdHoSo19(TbdHoSo19 tbdHoSo19) {
        this.tbdHoSo19 = tbdHoSo19;
    }
    @Override
    public String toString() {
        return "TbdThongBaoKetQua19{" +
                "fiId=" + fiId +
                ", fiIdHoSo=" + fiIdHoSo +
                ", fiDispatchNo='" + fiDispatchNo + '\'' +
                ", fiOrganization='" + fiOrganization + '\'' +
                ", fiAddress='" + fiAddress + '\'' +
                ", fiApplicationNo='" + fiApplicationNo + '\'' +
                ", fiExperimentCode='" + fiExperimentCode + '\'' +
                ", fiExperimentName='" + fiExperimentName + '\'' +
                ", fiImportTimeFrom=" + fiImportTimeFrom +
                ", fiImportTimeTo=" + fiImportTimeTo +
                ", fiSignConfirmDate=" + fiSignConfirmDate +
                ", fiSignConfirmAddress='" + fiSignConfirmAddress + '\'' +
                ", fiSignConfirmPosition='" + fiSignConfirmPosition + '\'' +
                ", fiSignConfirmName='" + fiSignConfirmName + '\'' +
                ", fiSignDate=" + fiSignDate +
                ", fiGates='" + fiGates + '\'' +
                ", fiNote='" + fiNote + '\'' +
                ", fiContractNo='" + fiContractNo + '\'' +
                ", fiGoodListNo='" + fiGoodListNo + '\'' +
                ", fiCQNo='" + fiCQNo + '\'' +
                ", fiCOOrganization='" + fiCQOrganization + '\'' +
                ", fiCQDate=" + fiCQDate +
                ", fiIssueBy='" + fiCQIssueBy + '\'' +
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
                ", fiDownloadUrl='" + fiDownloadUrl + '\'' +
                ", fiResult='" + fiResult + '\'' +
                ", tbdHoSo19=" + tbdHoSo19 +
                '}';
    }


}
