/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnsw.ws.p8.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "QuarantineResult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class KetQuaThamDinh {
    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "Reason")
    private String fiReason;
    
    @XmlElement(name = "ResultDate")
    @XmlJavaTypeAdapter(DateSerialization.class)
    private Date fiResultDate;
    
    @XmlElement(name = "Department")
    private String fiDepartment;
    
    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

}
