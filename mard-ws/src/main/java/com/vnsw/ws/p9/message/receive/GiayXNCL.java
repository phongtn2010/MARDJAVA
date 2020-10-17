package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p9.entity.GoodsXNCL;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "QualityResult")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class GiayXNCL {

    @XmlElement(name = "RegistrationComfirmNo")
    private String fiRegistrationComfirmNo;

    @XmlElement(name = "QuanlityCerNo")
    private String fiQuanlityCerNo;

    @XmlElement(name = "DepartmentCode")
    private String fiDepartmentCode;

    @XmlElement(name = "DepartmentName")
    private String fiDepartmentName;

    @XmlElement(name = "DepartmentAddress")
    private String fiDepartmentAddress;

    @XmlElement(name = "DepartmentPhone")
    private String fiDepartmentPhone;

    @XmlElement(name = "DepartmentFax")
    private String fiDepartmentFax;

    @XmlElement(name = "SellerStateCode")
    private String fiSellerStateCode;

    @XmlElement(name = "SellerStateName")
    private String fiSellerStateName;

    @XmlElement(name = "SellerAddress")
    private String fiSellerAddress;

    @XmlElement(name = "SellerPhone")
    private String fiSellerPhone;

    @XmlElement(name = "SellerFax")
    private String fiSellerFax;

    @XmlElement(name = "PortOfDepartureName")
    private String fiPortOfDepartureName;

    @XmlElement(name = "BuyerName")
    private String fiBuyerName;

    @XmlElement(name = "BuyerAddress")
    private String fiBuyerAddress;

    @XmlElement(name = "BuyerPhone")
    private String fiBuyerPhone;

    @XmlElement(name = "BuyerFax")
    private String fiBuyerFax;

    @XmlElement(name = "PortOfDestinationCode")
    private String fiPortOfDestinationCode;

    @XmlElement(name = "PortOfDestinationName")
    private String fiPortOfDestinationName;

    @XmlElementWrapper(name = "GoodsList")
    @XmlElement(name = "Goods")
    private List<GoodsXNCL> fiGoodsList;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignResultDate")
    private Date fiSignResultDate;

    @XmlElement(name = "SignResultName")
    private String fiSignResultName;

    @XmlElement(name = "SignResultAddress")
    private String fiSignResultAddress;

    @XmlElement(name = "LinkFile")
    private String fiLinkFile;

    @XmlElement(name = "ParentDepartmentName")
    private String fiParentDepartmentName;
}
