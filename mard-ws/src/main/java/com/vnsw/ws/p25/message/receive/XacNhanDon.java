package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p25.entity.receive.Goods;
import com.vnsw.ws.p25.entity.send.Product;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultConfirm")
@Data
public class XacNhanDon {

    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlElement(name = "AniFeedConfirmNo")
    String fiAniFeedConfirmNo;
    @XmlElement(name = "DepartmentCode")
    String DepartmentCode;
    @XmlElement(name = "DepartmentName")
    String DepartmentName;

    @XmlElement(name = "AssignID")
    String fiAssignID;
    @XmlElement(name = "AssignName")
    String fiAssignName;
    @XmlElement(name = "AssignNameOther")
    String fiAssignNameOther;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    Date fiSignConfirmDate;
    @XmlElement(name = "SignConfirmPlace")
    String fiSignConfirmPlace;
    @XmlElement(name = "SignConfirmName")
    String fiSignName;
    @XmlElement(name = "NSWFileCodeOld")
    String fiNSWFileCodeOld;
    @XmlElement(name = "AniFeedConfirmOldNo")
    String fiAniFeedConfirmOldNo;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    List<Product> fiProductList;

    @XmlElement(name = "NoteGoods")
    String fiNoteGoods;
}
