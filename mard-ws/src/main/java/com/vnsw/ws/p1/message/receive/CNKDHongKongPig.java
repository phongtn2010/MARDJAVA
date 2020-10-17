package com.vnsw.ws.p1.message.receive;

import com.vnsw.ws.p1.entity.receive.AnimailProductHKP;
import com.vnsw.ws.util.DateSerialization;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "CertificateHongKongPig")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CNKDHongKongPig {

    @XmlElement(name = "HealthCertificateNoVni")
    private String fiHealthCertificateNoVni;

    @XmlElement(name = "DepartmentCode")
    private String fiDepartmentCode;

    @XmlElement(name = "DepartmentNameVni")
    private String fiDepartmentNameVni;

    @XmlElement(name = "DepartmentName")
    private String fiDepartmentName;

    @XmlElement(name = "ConsignerName")
    private String fiConsignerName;

    @XmlElement(name = "ConsignerAdress")
    private String fiConsignerAdress;

    @XmlElement(name = "ConsigneeNameAddress")
    private String fiConsigneeNameAddress;

    @XmlElement(name = "SlaughterHouseNameAddress")
    private String fiSlaughterHouseNameAddress;

    @XmlElement(name = "HealthCertificate")
    private String fiHealthCertificate;

    @XmlElement(name = "Note")
    private String fiNote;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignResultDate")
    private Date fiSignResultDate;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "HealthCertificateEndDate")
    private Date fiHealthCertificateEndDate;

    @XmlElement(name = "SignResultName")
    private String fiSignResultName;

    @XmlElementWrapper(name = "AnimalProductList")
    @XmlElement(name = "AnimalProduct")
    private List<AnimailProductHKP> fiAnimalProductList;
}
