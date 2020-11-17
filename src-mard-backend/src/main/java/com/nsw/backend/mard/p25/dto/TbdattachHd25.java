package com.nsw.backend.mard.p25.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;



@Data
public class TbdattachHd25 implements Serializable {

    private String fiSoHd;

    private Date fiNgayHd;

    private String fiIdFile;

    private String fiFileName;

    private String fiFileLink;

}
