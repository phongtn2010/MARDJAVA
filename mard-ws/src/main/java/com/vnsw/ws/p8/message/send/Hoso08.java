package com.vnsw.ws.p8.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p8.entity.Attachment;
import com.vnsw.ws.p8.entity.json.AnimalRegistration;
import com.vnsw.ws.p8.entity.json.BoneMealRegistration;
import com.vnsw.ws.p8.entity.json.ProductRegistration;
import com.vnsw.ws.p8.entity.json.QualityRegistration;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;


@XmlType(name = "Registration")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Hoso08 {

    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "NameOfRegistration")
    private String fiNameOfRegistration;

    @XmlElement(name = "AddressOfRegistration")
    private String fiAddressOfRegistration;

    @XmlElement(name = "Tel")
    private String fiTel;

    @XmlElement(name = "Fax")
    private String fiFax;

    @XmlElement(name = "Email")
    private String fiEmail;

    @XmlElement(name = "ProductType")
    private String fiProductType;

    @XmlElement(name = "RegistrationType")
    private String fiRegistrationType;

    @XmlElement(name = "AnimalRegistration")
    private AnimalRegistration fiAnimalRegistration;

    @XmlElement(name = "ProductRegistration")
    private ProductRegistration fiProductRegistration;

    @XmlElement(name = "BoneMealRegistration")
    private BoneMealRegistration fiBoneMealRegistration;

    @XmlElement(name = "QualityRegistration")
    private QualityRegistration fiQualityRegistration;

    @XmlElement(name = "SignAddress")
    private String fiSignAddress;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    private Date fiSignDate;

    @XmlElement(name = "SignName")
    private String fiSignName;

    @XmlElement(name = "SignerRole")
    private String fiSignerRole;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    private List<Attachment> fiAttachmentList;

}
