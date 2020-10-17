package com.vnsw.ws.p15.message;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Application")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiApplicationNo", "fiNameOfRegistration", "fiAddressOfRegistration", "fiPhone", "fiEmail", "fiFax", "fiGoods", "fiTotalQuantity", "fiPurposes", "fiOtherPurposeDetail", "fiOrganizationReceiving", "fiSummaryOfNumber", "fiTimeImport", "fiSignAddress", "fiSignDate", "fiSignName", "fiSignerPosition"})
public class Application {

    @XmlElement(name = "ApplicationNo", required = true)
    private String fiApplicationNo;

    @XmlElement(name = "NameOfRegistration", required = true)
    private String fiNameOfRegistration;

    @XmlElement(name = "AddressOfRegistration", required = true)
    private String fiAddressOfRegistration;

    @XmlElement(name = "Phone", required = true)
    private String fiPhone;

    @XmlElement(name = "Email", required = true)
    private String fiEmail;

    @XmlElement(name = "Fax")
    private String fiFax;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods", required = true)
    private List<Goods> fiGoods;

    @XmlElement(name = "TotalQuantity", required = true)
    private String fiTotalQuantity;

    @XmlElement(name = "Purposes", required = true)
    private String fiPurposes;

    @XmlElement(name = "OtherPurposeDetail")
    private String fiOtherPurposeDetail;

    @XmlElement(name = "OrganizationReceiving")
    private String fiOrganizationReceiving;

    @XmlElement(name = "SummaryOfNumber")
    private String fiSummaryOfNumber;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TimeImport")
    private Date fiTimeImport;

    @XmlElement(name = "SignAddress", required = true)
    private String fiSignAddress;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    private Date fiSignDate;

    @XmlElement(name = "SignName", required = true)
    private String fiSignName;

    @XmlElement(name = "SignerPosition", required = true)
    private String fiSignerPosition;

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

    public String getFiPurposes() {
        return fiPurposes;
    }

    public void setFiPurposes(String fiPurposes) {
        this.fiPurposes = fiPurposes;
    }

    public String getFiOtherPurposeDetail() {
        return fiOtherPurposeDetail;
    }

    public void setFiOtherPurposeDetail(String fiOtherPurposeDetail) {
        this.fiOtherPurposeDetail = fiOtherPurposeDetail;
    }

    public String getFiOrganizationReceiving() {
        return fiOrganizationReceiving;
    }

    public void setFiOrganizationReceiving(String fiOrganizationReceiving) {
        this.fiOrganizationReceiving = fiOrganizationReceiving;
    }

    public String getFiSummaryOfNumber() {
        return fiSummaryOfNumber;
    }

    public void setFiSummaryOfNumber(String fiSummaryOfNumber) {
        this.fiSummaryOfNumber = fiSummaryOfNumber;
    }

    public Date getFiTimeImport() {
        return fiTimeImport;
    }

    public void setFiTimeImport(Date fiTimeImport) {
        this.fiTimeImport = fiTimeImport;
    }

    public String getFiSignAddress() {
        return fiSignAddress;
    }

    public void setFiSignAddress(String fiSignAddress) {
        this.fiSignAddress = fiSignAddress;
    }

    public Date getFiSignDate() {
        return fiSignDate;
    }

    public void setFiSignDate(Date fiSignDate) {
        this.fiSignDate = fiSignDate;
    }

    public String getFiSignName() {
        return fiSignName;
    }

    public void setFiSignName(String fiSignName) {
        this.fiSignName = fiSignName;
    }

    public String getFiSignerPosition() {
        return fiSignerPosition;
    }

    public void setFiSignerPosition(String fiSignerPosition) {
        this.fiSignerPosition = fiSignerPosition;
    }
}
