package com.nsw.mard.p6.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TbdCongvan06 implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDCONGVAN06_SEQ";

    private Integer fiIdCV;

    private Integer fiIdHS;

    private String fiNSWFileCode;

    private String fiDispatchNo;

    private Integer fiDispatchType;

    private Date fiDispatchDate;

    private String fiDispatchAccountable;

    private String fiSummary;

    private String fiPreamble;

    private Integer fiProductType;

    private String fiBordergateName;

    private String fiPurpose;

    private Date fiTimeQuarantineFrom;

    private Date fiTimeQuarantineTo;

    private String fiTimeQuarantine;

    private String fiBaseOnReport;

    private String fiResponseContent;

    private String fiRecipient;

    private String fiSignPosition;

    private String fiSignConfirmName;

    private String fiSignConfirmAddress;

    private String fiReasonEdit;

    private String fiLinkFile;

    private List<TbdHanghoa06> fiProductList;

    private List<TbdCtyxk06> fiExporterCountryList;

    private List<TbdCssx06> fiProcessingList;

    private List<TbdDdclkd06> fiLocationQuarantineList;

    public TbdCongvan06() {
        super();
        fiProcessingList = new ArrayList<>();
        fiProductList = new ArrayList<>();
        fiLocationQuarantineList = new ArrayList<>();
        fiExporterCountryList = new ArrayList<>();
    }
}
