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
@XmlType(name = "RequestEditCer")
public class DNYeucauSuaXNCL {
    @XmlElement(name = "NSWFileCode")
    private String nswFilecode;
    @XmlElement(name = "RequestDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date requestDate;
    @XmlElement(name = "Reason")
    private String reason;
    @XmlElement(name = "RegistrationProfile")
    private TbdRegistrationProfile04 registrationProfile04;

    public String getNswFilecode() {
        return nswFilecode;
    }

    public void setNswFilecode(String nswFilecode) {
        this.nswFilecode = nswFilecode;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public TbdRegistrationProfile04 getRegistrationProfile04() {
        return registrationProfile04;
    }

    public void setRegistrationProfile04(TbdRegistrationProfile04 registrationProfile04) {
        this.registrationProfile04 = registrationProfile04;
    }
    
    
}
