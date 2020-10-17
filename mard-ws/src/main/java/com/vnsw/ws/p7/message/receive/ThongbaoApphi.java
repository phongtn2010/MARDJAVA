package com.vnsw.ws.p7.message.receive;


import com.vnsw.ws.annotations.DoubleSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "PhytosanitaryFee")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ThongbaoApphi {
    @XmlElement(name = "Type")
    Integer fiType;

    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "TotalFee")
    Double fiTotalFee;

    @XmlElement(name = "TotalFeeText")
    String fiTotalFeeText;

    @XmlElement(name = "Note")
    String fiNote;

    @XmlElement(name = "Department")
    String fiDepartment;

    @XmlElement(name = "CreaterName")
    String fiCreaterName;

}
