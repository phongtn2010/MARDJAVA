package com.vnsw.ws.p9.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "GoodsListXNCL")
@XmlAccessorType(XmlAccessType.FIELD)
public class GoodsXNCLList {
    @XmlElement(name = "Goods")
    private List<GoodsXNCL> goods;

    public GoodsXNCLList(List<GoodsXNCL> goods) {
        this.goods = goods;
    }

    public GoodsXNCLList() {
    }

    public List<GoodsXNCL> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsXNCL> goods) {
        this.goods = goods;
    }
}
