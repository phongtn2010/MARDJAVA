package com.vnsw.ws.p25.entity.send;

import com.vnsw.ws.annotations.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.sql.Date;


@XmlType(name = "Contract")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TbdattachHd25 implements Serializable {
    @XmlElement(name = "ContractNo")
    private String fiSoHd;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ContractDate")
    private Date fiNgayHd;
    @XmlElement(name = "ContractAttachmentId")
    private Long fiIdFile;
    @XmlElement(name = "ContractName")
    private String fiFileName;
    @XmlElement(name = "ContractFileLink")
    private String fiFileLink;

}
