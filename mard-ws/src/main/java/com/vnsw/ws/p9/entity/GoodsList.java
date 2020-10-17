package com.vnsw.ws.p9.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "GoodsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class GoodsList {
    @XmlElement(name = "Goods")
    private List<Goods> goods;

    public GoodsList(List<Goods> goods) {
        this.goods = goods;
    }

    public GoodsList() {
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
