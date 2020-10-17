package com.vnsw.ws.p16.message;

import com.vnsw.ws.annotations.DateSerialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "Application")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fiApplicationNo", "fiNameOfRegistration", "fiAddressOfRegistration", "fiPhone", "fiEmail","fiFax", "fiGoods", "fiTotalQuantity", "fiImportTime", "fiDeadlineImport", "fiPurposes", "fiOthers", "fiRelatedDocuments",  "fiSign", "fiAttachment"})
public class Application {

    @XmlElement(name = "ApplicationNo", required = true)
    private String fiApplicationNo;

    @XmlElement(name = "NameOfRegistration", required = true)
    private String fiNameOfRegistration;

    @XmlElement(name = "AddressOfRegistration", required = true)
    private String fiAddressOfRegistration;

    @XmlElement(name = "Phone")
    private String fiPhone;

    @XmlElement(name = "Email")
    private String fiEmail;

    @XmlElement(name = "Fax")
    private String fiFax;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods", required = true)
    private List<Goods> fiGoods;

    @XmlElement(name = "TotalQuantity", required = true)
    private String fiTotalQuantity;

    @XmlElement(name = "ImportTime", required = true)
    private Integer fiImportTime;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DeadlineImport", required = true)
    private Date fiDeadlineImport;

    @XmlElement(name = "Purposes")
    private Purposes fiPurposes;

    @XmlElement(name = "Others")
    private Others fiOthers;

    @XmlElement(name = "RelatedDocuments")
    private RelatedDocuments fiRelatedDocuments;

    @XmlElement(name = "Sign", required = true)
    private Sign fiSign;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment", required = true)
    private List<Attachment> fiAttachment;

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

    public Integer getFiImportTime() {
        return fiImportTime;
    }

    public void setFiImportTime(Integer fiImportTime) {
        this.fiImportTime = fiImportTime;
    }

    public Date getFiDeadlineImport() {
        return fiDeadlineImport;
    }

    public void setFiDeadlineImport(Date fiDeadlineImport) {
        this.fiDeadlineImport = fiDeadlineImport;
    }

    public Purposes getFiPurposes() {
        return fiPurposes;
    }

    public void setFiPurposes(Purposes fiPurposes) {
        this.fiPurposes = fiPurposes;
    }

    public Others getFiOthers() {
        return fiOthers;
    }

    public void setFiOthers(Others fiOthers) {
        this.fiOthers = fiOthers;
    }

    public RelatedDocuments getFiRelatedDocuments() {
        return fiRelatedDocuments;
    }

    public void setFiRelatedDocuments(RelatedDocuments fiRelatedDocuments) {
        this.fiRelatedDocuments = fiRelatedDocuments;
    }

    public List<Attachment> getFiAttachment() {
        return fiAttachment;
    }

    public void setFiAttachment(List<Attachment> fiAttachment) {
        this.fiAttachment = fiAttachment;
    }

    public Sign getFiSign() {
        return fiSign;
    }

    public void setFiSign(Sign fiSign) {
        this.fiSign = fiSign;
    }
}
