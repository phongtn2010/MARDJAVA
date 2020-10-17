package com.vnsw.ws.p6.envelop;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
@Data
public class Header06 {

    public Header06() {
    }

    @XmlElement(name = "Reference")
    private Reference06 Reference;
    @XmlElement(name = "From")
    private From06 From;
    @XmlElement(name = "To")
    private From06 To;
    @XmlElement(name = "Subject")
    private Subject06 Subject;

    public From06 getTo() {
        return To;
    }

    public void setTo(From06 To) {
        this.To = To;
    }

    public Subject06 getSubject() {
        return Subject;
    }

    public void setSubject(Subject06 Subject) {
        this.Subject = Subject;
    }

    public Reference06 getReference() {
        return Reference;
    }

    public void setReference(Reference06 Reference) {
        this.Reference = Reference;
    }

    public From06 getFrom() {
        return From;
    }

    public void setFrom(From06 From) {
        this.From = From;
    }



}
