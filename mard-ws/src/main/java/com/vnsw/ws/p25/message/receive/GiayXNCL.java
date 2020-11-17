package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p25.entity.receive.Goods;
import com.vnsw.ws.p25.entity.send.Product;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
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

    @XmlElement(name = "CerNumber")
    String fiSoGCN;
    @XmlElement(name = "SignCerPlace")
    String fiNoiKy;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignCerDate")
    Date fiNgayKy;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    List<Product> fiProductList;
    @XmlElement(name = "PortOfDestinationName")
    String fiNoiNhanHang;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingFromDate")
    Date fiNhapKhauFrom;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportingToDate")
    Date fiNhapKhauTo;

    @XmlElement(name = "AniFeedConfirmNo")
    String fiSoGDK ;
    @XmlElement(name = "ImportCerNo")
    String fiGCNHopQuy;
    @XmlElement(name = "AssignCode")
    String fiIDCoQuanDanhGia;
    @XmlElement(name = "AssignName")
    String fiNameCoQuanDanhGia;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "ImportCerDate")
    Date fiNgayCap;
    @XmlElement(name = "SignCerName")
    String fiNguoiKy;
}
