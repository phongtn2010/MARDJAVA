package com.vnsw.ws.p7.evelope;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
@Data

public class Header07 {

    public Header07() {
    }

    @XmlElement(name = "Reference")
    private Reference07 Reference;
    @XmlElement(name = "From")
    private From07 From;
    @XmlElement(name = "To")
    private From07 To;
    @XmlElement(name = "Subject")
    private Subject07 Subject;

    public From07 getTo() {
        return To;
    }

    public void setTo(From07 To) {
        this.To = To;
    }

    public Subject07 getSubject() {
        return Subject;
    }

    public void setSubject(Subject07 Subject) {
        this.Subject = Subject;
    }

    public Reference07 getReference() {
        return Reference;
    }

    public void setReference(Reference07 Reference) {
        this.Reference = Reference;
    }

    public From07 getFrom() {
        return From;
    }

    public void setFrom(From07 From) {
        this.From = From;
    }

}
