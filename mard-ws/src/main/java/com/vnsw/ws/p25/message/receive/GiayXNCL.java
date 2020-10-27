package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p25.entity.receive.Goods;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlType(name = "ResultCheck")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GiayXNCL {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlElement(name = "DepartmentCode")
    String fiMaCQKT;
    @XmlElement(name = "DepartmentName")
    String fiTenCQKT;
    @XmlElement(name = "SignCerPlace")
    String fiNoiKy;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignCerDate")
    String fiNgayKy;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Product")
    List<Goods> fiProductList;
    @XmlElement(name = "Note")
    String fiNote;
    @XmlElement(name = "PortOfDestinationName")
    String fiNoiNhanHang;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingFromDate")
    String fiNhapKhauFrom;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingToDate")
    String fiNhapKhauTo;

}
