package com.vnsw.ws.p1.message.receive;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "NotificationFailed")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CVKQYCXuatKhau01 {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "DispatchContent")
    private String fiDispatchContent;

    @XmlElement(name = "FileName")
    private String fiFileName;

    @XmlElement(name = "DispatchFile")
    private String fiDispatchFile;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    @XmlElement(name = "LinkFile")
    private String fiLinkFile;
}
