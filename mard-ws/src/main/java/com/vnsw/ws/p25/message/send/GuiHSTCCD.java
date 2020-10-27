package com.vnsw.ws.p25.message.send;

import com.vnsw.ws.p25.entity.receive.Goods;
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
    String fiAssignCode;
    @XmlElement(name = "AssignName")
    String fiAssignName;
    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Good")
    List<Goods> fiHangHoaList;
}
