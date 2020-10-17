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
@XmlType(name = "Certificate")
public class TbdCertificate04  {
    @XmlTransient
    private Long certificateId;
    @XmlElement(name = "Undiscovered")
    private Long undiscovered;
    @XmlElement(name = "ObjectsPhytosanitary")
    private Long objectsPhytosanitary;
    @XmlElement(name = "ObjectsPhytosanitaryContent")
    private String objectsPhytosanitaryContent;
    @XmlElement(name = "DetectingOrganisms")
    private Long detectingOrganisms;
    @XmlElement(name = "LocationAllow")
    private Long locationAllow;
    @XmlElement(name = "LocationAllowContent")
    private String locationAllowContent;
    @XmlTransient
    private Long phytosanitaryResultId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private Date createDate;

    public TbdCertificate04() {
    }

    public TbdCertificate04(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getUndiscovered() {
        return undiscovered;
    }

    public void setUndiscovered(Long undiscovered) {
        this.undiscovered = undiscovered;
    }

    public Long getObjectsPhytosanitary() {
        return objectsPhytosanitary;
    }

    public void setObjectsPhytosanitary(Long objectsPhytosanitary) {
        this.objectsPhytosanitary = objectsPhytosanitary;
    }

    public String getObjectsPhytosanitaryContent() {
        return objectsPhytosanitaryContent;
    }

    public void setObjectsPhytosanitaryContent(String objectsPhytosanitaryContent) {
        this.objectsPhytosanitaryContent = objectsPhytosanitaryContent;
    }

    public Long getDetectingOrganisms() {
        return detectingOrganisms;
    }

    public void setDetectingOrganisms(Long detectingOrganisms) {
        this.detectingOrganisms = detectingOrganisms;
    }

    public Long getLocationAllow() {
        return locationAllow;
    }

    public void setLocationAllow(Long locationAllow) {
        this.locationAllow = locationAllow;
    }

    public String getLocationAllowContent() {
        return locationAllowContent;
    }

    public void setLocationAllowContent(String locationAllowContent) {
        this.locationAllowContent = locationAllowContent;
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
        hash += (certificateId != null ? certificateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbdCertificate04)) {
            return false;
        }
        TbdCertificate04 other = (TbdCertificate04) object;
        if ((this.certificateId == null && other.certificateId != null) || (this.certificateId != null && !this.certificateId.equals(other.certificateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsw.backend.mard.p04.model.TbdCertificate04[ certificateId=" + certificateId + " ]";
    }
    
}
