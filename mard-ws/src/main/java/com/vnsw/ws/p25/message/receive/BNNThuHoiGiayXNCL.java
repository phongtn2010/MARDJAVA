package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "AniFeedResultCertificateCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BNNThuHoiGiayXNCL {
    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "CancelDate")
    private Date fiNgayHuy;
    @XmlElement(name = "Reason")
    private String fiLyDo;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayKy;
    @XmlElement(name = "SignConfirmName")
    private String fiNguoiKy;
    @XmlElement(name = "AniFeedConfirmNo")
    private Long fiSoGDKCuaBNN;
    @XmlElement(name = "AttachmentId")
    private String fiFileID;
    @XmlElement(name = "FileName")
    private String fiFileName;
    @XmlElement(name = "FileLink")
    private String fiFileLink;

}
