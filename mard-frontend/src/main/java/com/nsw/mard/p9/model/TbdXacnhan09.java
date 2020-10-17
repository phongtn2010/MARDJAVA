package com.nsw.mard.p9.model;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TbdXacnhan09 extends CmonBaseEntity implements Serializable {
    //MAU 03
    private Long fiIdConfirmation;
    private String fiNSWFileCode;
    private String fiRegistrationComfirmNo;
    private String fiQuarantineLocationName;
    private Date fiMonitoringLocationTimeFrom;
    private Date fiMonitoringLocationTimeTo;

    //20A
    private int fiInspectionType;
    private String fiNoticeOfExemptionFromInspectionNo;
    private Date fiDateOfTestingFrom;
    private Date fiDateOfTestingTo;
    private String fiUnitOfTesting;
    private String fiAssignCode;
    private String fiAssignName;
    private String fiLocationOfSamplingConfirm;
    private String fiTimeOfSamplingConfirm;
    private Date fiDateOfSamplingConfirm;
    private Date fiSignConfirmDate;

    private String fiSignConfirmName;
    private String fiSignConfirmAddress;
    private String fiRejectionReason;
    private Date fiSignConfirmDateOfCustoms;
    private String fiSignConfirmNameOfCustoms;
    private String fiSignConfirmAddressOfCustoms;

    private List<TdbXnChitieu09> fiAnanyticalRequiredList;

    public TbdXacnhan09() {
        super();
        fiAnanyticalRequiredList = new ArrayList<>();
    }
}
