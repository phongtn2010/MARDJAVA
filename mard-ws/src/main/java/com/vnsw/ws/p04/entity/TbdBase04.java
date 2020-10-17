/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Base")
public class TbdBase04 {
    @XmlTransient
    private Long baseId;
    @XmlElement(name = "LicenseOfPhytosanitaryImport")
    private Long licenseOfPhytosanitary;
    @XmlElement(name = "LicenseOfPhytosanitaryImportNo")
    private String licenseOfPhytosanitaryNo;
    @XmlElement(name = "RegistrationCertificate")
    private Long registrationCertificate;
    @XmlElement(name = "CertificatePhytosanitaryExport")
    private Long certificatePhytosanitary;
    @XmlElement(name = "LaboratoryAnalysis")
    private Long laboratoryAnalysis;
    @XmlElement(name = "ProcessedWoodExport")
    private Long processedWoodExport;
    @XmlElement(name = "OtherBase")
    private Long otherBase;
    @XmlElement(name = "OtherBaseContent")
    private String otherBaseContent;
    @XmlTransient
    private Long phytosanitaryResultId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date createDate;

    public TbdBase04() {
    }

    public TbdBase04(Long baseId) {
        this.baseId = baseId;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getLicenseOfPhytosanitary() {
        return licenseOfPhytosanitary;
    }

    public void setLicenseOfPhytosanitary(Long licenseOfPhytosanitary) {
        this.licenseOfPhytosanitary = licenseOfPhytosanitary;
    }

    public String getLicenseOfPhytosanitaryNo() {
        return licenseOfPhytosanitaryNo;
    }

    public void setLicenseOfPhytosanitaryNo(String licenseOfPhytosanitaryNo) {
        this.licenseOfPhytosanitaryNo = licenseOfPhytosanitaryNo;
    }

    public Long getRegistrationCertificate() {
        return registrationCertificate;
    }

    public void setRegistrationCertificate(Long registrationCertificate) {
        this.registrationCertificate = registrationCertificate;
    }

    public Long getCertificatePhytosanitary() {
        return certificatePhytosanitary;
    }

    public void setCertificatePhytosanitary(Long certificatePhytosanitary) {
        this.certificatePhytosanitary = certificatePhytosanitary;
    }

    public Long getLaboratoryAnalysis() {
        return laboratoryAnalysis;
    }

    public void setLaboratoryAnalysis(Long laboratoryAnalysis) {
        this.laboratoryAnalysis = laboratoryAnalysis;
    }

    public Long getProcessedWoodExport() {
        return processedWoodExport;
    }

    public void setProcessedWoodExport(Long processedWoodExport) {
        this.processedWoodExport = processedWoodExport;
    }

    public Long getOtherBase() {
        return otherBase;
    }

    public void setOtherBase(Long otherBase) {
        this.otherBase = otherBase;
    }

    public String getOtherBaseContent() {
        return otherBaseContent;
    }

    public void setOtherBaseContent(String otherBaseContent) {
        this.otherBaseContent = otherBaseContent;
    }

    public Long getPhytosanitaryResultId() {
        return phytosanitaryResultId;
    }

    public void setPhytosanitaryResultId(Long phytosanitaryResultId) {
        this.phytosanitaryResultId = phytosanitaryResultId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baseId != null ? baseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdBase04)) {
            return false;
        }
        TbdBase04 other = (TbdBase04) object;
        if ((this.baseId == null && other.baseId != null) || (this.baseId != null && !this.baseId.equals(other.baseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdBase04[ baseId=" + baseId + " ]";
    }
    
}
