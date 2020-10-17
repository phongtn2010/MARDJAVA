/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p04.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Fujitsu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestCancel")
public class DNYeucauRut {
    @XmlElement(name = "NSWFileCode")
    private String NSWFileCode;
    @XmlElement(name = "RequestDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date RequestDate;
    @XmlElement(name = "Reason")
    private String Reason;

    public String getNSWFileCode() {
        return NSWFileCode;
    }

    public void setNSWFileCode(String NSWFileCode) {
        this.NSWFileCode = NSWFileCode;
    }

    public Date getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(Date RequestDate) {
        this.RequestDate = RequestDate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }


}
