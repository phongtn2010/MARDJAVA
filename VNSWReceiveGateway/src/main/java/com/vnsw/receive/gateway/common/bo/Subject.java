package com.vnsw.receive.gateway.common.bo;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author PhongNV9
 */
@XmlType(name = "Subject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {

    public Subject() {

    }

    public Subject(String documentType, String type, String function, String reference, String documentYear, String sendDate) {
        this.documentType = documentType;
    	this.type = type;
        this.function = function;
        this.reference = reference;
        this.documentYear = documentYear;
        this.sendDate = sendDate;
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
}