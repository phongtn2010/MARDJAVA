package com.vnsw.ws.p9.entity;


import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AttachmentXacNhanPhi {
    @XmlElement(name = "FileName")
    private String fiFileName;

    @XmlElement(name = "FileByte")
    private String fiFileByte;
}
