package com.vnsw.ws.p6.message.send;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p6.entity.*;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "RegistrationProfile")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Hoso06 {
    @XmlElement(name = "NSWFileCode")
    String fiNSWFileCode;

    @XmlElement(name = "ImporterName")
    String fiImporterName;

    @XmlElement(name = "ImporterTel")
    String fiImporterTel;

    @XmlElement(name = "ImporterAddress")
    String fiImporterAddress;

    @XmlElement(name = "ImporterFax")
    String fiImporterFax;

    @XmlElement(name = "ImporterEmail")
    String fiImporterEmail;

    @XmlElement(name = "ProductType")
    Integer fiProductType;

    @XmlElementWrapper(name = "ProductList")
    @XmlElement(name = "Product")
    List<Product> fiProductList;

    @XmlElementWrapper(name = "ExporterCountryList")
    @XmlElement(name = "ExporterCountry")
    List<ExporterCountry> fiExporterCountryList;

    @XmlElementWrapper(name = "ProcessingList")
    @XmlElement(name = "Processing")
    List<Processing> fiProcessingList;

    @XmlElement(name  = "BordergateName")
    String fiBordergateName;

    @XmlElement(name  = "TimeQuarantine")
    String fiTimeQuarantine;

    @XmlElement(name  = "Purpose")
    String fiPurpose;

    @XmlElementWrapper(name = "LocationQuarantineList")
    @XmlElement(name = "LocationQuarantine")
    List<LocationQuarantine> fiLocationQuarantineList;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TimeQuarantineFrom")
    Date fiTimeQuarantineFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "TimeQuarantineTo")
    Date fiTimeQuarantineTo;

    @XmlElement(name = "SignAddress")
    String fiSignAddress;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignDate")
    Date fiSignDate;

    @XmlElement(name = "SignName")
    String fiSignName;

    @XmlElement(name = "SignPosition")
    String fiSignPosition;

    @XmlElement(name = "RelatedDocuments")
    String fiRelatedDocuments;

    @XmlElementWrapper(name = "AttachmentList")
    @XmlElement(name = "Attachment")
    List<Attachment> fiAttachmentList;

}
