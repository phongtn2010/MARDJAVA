package com.vnsw.ws.p7.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "RequestEdit")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DnYeucauSuaHoso {
    
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    Date fiRequestDate;

    @XmlElement(name = "Reason")
    String fiReason;

    @XmlElement(name = "RegistrationProfile")
    RegistrationProfile fiRegistrationProfile;
}
