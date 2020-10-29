package com.vnsw.ws.p25.message.send;

import com.vnsw.ws.p25.entity.receive.Goods;
import com.vnsw.ws.p25.entity.send.Product;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType(name = "TestInformation")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GuiHSTCCD {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;
    @XmlElement(name = "AssignCode")
    String fiIdDVXL;
    @XmlElement(name = "AssignName")
    String fiNameDVXL;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    List<Product> fiProductList;
}
