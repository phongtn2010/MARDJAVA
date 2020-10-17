package com.vnsw.ws.p16.message;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "VarietyLicense")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiOrganization", "fiAddress", "fiApplicationNo", "fiSignDate","fiBase","fiPurposes", "fiGoods", "fiTotalQuantity", "fiScale", "fiLocation", "fiLawBase", "fiReport", "fiDealineImport", "fiRecipients","fiDispatchNo", "fiSignConfirmDate", "fiSignConfirmName", "fiSignConfirmPosition", "fiSignConfirmAddress"})
public class VarietyLicense {

    @XmlElement(name = "Organization", required = true)
    private String fiOrganization;

    @XmlElement(name = "Address", required = true)
    private String fiAddress;

    @XmlElement(name = "ApplicationNo", required = true)
    private String fiApplicationNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate", required = true)
    private Date fiSignDate;

    @XmlElement(name = "Base", required = true)
    private String fiBase;
    @XmlElement(name = "Purposes", required = true)
    private String fiPurposes;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods", required = true)
    private List<Goods> fiGoods;
    @XmlElement(name = "TotalQuantity", required = true)
    private String fiTotalQuantity;

    @XmlElement(name = "Scale")
    private String fiScale;

    @XmlElement(name = "Location")
    private String fiLocation;
    @XmlElement(name = "LawBase")
    private String fiLawBase;
    @XmlElement(name = "Report")
    private String fiReport;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DealineImport", required = true)
    private Date fiDealineImport;
    @XmlElement(name = "Recipients")
    private String fiRecipients;

    @XmlElement(name = "DispatchNo", required = true)
    private String fiDispatchNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate", required = true)
    private Date fiSignConfirmDate;

    @XmlElement(name = "SignConfirmName", required = true)
    private String fiSignConfirmName;

    @XmlElement(name = "SignConfirmPosition", required = true)
    private String fiSignConfirmPosition;

    @XmlElement(name = "SignConfirmAddress", required = true)
    private String fiSignConfirmAddress;

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

    public String getFiBase() {
        return fiBase;
    }

    public void setFiBase(String fiBase) {
        this.fiBase = fiBase;
    }

    public String getFiPurposes() {
        return fiPurposes;
    }

    public void setFiPurposes(String fiPurposes) {
        this.fiPurposes = fiPurposes;
    }

    public List<Goods> getFiGoods() {
        return fiGoods;
    }

    public void setFiGoods(List<Goods> fiGoods) {
        this.fiGoods = fiGoods;
    }

    public String getFiTotalQuantity() {
        return fiTotalQuantity;
    }

    public void setFiTotalQuantity(String fiTotalQuantity) {
        this.fiTotalQuantity = fiTotalQuantity;
    }

    public String getFiScale() {
        return fiScale;
    }

    public void setFiScale(String fiScale) {
        this.fiScale = fiScale;
    }

    public String getFiLocation() {
        return fiLocation;
    }

    public void setFiLocation(String fiLocation) {
        this.fiLocation = fiLocation;
    }

    public String getFiLawBase() {
        return fiLawBase;
    }

    public void setFiLawBase(String fiLawBase) {
        this.fiLawBase = fiLawBase;
    }

    public String getFiReport() {
        return fiReport;
    }

    public void setFiReport(String fiReport) {
        this.fiReport = fiReport;
    }

    public Date getFiDealineImport() {
        return fiDealineImport;
    }

    public void setFiDealineImport(Date fiDealineImport) {
        this.fiDealineImport = fiDealineImport;
    }

    public String getFiRecipients() {
        return fiRecipients;
    }

    public void setFiRecipients(String fiRecipients) {
        this.fiRecipients = fiRecipients;
    }

    public String getFiDispatchNo() {
        return fiDispatchNo;
    }

    public void setFiDispatchNo(String fiDispatchNo) {
        this.fiDispatchNo = fiDispatchNo;
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

    public String getFiSignConfirmAddress() {
        return fiSignConfirmAddress;
    }

    public void setFiSignConfirmAddress(String fiSignConfirmAddress) {
        this.fiSignConfirmAddress = fiSignConfirmAddress;
    }
}
