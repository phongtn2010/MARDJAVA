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
    String fiSoGXN;
    @XmlElement(name = "DepartmentCode")
    String fiIdCqxl;
    @XmlElement(name = "DepartmentName")
    String fiNameCqxl;

    @XmlElement(name = "AssignID")
    String fiIdCqcd;
    @XmlElement(name = "AssignName")
    String fiNameCqcd;
    @XmlElement(name = "AssignNameOther")
    String fiDvdg;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    Date fiNgayXN;
    @XmlElement(name = "SignConfirmPlace")
    String fiNoiXN;
    @XmlElement(name = "SignConfirmName")
    String fiNguoiXN;
    @XmlElement(name = "NSWFileCodeOld")
    String fiNSWFileCodeOld;
    @XmlElement(name = "AniFeedConfirmOldNo")
    String fiAniFeedConfirmOldNo;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    List<Product> fiProductList;

    @XmlElement(name = "NoteGoods")
    String fiGhiChu;
}
