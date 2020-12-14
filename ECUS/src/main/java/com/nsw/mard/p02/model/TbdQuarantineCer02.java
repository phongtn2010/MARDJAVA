/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.mard.p02.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Fujitsu
 */
public class TbdQuarantineCer02  {

    private Long quarantineCerId;
    private String nswFilecode;
    private Long typeProduct;
    private String dispatchNo;
    private String summary;
    private String companyname;
    private String preamble;
    private String importGate;
    private String exportGate;
    private String executionTime;
    private String responseContent;
    private String recipient;
    private Date signConfirmDate;
    private String signConfirmName;
    private String signConfirmLocation;
    private String signConfirmAddress;
    private String reasonEdit;
    private List<TbdGoodlist02> hanghoa;

    public TbdQuarantineCer02() {
    }

    public TbdQuarantineCer02(Long quarantineCerId) {
        this.quarantineCerId = quarantineCerId;
    }

    public Long getQuarantineCerId() {
        return quarantineCerId;
    }

    public void setQuarantineCerId(Long quarantineCerId) {
        this.quarantineCerId = quarantineCerId;
    }

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public Long getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(Long typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDispatchNo() {
        return dispatchNo;
    }

    public void setDispatchNo(String dispatchNo) {
        this.dispatchNo = dispatchNo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }

    public String getImportGate() {
        return importGate;
    }

    public void setImportGate(String importGate) {
        this.importGate = importGate;
    }

    public String getExportGate() {
        return exportGate;
    }

    public void setExportGate(String exportGate) {
        this.exportGate = exportGate;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getSignConfirmDate() {
        return signConfirmDate;
    }

    public void setSignConfirmDate(Date signConfirmDate) {
        this.signConfirmDate = signConfirmDate;
    }

    public String getSignConfirmName() {
        return signConfirmName;
    }

    public void setSignConfirmName(String signConfirmName) {
        this.signConfirmName = signConfirmName;
    }

    public String getSignConfirmLocation() {
        return signConfirmLocation;
    }

    public void setSignConfirmLocation(String signConfirmLocation) {
        this.signConfirmLocation = signConfirmLocation;
    }

    public String getSignConfirmAddress() {
        return signConfirmAddress;
    }

    public void setSignConfirmAddress(String signConfirmAddress) {
        this.signConfirmAddress = signConfirmAddress;
    }

    public String getReasonEdit() {
        return reasonEdit;
    }

    public void setReasonEdit(String reasonEdit) {
        this.reasonEdit = reasonEdit;
    }

    public List<TbdGoodlist02> getHanghoa() {
        return hanghoa;
    }

    public void setHanghoa(List<TbdGoodlist02> hanghoa) {
        this.hanghoa = hanghoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quarantineCerId != null ? quarantineCerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdQuarantineCer02)) {
            return false;
        }
        TbdQuarantineCer02 other = (TbdQuarantineCer02) object;
        if ((this.quarantineCerId == null && other.quarantineCerId != null) || (this.quarantineCerId != null && !this.quarantineCerId.equals(other.quarantineCerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p02.model.TbdQuarantineCer02[ quarantineCerId=" + quarantineCerId + " ]";
    }
    
}
