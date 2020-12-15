/*
 * Created on 18 Jul 2017 ( Time 08:39:33 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 
package com.nsw.mard.p8.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Tbdcvcnkd08 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fiIdCV;

    private String fiHSCode;

    private Date fiHSCreatedDate;

    private String fiQuarantineNo;

    private String fiDispatchNo;

    private String fiVetHygieneNo;

    private Integer fiQuarantineType;

    private String fiSummary;

    private String fiPreamble;

    private String fiReportInfo;

    private String fiContent;

    private String fiExecutionTime;

    private String fiPurpose;

    private String fiRecipient;

    private Date fiDispatchExpires;

    private String fiSignConfirmAddress;

    private Date fiSignConfirmDate;

    private String fiSignConfirmName;

    private String fiSignConfirmTitle;

    private String fiEditReason;

    private Integer fiDispatchType;

    private String fiLinkFile;

    private List<Tbdcnkdhanghoa08> lstProduct;

    private List<Tbdcnkdctyxk08> lstCompany;

    private List<Tbdcnkdnmsx08> lstMfr;

    private List<Tbdcnkdddcl08> lstIsoLoc;

    public Tbdcvcnkd08() {
        lstProduct = new ArrayList<>();
        lstCompany = new ArrayList<>();
        lstMfr = new ArrayList<>();
        lstIsoLoc = new ArrayList<>();
    }
}