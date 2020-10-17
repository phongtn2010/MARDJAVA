package com.nsw.backend.mard.p08.client;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class VeterinaryHygiene implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fiNSWFileCode;

    private String fiDispatchNo;
    private String fiSummary;
    private String fiPreamble;

    private List<Animal> fiAnimalList;
    private List<LocationQuarantine> fiLocationQuarantineList;

    private String fiProductCompany;
    private String fiProductCompanyAddress;
    private String fiAnimalExecutionTime;
    private String fiAnimalPurpose;
    private String fiResponseContent;
    private String fiRecipient;
    private Date fiSignConfirmDate;
    private String fiSignConfirmName;
    private String fiSignConfirmAddress;
    private String fiSignerRole;
    private String fiReasonEdit;

    private String fiLinkFile;
}
