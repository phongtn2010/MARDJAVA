package com.vnsw.ws.p12.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
public class Header12 {

    public Header12() {
    }

    @XmlElement(name = "Reference")
    private Reference12 Reference;
    @XmlElement(name = "From")
    private From12 From;
    @XmlElement(name = "To")
    private From12 To;
    @XmlElement(name = "Subject")
    private Subject12 Subject;

    public Reference12 getReference() {
        return Reference;
    }

    public void setReference(Reference12 Reference) {
        this.Reference = Reference;
    }

    public From12 getFrom() {
        return From;
    }

    public void setFrom(From12 From) {
        this.From = From;
    }

    public From12 getTo() {
        return To;
    }

    public void setTo(From12 To) {
        this.To = To;
    }

    public Subject12 getSubject() {
        return Subject;
    }

    public void setSubject(Subject12 Subject) {
        this.Subject = Subject;
    }



}
