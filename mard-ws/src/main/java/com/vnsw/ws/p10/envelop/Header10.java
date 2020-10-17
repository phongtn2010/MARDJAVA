package com.vnsw.ws.p10.envelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
public class Header10 {

    public Header10() {
    }

    @XmlElement(name = "Reference")
    private Reference10 Reference;
    @XmlElement(name = "From")
    private From10 From;
    @XmlElement(name = "To")
    private From10 To;
    @XmlElement(name = "Subject")
    private Subject10 Subject;

    public From10 getTo() {
        return To;
    }

    public void setTo(From10 To) {
        this.To = To;
    }

    public Subject10 getSubject() {
        return Subject;
    }

    public void setSubject(Subject10 Subject) {
        this.Subject = Subject;
    }

    public Reference10 getReference() {
        return Reference;
    }

    public void setReference(Reference10 Reference) {
        this.Reference = Reference;
    }

    public From10 getFrom() {
        return From;
    }

    public void setFrom(From10 From) {
        this.From = From;
    }

}
