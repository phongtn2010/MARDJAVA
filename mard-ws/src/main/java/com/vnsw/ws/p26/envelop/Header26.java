package com.vnsw.ws.p26.envelop;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
@Data
public class Header26 {

    public Header26() {
    }

    @XmlElement(name = "Reference")
    private Reference26 Reference;
    @XmlElement(name = "From")
    private From26 From;
    @XmlElement(name = "To")
    private From26 To;
    @XmlElement(name = "Subject")
    private Subject26 Subject;

    public From26 getTo() {
        return To;
    }

    public void setTo(From26 To) {
        this.To = To;
    }

    public Subject26 getSubject() {
        return Subject;
    }

    public void setSubject(Subject26 Subject) {
        this.Subject = Subject;
    }

    public Reference26 getReference() {
        return Reference;
    }

    public void setReference(Reference26 Reference) {
        this.Reference = Reference;
    }

    public From26 getFrom() {
        return From;
    }

    public void setFrom(From26 From) {
        this.From = From;
    }



}
