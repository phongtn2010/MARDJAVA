package com.vnsw.ws.p25.entity.send;

import com.vnsw.ws.p25.entity.receive.Ananytical;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "Good")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class HangHoaChiTieu {
    @XmlElement(name = "GoodsId")
    private String fiIdProduct;

    @XmlElement(name = "NameOfGoods")
    private String fiProName;
    @XmlElement(name = "GroupFoodOfGoods")
    private String fiProIdNhom;

    @XmlElement(name = "GoodTypeId")
    private String fiProIdLoai;

    @XmlElement(name = "GoodTypeName")
    private String fiProNameLoai;

    @XmlElementWrapper(name = "AnanyticalRequiredList")
    @XmlElement(name = "Ananytical")
    private List<Ananytical> fiListChiTieu;
}
