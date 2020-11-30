package com.vnsw.ws.p26.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p26.entity.send.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AniFeed")
@Data
public class Hoso26 {
    @XmlElement(name = "NSWFileCode")
    String fiMaHoso;
    @XmlElement(name = "Organization")
    private String fiTenDn;
    @XmlElement(name = "TaxCode")
    private String fiMasothue;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    private Date fiNgayKy;
    @XmlElement(name = "SignPlace")
    private String fiDiadiemKy;

    @XmlElement(name = "Address")
    private String fiDiachiDn;

    @XmlElement(name = "Phone")
    private String fiSdtDn;

    @XmlElement(name = "Fax")
    private String fiFaxDn;
    @XmlElement(name = "DepartmentCode")
    String DepartmentCode;

    @XmlElement(name = "DepartmentName")
    String DepartmentName;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<TbdHanghoa26> fiProductList;

    @XmlElement(name = "SignName")
    private String fiNguoiKy;
}
