package com.vnsw.ws.p1.evelop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
public class Header01 {

    public Header01() {
    }

    @XmlElement(name = "Reference")
    private Reference01 Reference;
    @XmlElement(name = "From")
    private From01 From;
    @XmlElement(name = "To")
    private From01 To;
    @XmlElement(name = "Subject")
    private Subject01 Subject;

    public From01 getTo() {
        return To;
    }

    public void setTo(From01 To) {
        this.To = To;
    }

    public Subject01 getSubject() {
        return Subject;
    }

    public void setSubject(Subject01 Subject) {
        this.Subject = Subject;
    }

    public Reference01 getReference() {
        return Reference;
    }

    public void setReference(Reference01 Reference) {
        this.Reference = Reference;
    }

    public From01 getFrom() {
        return From;
    }

    public void setFrom(From01 From) {
        this.From = From;
    }

}
