package com.vnsw.ws.p8.message.receive;


import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p8.entity.AnimalVSTY;
import com.vnsw.ws.p8.entity.LocationQuarantine;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "VeterinaryHygiene")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class CongVanVSTY {
    @XmlElement(name = "NSWFileCode")
    private String fiNSWFileCode;

    @XmlElement(name = "DispatchNo")
    private String fiDispatchNo;

    @XmlElement(name = "Summary")
    private String fiSummary;

    @XmlElement(name = "Preamble")
    private String fiPreamble;

    @XmlElementWrapper(name = "AnimalList")
    @XmlElement(name = "Animal")
    private List<AnimalVSTY> fiAnimalList;

    @XmlElementWrapper(name = "LocationQuarantineList")
    @XmlElement(name = "LocationQuarantine")
    private List<LocationQuarantine> fiLocationQuarantineList;

    @XmlElement(name = "ProductCompany")
    private String fiProductCompany;

    @XmlElement(name = "ProductCompanyAddress")
    private String fiProductCompanyAddress;

    @XmlElement(name = "AnimalExecutionTime")
    private String fiAnimalExecutionTime;

    @XmlElement(name = "AnimalPurpose")
    private String fiAnimalPurpose;

    @XmlElement(name = "AnimalIsolatedPlace")
    private String fiAnimalIsolatedPlace;

    @XmlElement(name = "ResponseContent")
    private String fiResponseContent;

    @XmlElement(name = "Recipient")
    private String fiRecipient;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiSignConfirmDate;

    @XmlElement(name = "SignConfirmName")
    private String fiSignConfirmName;

    @XmlElement(name = "SignConfirmAddress")
    private String fiSignConfirmAddress;

    @XmlElement(name = "SignerRole")
    private String fiSignerRole;

    @XmlElement(name = "ReasonEdit")
    private String fiReasonEdit;

}
