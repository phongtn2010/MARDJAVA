package com.vnsw.ws.p26.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlType(name = "ApplicationCancel")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ThuHoiCVMienKiem {
    @XmlElement(name = "NSWFileCode")
    private String fiMaHoso;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayThuHoi;
    @XmlElement(name = "Reason")
    private String fiLyDoThuHoi;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayKy;
    @XmlElement(name = "SignConfirmName")
    private String fiNguoiKy;
    @XmlElement(name = "ConfirmApplicationNo")
    private String fiSoCVMienKiem;
    @XmlElement(name = "AttachmentId")
    private String fiFileId;
    @XmlElement(name = "FileName")
    private String fiFileName;
    @XmlElement(name = "FileLink")
    private String fiFileLink;
}
