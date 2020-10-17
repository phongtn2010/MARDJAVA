package com.nsw.ws.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Phongnv9
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Header")
public class Header {

    public Header() {
    }

    @XmlElement(name = "Reference")
    private Reference Reference;
    @XmlElement(name = "From")
    private From From;
    @XmlElement(name = "To")
    private From To;
    @XmlElement(name = "Subject")
    private Subject Subject;

    public From getTo() {
        return To;
    }

    public void setTo(From To) {
        this.To = To;
    }

    public Subject getSubject() {
        return Subject;
    }

    public void setSubject(Subject Subject) {
        this.Subject = Subject;
    }

    public Reference getReference() {
        return Reference;
    }

    public void setReference(Reference Reference) {
        this.Reference = Reference;
    }

    public From getFrom() {
        return From;
    }

    public void setFrom(From From) {
        this.From = From;
    }

}
