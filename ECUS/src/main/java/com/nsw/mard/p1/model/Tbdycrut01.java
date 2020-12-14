package com.nsw.mard.p1.model;
import lombok.Data;


import java.util.Date;

@Data
public class Tbdycrut01  {

    private static final long serialVersionUID = 1L;
    public static final String SEQUENCE_NAME = "TBDYCRUT01_SEQ";
    private Long fiIDYCRUT;
    private String fiNSWFileCode;

    private Date fiRequestDate;

    private String fiReason;

}
