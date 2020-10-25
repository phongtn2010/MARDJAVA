package com.vnsw.ws.p25.message.receive;

import com.vnsw.ws.p25.entity.QuantityVolume;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "Goods")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Goods {
    @XmlElement(name = "GoodsId")
    private String fiGoodsId;

    @XmlElement(name = "NameOfGoods")
    private String fiNameOfGoods;

    @XmlElement(name = "GoodTypeId")
    private String fiGoodTypeId;

    @XmlElement(name = "GoodTypeName")
    private String fiGoodTypeName;

    @XmlElement(name = "Nature")
    private String fiNature;

    @XmlElementWrapper(name = "AnanyticalRequiredList")
    @XmlElement(name = "AnanyticalRequired")
    private List<QuantityVolume> fiAnanyticalRequiredList;
}
