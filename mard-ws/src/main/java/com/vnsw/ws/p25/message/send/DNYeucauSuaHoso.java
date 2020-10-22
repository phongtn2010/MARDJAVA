package com.vnsw.ws.p25.message.send;

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
public class DNYeucauSuaHoso {
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlElement(name = "RegistrationProfile")
    private Hoso25 fiRegistrationProfile;
}
