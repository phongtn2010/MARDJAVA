package com.nsw.backend.mard.p09.client;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class XacNhanDon {
    private String fiRegistrationComfirmNo;
    private String fiQuarantineLocationName;
    private Date fiMonitoringLocationTimeFrom;
    private Date fiMonitoringLocationTimeTo;

    private List<Ananytical> fiAnanyticalRequiredList;
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

    public List<Ananytical> getFiAnanyticalRequiredList() {
        if(fiAnanyticalRequiredList == null){
            fiAnanyticalRequiredList = new ArrayList<>();
        }
        return fiAnanyticalRequiredList;
    }

}
