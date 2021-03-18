package com.nsw.backend.vroot.message25;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
@Data
public class Header25 {

    public Header25() {
    }

    @XmlElement(name = "Reference")
    private Reference25 Reference;
    @XmlElement(name = "From")
    private From25 From;
    @XmlElement(name = "To")
    private From25 To;
    @XmlElement(name = "Subject")
    private Subject25 Subject;

    public From25 getTo() {
        return To;
    }

    public void setTo(From25 To) {
        this.To = To;
    }

    public Subject25 getSubject() {
        return Subject;
    }

    public void setSubject(Subject25 Subject) {
        this.Subject = Subject;
    }

    public Reference25 getReference() {
        return Reference;
    }

    public void setReference(Reference25 Reference) {
        this.Reference = Reference;
    }

    public From25 getFrom() {
        return From;
    }

    public void setFrom(From25 From) {
        this.From = From;
    }



}
