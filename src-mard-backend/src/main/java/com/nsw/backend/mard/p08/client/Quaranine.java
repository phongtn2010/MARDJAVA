package com.nsw.backend.mard.p08.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Quaranine implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode; //*
    private String fiQuarantineNo;
    private String fiSummary;
    private String fiPreamble;
    private String fiReportInfo;
    private List<Goods> fiGoodsList;
    private List<Company> fiCompanyList;
    private List<Manufacturer> fiManufactureList;
    private List<LocationQuarantine> fiLocationQuarantineList;
    private String fiMealExecutionTime; //*
    private String fiMealPurpose; //*
    private String fiResponseContent; //*
    private Date fiDispatchExpires;
    private String fiRecipient;
    private Date fiSignConfirmDate;
    private String fiSignConfirmName;
    private String fiSignConfirmAddress;
    private String fiSignerRole;//* ---
    private String fiReasonEdit;//*
    private Integer fiProductType;//*

    private String fiLinkFile;

}
