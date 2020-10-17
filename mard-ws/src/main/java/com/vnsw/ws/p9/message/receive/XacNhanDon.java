package com.vnsw.ws.p9.message.receive;

import com.vnsw.ws.annotations.DateSerialization;
import com.vnsw.ws.p9.entity.Ananytical;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlType(name = "RegistrationComfirm")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class XacNhanDon {

    @XmlElement(name = "RegistrationComfirmNo")
    private String fiRegistrationComfirmNo;

    @XmlElement(name = "QuarantineLocationName")
    private String fiQuarantineLocationName;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "MonitoringLocationTimeFrom")
    private Date fiMonitoringLocationTimeFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "MonitoringLocationTimeTo")
    private Date fiMonitoringLocationTimeTo;

    @XmlElementWrapper(name = "AnanyticalRequiredList")
    @XmlElement(name = "Ananytical")
    private List<Ananytical> fiAnanyticalRequiredList;

    @XmlElement(name = "InspectionType")
    private int fiInspectionType;

    @XmlElement(name = "NoticeOfExemptionFromInspectionNo")
    private String fiNoticeOfExemptionFromInspectionNo;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfTestingFrom")
    private Date fiDateOfTestingFrom;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfTestingTo")
    private Date fiDateOfTestingTo;

    @XmlElement(name = "UnitOfTesting")
    private String fiUnitOfTesting;

    @XmlElement(name = "AssignCode")
    private String fiAssignCode;

    @XmlElement(name = "AssignName")
    private String fiAssignName;

    @XmlElement(name = "LocationOfSamplingConfirm")
    private String fiLocationOfSamplingConfirm;

    @XmlElement(name = "TimeOfSamplingConfirm")
    private String fiTimeOfSamplingConfirm;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "DateOfSamplingConfirm")
    private Date fiDateOfSamplingConfirm;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDate")
    private Date fiSignConfirmDate;

    @XmlElement(name = "SignConfirmName")
    private String fiSignConfirmName;

    @XmlElement(name = "SignConfirmAddress")
    private String fiSignConfirmAddress;

    @XmlElement(name = "RejectionReason")
    private String fiRejectionReason;

    @XmlJavaTypeAdapter(DateSerialization.class)
    @XmlElement(name = "SignConfirmDateOfCustoms")
    private Date fiSignConfirmDateOfCustoms;

    @XmlElement(name = "SignConfirmNameOfCustoms")
    private String fiSignConfirmNameOfCustoms;

    @XmlElement(name = "SignConfirmAddressOfCustoms")
    private String fiSignConfirmAddressOfCustoms;

    public XacNhanDon() {
    }

}
