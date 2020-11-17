package com.vnsw.ws.p26.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p26.entity.send.TbdHanghoa26;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "ApplicationReplies")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CVMienKiem {
    @XmlElement(name = "NSWFileCode")
    String fiMaHoso;
    @XmlElement(name = "ConfirmApplicationNo")
    String fiSoCVMienKiem;
    @XmlElement(name = "Organization")
    private String fiTenDn;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiNgayKyCV;
    @XmlElement(name = "SignConfirmPlace")
    private String fiNoiKyCV;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    private Date fiNgaytao;
    @XmlElement(name = "DepartmentCode")
    String DepartmentCode;
    @XmlElement(name = "DepartmentName")
    String DepartmentName;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<TbdHanghoa26> fiProductList;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "PeriodFrom")
    private Date fiHieuLucTuNgay;
    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "PeriodTo")
    private Date fiHieuLucToiNgay;
    @XmlElement(name = "SignName")
    private String fiTenNguoiKyCV;
}
