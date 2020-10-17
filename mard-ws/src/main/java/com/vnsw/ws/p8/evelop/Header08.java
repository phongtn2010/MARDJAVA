package com.vnsw.ws.p8.evelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
public class Header08 {

    public Header08() {
    }

    @XmlElement(name = "Reference")
    private Reference08 Reference;
    @XmlElement(name = "From")
    private From08 From;
    @XmlElement(name = "To")
    private From08 To;
    @XmlElement(name = "Subject")
    private Subject08 Subject;

    public From08 getTo() {
        return To;
    }

    public void setTo(From08 To) {
        this.To = To;
    }

    public Subject08 getSubject() {
        return Subject;
    }

    public void setSubject(Subject08 Subject) {
        this.Subject = Subject;
    }

    public Reference08 getReference() {
        return Reference;
    }

    public void setReference(Reference08 Reference) {
        this.Reference = Reference;
    }

    public From08 getFrom() {
        return From;
    }

    public void setFrom(From08 From) {
        this.From = From;
    }

}
