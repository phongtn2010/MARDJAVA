package com.vnsw.ws.p9.message.send;


import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p9.entity.Attachment;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "RequestEditCer")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DNYeuCauSuaGiayPhep {

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;

    @XmlElement(name = "Reason")
    private String fiReason;

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "CertificateNo")
    private String fiCertificateNo;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name =  "Attachment")
    private List<Attachment> fiAttachmentList;

}
