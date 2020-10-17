package com.vnsw.ws.p12.envelop;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Subject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject12 {

    public Subject12() {

    }

    public Subject12(String documentType, String type, String function, String reference, String documentYear, String sendDate, String preReference, String preDocumentYear) {
        this.documentType = documentType;
        this.type = type;
        this.function = function;
        this.reference = reference;
        this.documentYear = documentYear;
        this.sendDate = sendDate;
        this.preReference = preReference;
        this.preDocumentYear = preDocumentYear;
    }
    @XmlElement(name = "documentType")
    @Size(max = 100)
    private String documentType;
    @XmlElement(name = "type")
    @Size(max = 3)
    private String type;
    @XmlElement(name = "function")
    @Size(max = 3)
    private String function;
    @XmlElement(name = "reference")
    @Size(max = 35)
    private String reference;
    @XmlElement(name = "documentYear")
    @Size(max = 4)
    private String documentYear;
    
    @XmlElement(name = "preReference")
    @Size(max = 35)
    private String preReference;
    
    @XmlElement(name = "preDocumentYear")
    @Size(max = 4)
    private String preDocumentYear;
    
    @XmlElement(name = "sendDate")
    @Size(max = 50)
    private String sendDate;

    public void setDocumentYear(String documentYear) {
        this.documentYear = documentYear;
    }

    public String getDocumentYear() {
        return documentYear;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public String getPreReference() {
        return preReference;
    }

    public void setPreReference(String preReference) {
        this.preReference = preReference;
    }

    public String getPreDocumentYear() {
        return preDocumentYear;
    }

    public void setPreDocumentYear(String preDocumentYear) {
        this.preDocumentYear = preDocumentYear;
    }
    
}
