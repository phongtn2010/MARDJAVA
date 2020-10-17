/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.entity;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TreatmentMeasures")
public class TbdTreatmentMeasures04  {
    @XmlTransient
    private Long treatmentId;
    @XmlElement(name = "Fumigation")
    private Long fumigation;
    @XmlElement(name = "Fumigant")
    private String fumigant;
    @XmlElement(name = "FumigationDateFrom")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date fumigationDateFrom;
    @XmlElement(name = "FumigationDateTo")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date fumigationDateTo;
    @XmlElement(name = "Place")
    private String place;
    @XmlElement(name = "Regulations")
    private String regulations;
    @XmlElement(name = "Reexport")
    private Long reexPort;
    @XmlElement(name = "ReexportDateFrom")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date reexportDateFrom;
    @XmlElement(name = "ReexportDateTo")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date reexportDateTo;
    @XmlElement(name = "Destroy")
    private Long destroy;
    @XmlElement(name = "DestroyDateFrom")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date destroyDateFrom;
    @XmlElement(name = "DestroyDateTo")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date destroyDateTo;
    @XmlElement(name = "OtherMeasures")
    private Long otherMeasures;
    @XmlElement(name = "OtherMeasuresContent")
    private String otherMeasuresContent;
    @XmlElement(name = "OtherMeasuresFrom")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date otherMeasuresFrom;
    @XmlElement(name = "OtherMeasuresTo")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date otherMeasuresTo;
    @XmlTransient
    private Long phytosanitaryId;
    @XmlTransient
    private Long isActive;
    @XmlTransient
    private String createBy;

    public TbdTreatmentMeasures04() {
    }

    public TbdTreatmentMeasures04(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }

    public Long getFumigation() {
        return fumigation;
    }

    public void setFumigation(Long fumigation) {
        this.fumigation = fumigation;
    }

    public Date getFumigationDateFrom() {
        return fumigationDateFrom;
    }

    public void setFumigationDateFrom(Date fumigationDateFrom) {
        this.fumigationDateFrom = fumigationDateFrom;
    }

    public Date getFumigationDateTo() {
        return fumigationDateTo;
    }

    public void setFumigationDateTo(Date fumigationDateTo) {
        this.fumigationDateTo = fumigationDateTo;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }

    public Long getReexPort() {
        return reexPort;
    }

    public void setReexPort(Long reexPort) {
        this.reexPort = reexPort;
    }

    public Date getReexportDateFrom() {
        return reexportDateFrom;
    }

    public void setReexportDateFrom(Date reexportDateFrom) {
        this.reexportDateFrom = reexportDateFrom;
    }

    public Date getReexportDateTo() {
        return reexportDateTo;
    }

    public void setReexportDateTo(Date reexportDateTo) {
        this.reexportDateTo = reexportDateTo;
    }

   

    public Long getDestroy() {
        return destroy;
    }

    public void setDestroy(Long destroy) {
        this.destroy = destroy;
    }

    public Date getDestroyDateFrom() {
        return destroyDateFrom;
    }

    public void setDestroyDateFrom(Date destroyDateFrom) {
        this.destroyDateFrom = destroyDateFrom;
    }

    public Date getDestroyDateTo() {
        return destroyDateTo;
    }

    public void setDestroyDateTo(Date destroyDateTo) {
        this.destroyDateTo = destroyDateTo;
    }

    public Long getOtherMeasures() {
        return otherMeasures;
    }

    public void setOtherMeasures(Long otherMeasures) {
        this.otherMeasures = otherMeasures;
    }

    public Date getOtherMeasuresFrom() {
        return otherMeasuresFrom;
    }

    public void setOtherMeasuresFrom(Date otherMeasuresFrom) {
        this.otherMeasuresFrom = otherMeasuresFrom;
    }

    public Date getOtherMeasuresTo() {
        return otherMeasuresTo;
    }

    public void setOtherMeasuresTo(Date otherMeasuresTo) {
        this.otherMeasuresTo = otherMeasuresTo;
    }

    public Long getPhytosanitaryId() {
        return phytosanitaryId;
    }

    public void setPhytosanitaryId(Long phytosanitaryId) {
        this.phytosanitaryId = phytosanitaryId;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getOtherMeasuresContent() {
        return otherMeasuresContent;
    }

    public void setOtherMeasuresContent(String otherMeasuresContent) {
        this.otherMeasuresContent = otherMeasuresContent;
    }

    public String getFumigant() {
        return fumigant;
    }

    public void setFumigant(String fumigant) {
        this.fumigant = fumigant;
    }

    
}
