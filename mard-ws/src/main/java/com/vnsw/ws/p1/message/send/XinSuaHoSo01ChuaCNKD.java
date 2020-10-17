package com.vnsw.ws.p1.message.send;

import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "RequestEdit")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class XinSuaHoSo01ChuaCNKD {

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlElement(name = "RegistrationProfile")
    private Hoso01 fiRegistrationProfile;
}
