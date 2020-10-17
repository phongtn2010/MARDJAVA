package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DoubleSerialization;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlType(name = "RequestUpdate")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ThongBaoApPhiBoXung {
    @XmlJavaTypeAdapter(DoubleSerialization.class)
    @XmlElement(name = "TotalFee")
    private Double fiTotalFee;

    @XmlElement(name = "AmountInWords")
    private String fiAmountInWords;

    @XmlElement(name = "Note")
    private String fiNote;

    @XmlElement(name = "Department")
    private String fiDepartment;

    @XmlElement(name = "CreaterName")
    private String fiCreaterName;
}