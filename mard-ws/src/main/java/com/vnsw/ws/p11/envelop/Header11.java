package com.vnsw.ws.p11.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
public class Header11 {

    public Header11() {
    }

    @XmlElement(name = "Reference")
    private Reference11 Reference;
    @XmlElement(name = "From")
    private From11 From;
    @XmlElement(name = "To")
    private From11 To;
    @XmlElement(name = "Subject")
    private Subject11 Subject;

    public From11 getTo() {
        return To;
    }

    public void setTo(From11 To) {
        this.To = To;
    }

    public Subject11 getSubject() {
        return Subject;
    }

    public void setSubject(Subject11 Subject) {
        this.Subject = Subject;
    }

    public Reference11 getReference() {
        return Reference;
    }

    public void setReference(Reference11 Reference) {
        this.Reference = Reference;
    }

    public From11 getFrom() {
        return From;
    }

    public void setFrom(From11 From) {
        this.From = From;
    }

}
