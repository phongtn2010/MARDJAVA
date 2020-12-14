package com.nsw.mard.p25.model;


import lombok.Data;
import java.util.Date;


@Data

public class TbdYcrut25 {
    private static final long serialVersionUID = 1L;

    public static final String SEQUENCE_NAME = "TBDYCRUT25_SEQ";

    private Integer fiRequestId;

    private Integer fiIdHS;


    private String fiNSWFileCode;


    private Date fiRequestedDate;

    private Integer fiActive;


    private Integer fiStatus;


    private String fiReason;


    private Integer fiRequestType;


    private String fiReasonMard;


    private Date fiProcessedDate;


    private String fiProcessingUnit;

    private String fiProcessor;

    private String fiSigner;

    public TbdYcrut25() {
        super();
    }

}
