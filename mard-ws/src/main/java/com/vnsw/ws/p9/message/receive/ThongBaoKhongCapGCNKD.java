package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p9.entity.Attachment;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "QualityNotHaveResult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ThongBaoKhongCapGCNKD {

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "RequestDate")
    private Date fiRequestDate;


    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    private List<Attachment> fiAttachmentList;

    @XmlElement(name = "Department")
    private String fiDepartment;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;

    @XmlElement(name = "Description")
    private String fiDescription;

    @XmlElement(name = "QualityResult")
    private String fiQualityResult;

    public ThongBaoKhongCapGCNKD() {
    }

}
