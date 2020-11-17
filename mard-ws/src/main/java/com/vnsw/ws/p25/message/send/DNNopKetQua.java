package com.vnsw.ws.p25.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p25.entity.receive.AttachmentResult;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "SendResultTest")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DNNopKetQua {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlElement(name = "AssignCode")
    String fiDVXLCode;
    @XmlElement(name = "AssignName")
    String fiDVXLName;

    @XmlElement(name = "GoodsId")
    String fiProId;
    @XmlElement(name = "NameOfGoods")
    String fiProName;
    @XmlElement(name = "ResultTest")
    Integer fiLoaiKQDG;

    @XmlElement(name = "TestConfirmNumber")
    String fiSoGCN;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TestConfirmDate")
    Date fiNgayDG;

    @XmlElement(name = "TestConfirmAttachmentId")
    String fiIDFileGCN;
    @XmlElement(name = "TestConfirmFileName")
    String fiNameGCN;
    @XmlElement(name = "TestConfirmFileLink")
    String fiLinkGCN;

    @XmlElementWrapper(name = "AttachmentResultList")
    @XmlElement(name = "AttachmentResult")
    private List<AttachmentResult> fiListDinhKem;
}
