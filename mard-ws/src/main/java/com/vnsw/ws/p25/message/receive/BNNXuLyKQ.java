package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ResultResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BNNXuLyKQ {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;
    @XmlElement(name = "GoodsId")
    private Integer fiMaHangHoa;
    @XmlElement(name = "NameOfGoods")
    private String fiTenHangHoa;
    @XmlElement(name = "Reason")
    private String fiLyDo;
    @XmlElement(name = "AttachmentId")
    private String fiFileId;
    @XmlElement(name = "FileName")
    private String fiFileName;
    @XmlElement(name = "FileLink")
    private String fiFileLink;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ResponseDate")
    private Date fiResponseDate;
    @XmlElement(name = "NameOfStaff")
    private String fiNameOfStaff;
}
