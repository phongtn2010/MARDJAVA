package com.vnsw.ws.p15.message;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;
@XmlRootElement(name = "GeneticLicense")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiOrganization", "fiAddress", "fiApplicationNo", "fiSignDate", "fiGoods", "fiTotalQuantity", "fiOtherContent", "fiDealineImport", "fiRecipients", "fiDispatchNo", "fiSignConfirmDate", "fiSignConfirmName", "fiSignConfirmPosition", "fiSignConfirmAddress"})
public class GeneticLicense {

    @XmlElement(name = "Organization", required = true)
    private String fiOrganization;

    @XmlElement(name = "Address", required = true)
    private String fiAddress;

    @XmlElement(name = "ApplicationNo", required = true)
    private String fiApplicationNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate", required = true)
    private Date fiSignDate;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods", required = true)
    private List<Goods> fiGoods;

    @XmlElement(name = "TotalQuantity", required = true)
    private String fiTotalQuantity;

    @XmlElement(name = "OtherContent")
    private String fiOtherContent;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DealineImport")
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

    public String getFiOtherContent() {
        return fiOtherContent;
    }

    public void setFiOtherContent(String fiOtherContent) {
        this.fiOtherContent = fiOtherContent;
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
